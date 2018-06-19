package com.bridgelabz.service;

import com.bridgelabz.model.Patient;

public interface CliniqueManagerService {
	public void addDoctor();

	public void deleteDoctor(int index);

	public void updateDoctor(int index);

	public Patient addPatient(long number);

	public void deletePatient(int index);

	public void updatePatient(int index);

}
