package com.bridgelabz.DIUsingConstructors;

public class SimCardBean {
	String simCardType;
	String simNumber;
	
	public SimCardBean() {
	}
	public SimCardBean(String simCardType, String simNumber) {
		super();
		this.simCardType = simCardType;
		this.simNumber = simNumber;
	}
	@Override
	public String toString() {
		return "SimCardBean [simCardType=" + simCardType + ", simNumber=" + simNumber + "]";
	}
	public String getSimCardType() {
		return simCardType;
	}
	public void setSimCardType(String simCardType) {
		this.simCardType = simCardType;
	}
	public String getSimNumber() {
		return simNumber;
	}
	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}
	
	
}
