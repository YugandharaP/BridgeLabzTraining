package com.bridgelabz.objectorientedprograms;

import java.util.ArrayList;

public class CustomerInfo {
	private String userName;
	private long phoneNumber;
	private long accountNumber;
	private long shareNumber;
	private long sharePrice;
	private Object companySyambol;
	private ArrayList<CompanyShares>companyArray=new ArrayList<CompanyShares>();
	
	
	public Object getCompanySyambol() {
		return companySyambol;
	}
	public void setCompanySyambol(Object companySyambol) {
		this.companySyambol = companySyambol;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getShareNumber() {
		return shareNumber;
	}
	public void setShareNumber(long shareNumber) {
		this.shareNumber = shareNumber;
	}
	public long getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(long sharePrice) {
		this.sharePrice = sharePrice;
	}
	public ArrayList<CompanyShares> getCompanyArray() {
		return companyArray;
	}
	public void setCompanyArray(ArrayList<CompanyShares> companyArray) {
		this.companyArray = companyArray;
	}
	
	
}
