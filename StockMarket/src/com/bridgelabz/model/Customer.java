package com.bridgelabz.model;

public class Customer {
	private String customerName;
	private long mobileNumber;
	private long NumberOfShares;
	private long amount;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getNumberOfShares() {
		return NumberOfShares;
	}

	public void setNumberOfShares(long numberOfShares) {
		NumberOfShares = numberOfShares;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", mobileNumber=" + mobileNumber + ", NumberOfShares="
				+ NumberOfShares + ", amount=" + amount + "]";
	}
}
