package com.bridgelabz.model;

public class Patient {
	
	private String patientName;
	private long pId;
	private long mobileNumber;
	private long age;

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Patient [patientName=" + patientName + ", pId=" + pId + ", mobileNumber=" + mobileNumber + ", age="
				+ age + "]";
	}

}
