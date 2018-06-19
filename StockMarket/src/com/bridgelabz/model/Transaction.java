package com.bridgelabz.model;

/**this is pojo(plain old java object)class.It provides getters and setters methods of private data members.
 * @author yuga
 */
public class Transaction {
	private String customerName;
	private String companyName;
	private long NumberOfShares;
	private String timeStamp;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public long getNumberOfShares() {
		return NumberOfShares;
	}
	public void setNumberOfShares(long numberOfShares) {
		NumberOfShares = numberOfShares;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "Transaction [customerName=" + customerName + ", companyName=" + companyName + ", NumberOfShares="
				+ NumberOfShares + ", timeStamp=" + timeStamp + "]";
	}
	

}
