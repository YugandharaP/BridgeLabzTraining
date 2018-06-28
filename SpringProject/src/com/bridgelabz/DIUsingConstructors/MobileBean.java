package com.bridgelabz.DIUsingConstructors;

import org.springframework.beans.factory.annotation.Required;

public class MobileBean {
	int mobileId;
	String mobileBrand;
	String mobileColor;
	SimCardBean simcardbean;
	public MobileBean()
	{
	}
	public MobileBean(int mobileId, String mobileBrand, String mobileColor, SimCardBean simcardbean) {
		super();
		this.mobileId = mobileId;
		this.mobileBrand = mobileBrand;
		this.mobileColor = mobileColor;
		this.simcardbean = simcardbean;
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
	public SimCardBean getSimCardBean() {
		return simcardbean;
	}
	public void setSimCardBean(SimCardBean simcard) {
		this.simcardbean = simcard;
	}
	
	
	public void makeCall() {
		System.out.println("Calling From "+this.mobileBrand+" sim type : "+this.getSimCardBean()+" mobile number : "+this.mobileId);
	}
	
}
