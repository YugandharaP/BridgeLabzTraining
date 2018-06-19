package com.bridgelabz.serviceimplementation;

import java.io.IOException;
import java.util.ArrayList;

import com.bridgelabz.controller.CliniqueManager;
import com.bridgelabz.model.Appointment;
import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.service.CliniqueManagerService;
import com.bridgelabz.utility.Utility;

/**purpose-This is used to manage clinique process like add doctor details,deleteDoctor details,update doctor details
 * @author yuga
 *
 */
public class CliniqueManagerImplementation implements CliniqueManagerService {
	Doctor doctor = null;
	Patient patient = null;
	static ArrayList<Appointment> appointmentList = new ArrayList<>();

	public CliniqueManagerImplementation(String appointmentFilePath) {
		Utility.convertJsonToList(appointmentFilePath,appointmentList);
	}

	public CliniqueManagerImplementation() {
		
	}

	/**This function add doctor details and store in json file
	 */
	@Override
	public void addDoctor() {

		doctor = new Doctor();
		System.out.println("Enter Doctor Name: ");
		String doctorName = Utility.retNext();
		doctor.setDoctorName(doctorName);
		System.out.println("Doctor Id is here");
		long doctorId = Utility.getRandomDoubleBetweenRange(100, 1000);
		if (DoctorServiceImplementation.doctorList == null) {
			doctor.setDoctorId(doctorId);
		} else {
			for (int i = 0; i < DoctorServiceImplementation.doctorList.size(); i++) {

				if (doctorId == DoctorServiceImplementation.doctorList.get(i).getDoctorId()) {
					doctorId = Utility.getRandomDoubleBetweenRange(100, 1000);
					continue;
				}
			}
			doctor.setDoctorId(doctorId);
		}
		System.out.println(doctorId);
		System.out.println("Enter Specialization: ");
		String specialization = Utility.retNext();
		doctor.setSpecialization(specialization);
		System.out.println("Enter Availibility period in AM/PM or BOTH");
		String period = Utility.retNext();
		doctor.setAvailable(period);
		DoctorServiceImplementation.doctorList.add(doctor);
		try {
			Utility.convertJavaToJson(DoctorServiceImplementation.doctorList, CliniqueManager.DOCTOR_FILE_PATH);
			System.out.println("Doctor details added successfully!");
		} catch (IOException e) {
			System.out.println("Doctor details not added successfully");
		}
	}

	/**
	 * This function is used to delete doctor details from list */
	@Override
	public void deleteDoctor(int index) {
		try {
		DoctorServiceImplementation.doctorList.remove(index);
		System.out.println("Doctor details deleted successfully!");
		}catch(Exception e)
		{
			System.out.println("Doctor not present");
		}
		try {
			Utility.convertJavaToJson(DoctorServiceImplementation.doctorList, CliniqueManager.DOCTOR_FILE_PATH);
			//
		} catch (IOException e) {
			System.out.println("File not write");
		}
	}

	/**This function used to update the doctor details 
	 */
	@Override
	public void updateDoctor(int index) {
		System.out.println("What do you want to update ?");
		System.out.println("1. Doctor Specialization\t\t 2. Doctor Availabilty time");
		int option = Utility.reInteger();
		switch (option) {
		case 1:
			System.out.println("Enter new Specialization");
			String newSpecialization = Utility.retNext();
			DoctorServiceImplementation.doctorList.get(index).setSpecialization(newSpecialization);
			try {
				Utility.convertJavaToJson(DoctorServiceImplementation.doctorList, CliniqueManager.DOCTOR_FILE_PATH);
				System.out.println("Data updated successfully!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("Enter new TimeSlot");
			String newTimeSlot = Utility.retNext();
			DoctorServiceImplementation.doctorList.get(index).setAvailable(newTimeSlot);
			try {
				Utility.convertJavaToJson(DoctorServiceImplementation.doctorList, CliniqueManager.DOCTOR_FILE_PATH);
				System.out.println("Data updated successfully!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("No such option");
		}
	}

	/**This function used to add patient details and store into json file
	 */
	@Override
	public Patient addPatient(long mobile) {
		patient = new Patient();
		System.out.println("Enter Patient Name: ");
		String patientName = Utility.retNext();
		patient.setPatientName(patientName);
		long patientId = Utility.getRandomDoubleBetweenRange(10, 100);
		if (DoctorServiceImplementation.doctorList == null) {
			patient.setpId(patientId);
		} else {
			for (int i = 0; i < DoctorServiceImplementation.doctorList.size(); i++) {
				if (patientId == DoctorServiceImplementation.doctorList.get(i).getDoctorId()) {
					patientId = Utility.getRandomDoubleBetweenRange(10, 100);
					continue;
				}
			}
			patient.setpId(patientId);
		}
		patient.setMobileNumber(mobile);
		System.out.println("Enter patient age:");
		long age = Utility.readLong();
		patient.setAge(age);
		PatientServiceImplemtation.patientList.add(patient);
		try {
			Utility.convertJavaToJson(PatientServiceImplemtation.patientList, CliniqueManager.PATIENT_FILE_PATH);
			System.out.println("Patient details added successfully!");
		} catch (IOException e) {
			System.out.println("Some Network issue is there.");
		}
		return patient;
	}

	/**This function used to delete perticular patient details
	 */
	@Override
	public void deletePatient(int pindex) {
		try {
		PatientServiceImplemtation.patientList.remove(pindex);
		}catch(Exception e)
		{
			System.out.println("Patient not present at that index");
		}
		try {
			Utility.convertJavaToJson(PatientServiceImplemtation.patientList, CliniqueManager.PATIENT_FILE_PATH);
		} catch (IOException e) {
			System.out.println("File not write");
		}
	}

	/**This function used to update patient details
	 */
	@Override
	public void updatePatient(int index) {
		System.out.println("What do you want to update ?");
		System.out.println("1. Mobile Number\t\t 2. Patient Age");
		int option = Utility.reInteger();
		switch (option) {
		case 1:
			System.out.println("Enter new MobileNumber");
			long newMobile = Utility.readLong();
			PatientServiceImplemtation.patientList.get(index).setMobileNumber(newMobile);
			try {
				Utility.convertJavaToJson(PatientServiceImplemtation.patientList, CliniqueManager.PATIENT_FILE_PATH);
				System.out.println("Data updated successfully!");
			} catch (IOException e) {
				System.out.println("Not updated");
			}
			break;
		case 2:
			System.out.println("Enter age");
			long newAge = Utility.readLong();
			PatientServiceImplemtation.patientList.get(index).setAge(newAge);
			try {
				Utility.convertJavaToJson(PatientServiceImplemtation.patientList, CliniqueManager.PATIENT_FILE_PATH);
				System.out.println("Data updated successfully!");
			} catch (IOException e) {
				System.out.println("data not updated successfully");
			}
			break;
		default:
			System.out.println("No such option");
		}
	}
	/**
	 * this function used to close application
	 */
	public void close() {
		System.out.println("Are you sure want to close ? \t yes/no:[0/1]");
		int option = Utility.reInteger();
		if (option == 0) {
			System.out.println("Thanks,and keep Smiling");
			System.exit(0);
		} else
			CliniqueManager.doSelectOptions();
	}
}
