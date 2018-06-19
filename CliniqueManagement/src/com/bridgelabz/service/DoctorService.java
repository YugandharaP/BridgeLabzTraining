package com.bridgelabz.service;

import java.util.ArrayList;

import com.bridgelabz.model.Doctor;

public interface DoctorService {
	public void printDoctorDetails();
	public Doctor searchDoctorByName();
	public Doctor searchDoctorById();
	public ArrayList<Doctor> searchDoctorBySpecialization(ArrayList<Doctor>list,String specialization);
	public ArrayList<Doctor> searchDoctorByAvailability();
	public void searchPopulardoctor();
	public void searchPopularSpecialization();
}
