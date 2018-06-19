package com.bridgelabz.controller;

import java.util.ArrayList;

import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
import com.bridgelabz.serviceimplementation.CliniqueManagerImplementation;
import com.bridgelabz.serviceimplementation.DoctorServiceImplementation;
import com.bridgelabz.serviceimplementation.PatientServiceImplemtation;
import com.bridgelabz.utility.Utility;

/**
 * purpose-This programme is used to manage a list of Doctors associated with the
 * Clinique. This also manages the list of patients who use the clinique.The
 * programs allows patients to take appointment with the doctor.
 * @author yuga
 *@version: 1.0
 *@since : 10-06-2018
 */
public class CliniqueManager {
	public static final String DOCTOR_FILE_PATH = "/home/adminsitrator/Documents/Program/CliniqueManagement/src/com/bridgelabz/files/Doctor.json";
	public static final String PATIENT_FILE_PATH = "/home/adminsitrator/Documents/Program/CliniqueManagement/src/com/bridgelabz/files/Patient.json";
	public static final String APPOINTMENT_FILE_PATH = "/home/adminsitrator/Documents/Program/CliniqueManagement/src/com/bridgelabz/files/Appointment.json";

	static DoctorServiceImplementation doctorService = new DoctorServiceImplementation(DOCTOR_FILE_PATH);
	static PatientServiceImplemtation patientService = new PatientServiceImplemtation(PATIENT_FILE_PATH);
	static CliniqueManagerImplementation appointment = new CliniqueManagerImplementation(APPOINTMENT_FILE_PATH);

	public static void main(String[] args) {
		System.out.println("Choose one of the following options to perform operation : ");
		doSelectOptions();
	}

	/**
	 * This function is used to select just options which user want
	 */
	public static void doSelectOptions() {
		System.out.println("1. Add Doctor Details\t\t\t2. Delete Doctor Details");
		System.out.println("3. Update Doctor Details\t\t 4.Show DoctorList");
		System.out.println("5. Take Appointment\t\t\t 6. Delete Patient Details");
		System.out.println("7. Update Patient Details\t\t 8. Show PatientList");
		System.out.println("9. Search Doctor\t\t\t 10.Search Paitent");
		System.out.println("11.Show Popular Specialization\t\t12.Show Popular Doctor ");
		System.out.println("\t\t13.Close Out From Application");
		int option = Utility.reInteger();
		performOperations(option);
	}

	/**This function is used perforn perticular operations which user chose.
	 * @param option
	 */
	public static void performOperations(int option) {

		switch (option) {
		case 1:
			appointment.addDoctor();
			doSelectOptions();
			break;
		case 2:
			System.out.println("Which doctor details you want to delete ? ");
			doctorService.printDoctorDetails();
			System.out.println("Enter Index: ");
			int index = Utility.reInteger();
			appointment.deleteDoctor(index);
			doSelectOptions();
			break;
		case 3:
			System.out.println("Which doctor details you want to update ?");
			doctorService.printDoctorDetails();
			System.out.println("Enter index");
			int index1 = Utility.reInteger();
			appointment.updateDoctor(index1);
			doSelectOptions();
			break;
		case 4:
			doctorService.printDoctorDetails();
			doSelectOptions();
			break;
		case 5:
			// appointment.addPatient();
			patientService.takeAppointment();
			doSelectOptions();
			break;
		case 6:
			System.out.println("Which pateint details you want to delete?");
			patientService.printPatientDetails();
			System.out.println("Enter index");
			int pindex = Utility.reInteger();
			appointment.deletePatient(pindex);
			doSelectOptions();
			break;
		case 7:
			System.out.println("Which Patient details you want to update ?");
			patientService.printPatientDetails();
			System.out.println("Enter index");
			int index2 = Utility.reInteger();
			appointment.updatePatient(index2);
			doSelectOptions();
			break;
		case 8:
			patientService.printPatientDetails();
			doSelectOptions();
			break;
		case 9:
			System.out.println("Enter option by which you want to search doctor : ");
			searchDoctor();
			break;
		case 10:
			System.out.println("Enter option by which you want to search doctor : ");
			searchPatient();
			break;
		case 11:
			doctorService.searchPopularSpecialization();
			doSelectOptions();
			break;
		case 12:
			doctorService.searchPopulardoctor();
			doSelectOptions();
			break;
		case 13:
			appointment.close();
			break;
		default:
			System.err.println("No such option");
		}
	}

	private static void searchPatient() {
		System.out.println("1. search by PatientName\t\t 2. search by PatientId");
		System.out.println("\t\t3. search by Patient-mobileNumber");
		int option = Utility.reInteger();
		switch (option) {
		case 1:
			Patient byName = patientService.searchPatientByName();
			System.out.println(byName);
			doSelectOptions();
			break;
		case 2:
			Patient byId = patientService.searchPatientById();
			System.out.println(byId);
			doSelectOptions();
			break;
		case 3:
			Patient byMobile = patientService.searchPatientByMobileNumber();
			System.out.println(byMobile);
			doSelectOptions();
			break;
		default:
			System.err.println("No such option");
		}
	}

	public static void searchDoctor() {
		System.out.println("1. search by DoctorName\t\t\t2. search by DoctorId");
		System.out.println("3. search by Doctor-Specialization \t4. search by Doctor-Availability");
		int option = Utility.reInteger();
		switch (option) {
		case 1:
			Doctor byName = doctorService.searchDoctorByName();
			System.out.println(byName);
			doSelectOptions();
			break;
		case 2:
			Doctor byId = doctorService.searchDoctorById();
			System.out.println(byId);
			doSelectOptions();
			break;
		case 3:
			ArrayList<Doctor> bySpecilaization = new ArrayList<>();
			System.out.println("Enter doctor Specialization:");
			String specialization = Utility.retNext();
			bySpecilaization = doctorService.searchDoctorBySpecialization(bySpecilaization, specialization);
			for (int i = 0; i < bySpecilaization.size(); i++) {
				System.out.println(bySpecilaization.get(i));
			}
			doSelectOptions();
			break;
		case 4:
			ArrayList<Doctor> byAvailable = doctorService.searchDoctorByAvailability();
			for (int i = 0; i < byAvailable.size(); i++) {
				System.out.println(byAvailable.get(i));
			}
			doSelectOptions();
			break;
		}
	}

}
