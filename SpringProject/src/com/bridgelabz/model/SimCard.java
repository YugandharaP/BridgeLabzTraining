package com.bridgelabz.model;

public class SimCard {
	String simCardType;
	String simNumber;

	public SimCard() {
	}

	public SimCard(String simCardType, String simNumber) {
		this.simCardType = simCardType;
		this.simNumber = simNumber;
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

	
	@Override
	public String toString() {
		return "SimCard [simCardType=" + simCardType + ", simNumber=" + simNumber  + "]";
	}
}
