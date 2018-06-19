package com.bridgelabz.service;

import com.bridgelabz.model.Patient;

public interface PatientService {
	public void printPatientDetails();
	public Patient searchPatientByName();
	public Patient searchPatientById();
	public Patient searchPatientByMobileNumber();
	public void takeAppointment();
}
