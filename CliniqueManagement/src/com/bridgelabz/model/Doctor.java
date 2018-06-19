package com.bridgelabz.model;

public class Doctor {
	private String doctorName;
	private long doctorId;
	private String specialization;
	private String available;
	private long patientCount;

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public long getPatientCount() {
		return patientCount;
	}

	public void setPatientCount(long patientCount) {
		this.patientCount = patientCount;
	}
	@Override
	public String toString() {
		return "Doctor [doctorName=" + doctorName + ", doctorId=" + doctorId + ", specialization=" + specialization
				+ ", available=" + available + ", patientCount=" + patientCount + "]";
	}
}
