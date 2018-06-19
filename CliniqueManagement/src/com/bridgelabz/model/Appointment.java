package com.bridgelabz.model;

import java.util.Date;

public class Appointment {
	private String DoctorName;
	private long dId;
	private String patientName;
	private long pId;
	private String timeStamp;

	public String getDoctorName() {
		return DoctorName;
	}

	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}

	public long getdId() {
		return dId;
	}

	public void setdId(long dId) {
		this.dId = dId;
	}

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

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
}
