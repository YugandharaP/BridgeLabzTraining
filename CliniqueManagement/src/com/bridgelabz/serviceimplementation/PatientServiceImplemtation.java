package com.bridgelabz.serviceimplementation;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.bridgelabz.controller.CliniqueManager;
import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.service.PatientService;
import com.bridgelabz.utility.Utility;

/**purpose-To perform function such as searchPatientByName() ,searchPatientById() ,searchPatientByMobileNumber(),takeAppointment()
 * @author yuga
 */
public class PatientServiceImplemtation implements PatientService {
	static ArrayList<Patient> patientList = new ArrayList<>();

	public PatientServiceImplemtation(String patientFilePath) {
		patientList = Utility.convertJsonToList(patientFilePath, Patient.class);
	}

	public CliniqueManagerImplementation manager = new CliniqueManagerImplementation();
	public DoctorServiceImplementation doctorImpl = new DoctorServiceImplementation();
	Appointment appointment=null;
	//Patient patient=new Patient();
	//Doctor doctor=new Doctor();
	
	/**To print patient details
	 */
	@Override
	public void printPatientDetails() {
		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader(CliniqueManager.PATIENT_FILE_PATH));
			JSONArray patientArray = (JSONArray) object;
			for (int i = 0; i < patientArray.size(); i++) {
				JSONObject details = (JSONObject) patientArray.get(i);
				System.out.println("index : " + i + " " + details);
			}
		} catch (IOException | ParseException e) {
			System.out.println("JSON file not fetched successfully");		}

	}

	/**To search patient ByName
	 */
	@Override
	public Patient searchPatientByName() {
		System.out.println("Enter patient name:");
		String searchName = Utility.retNext();
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getPatientName().equals(searchName)) {
				return patientList.get(i);
			}
		}
		return null;
	}

	/**To search patient ById
	 */
	@Override
	public Patient searchPatientById() {
		System.out.println("Enter patient ID:");
		long pateintId = Utility.readLong();
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getpId() == pateintId) {
				return patientList.get(i);
			}
		}
		return null;
	}

	/**To search patient ByMobileNumber
	 */
	@Override
	public Patient searchPatientByMobileNumber() {
		System.out.println("Enter Mobile number:");
		long mobile = Utility.readLong();
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getMobileNumber() == mobile) {
				return patientList.get(i);
			}
		}
		return null;
	}

	/**To takeAppointment of pateint and assign doctor if available.
	 */
	@Override
	public void takeAppointment() {
		//appointment=new Appointment();
		Patient patient=null ;
		
		System.out.println("Enter your mobile number: ");
		long mobile = Utility.readLong();
		
			for (int i = 0; i < patientList.size(); i++) 
			{
				if (PatientServiceImplemtation.patientList.get(i).getMobileNumber() == mobile)
				{
					patient = PatientServiceImplemtation.patientList.get(i);
				}
			}
		if (patient == null) {
			patient = manager.addPatient(mobile);
		}
		ArrayList<Doctor> specializedDoctorList = new ArrayList<>();
		System.out.println("Enter which specialized doctor you want?");
		String doctorSpecialization = Utility.retNext();
		//searching specialization and store in specializationList
		specializedDoctorList = doctorImpl.searchDoctorBySpecialization(specializedDoctorList, doctorSpecialization);
		//System.out.println(specializedDoctorList);
		System.out.println("Enter the required time slot in AM/PM");
		String timeslot = Utility.retNext();
		ArrayList<Doctor> DoctorperiodList = new ArrayList<Doctor>();
		for (int i = 0; i < specializedDoctorList.size(); i++) {
			if (timeslot.equalsIgnoreCase(specializedDoctorList.get(i).getAvailable())
					|| ("BOTH").equalsIgnoreCase(specializedDoctorList.get(i).getAvailable())) {
				DoctorperiodList.add(specializedDoctorList.get(i));
			}
		}
		if (DoctorperiodList.size() == 0) 
		{
			System.err.println("We don't have any doctor with respect to your given specialization and time.You can come some other day");
			CliniqueManager.doSelectOptions();
		} 
		else
		{
			System.out.println("Enter Id of the doctor to consult with,from the given options: ");
			//display doctor list here
			for (int i = 0; i < DoctorperiodList.size(); i++) 
			{
				System.out.println(DoctorperiodList.get(i));
			}
			long doctorId = Utility.readLong();
			for (int i = 0; i <DoctorperiodList.size(); i++) 
			{
				if (doctorId == DoctorperiodList.get(i).getDoctorId()) 
				{
					appointment=new Appointment();
					long patientCount = DoctorperiodList.get(i).getPatientCount();
					if (patientCount < 5 ) 
					{
						DoctorperiodList.get(i).setPatientCount(patientCount + 1);
						try {
							Utility.convertJavaToJson(DoctorServiceImplementation.doctorList, CliniqueManager.DOCTOR_FILE_PATH);
						} catch (IOException e1) {
							System.out.println("Data not store successfully");					
							}
						System.out.println("We are appointed Dr. " + DoctorperiodList.get(i).getDoctorName() + " to " + patient.getPatientName());
						appointment.setdId(doctorId);
						appointment.setDoctorName(DoctorperiodList.get(i).getDoctorName());
						appointment.setPatientName(patient.getPatientName());
						appointment.setpId(patient.getpId());
						appointment.setTimeStamp(Utility.getTimeStamp());
						CliniqueManagerImplementation.appointmentList.add(appointment);
						try {
							Utility.convertJavaToJson(CliniqueManagerImplementation.appointmentList, CliniqueManager.APPOINTMENT_FILE_PATH);
							System.out.println("you are appointed.Please wait outside.we will call you");
							CliniqueManager.doSelectOptions();
						} catch (IOException e) {
						System.out.println("Network issue.we are sorry for your coveniance.");
						}
						
					} 
					else 
					{
						System.out.println("Today doctor is not available.You can come tommorow");
						System.out.println(" you want to take appointment with other doctor yes[0]/no[1]");
						int option = Utility.reInteger();
						switch (option) 
						{
							case 0:
								takeAppointment();
								break;
							case 1:
								manager.close();
								break;
						}

					}
				}
				
			}

		}
		System.out.println("No such a doctor present");
		CliniqueManager.doSelectOptions();
	}

}
