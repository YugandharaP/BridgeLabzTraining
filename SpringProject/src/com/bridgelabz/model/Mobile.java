package com.bridgelabz.model;

public class Mobile {
	int mobileId;
	String mobileBrand;
	String mobileColor;
	SimCard simcard;

	public Mobile() {
	}

	public Mobile(int mobileId, String mobileBrand, String mobileColor, SimCard simcard) {
		this.mobileId = mobileId;
		this.mobileBrand = mobileBrand;
		this.mobileColor = mobileColor;
		this.simcard = simcard;
	}

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}

	public String getMobileBrand() {
		return mobileBrand;
	}

	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}

	public String getMobileColor() {
		return mobileColor;
	}

	public void setMobileColor(String mobileColor) {
		this.mobileColor = mobileColor;
	}

	public SimCard getSimCard() {
		return simcard;
	}

	public void setSimCard(SimCard simCard) {
		simcard = simCard;
	}

	@Override
	public String toString() {
		return "Mobile [mobileId=" + mobileId + ", mobileBrand=" + mobileBrand + ", mobileColor=" + mobileColor
				+ ", simcard=" + simcard + "]";
	}

	public void makeCall() {
		System.out.println("Calling From "+this.mobileBrand+" sim type : "+this.getSimCard()+" mobile number : "+this.mobileId);
	}
	
}
