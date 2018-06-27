package com.bridgelabz.autowiring;

import java.io.Serializable;

public class HospitalBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int hId;
	private String hName;
	private String location;
	private PatientBean patient;

	public HospitalBean() {

	}

	public HospitalBean(PatientBean patient) {
		this.patient = patient;
		System.out.println(" Hospital Constructor loaded with patient type parameter");
	}

	public int gethId() {
		return hId;
	}

	public void sethId(int hId) {
		this.hId = hId;
	}

	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public PatientBean getPatientBean() {
		return patient;
	}

	public void setPatientBean(PatientBean patient) {
		this.patient = patient;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "HospitalBean [hId=" + hId + ", hName=" + hName + ", location=" + location + ", patient=" + patient
				+ "]";
	}

	/*public void reception() {
		System.out.println("This is  " + gethName() + " in " + getLocation() + " and " + this.getPatientBean()
				+ " admitted in our hospital word No-3");
	}*/
}
