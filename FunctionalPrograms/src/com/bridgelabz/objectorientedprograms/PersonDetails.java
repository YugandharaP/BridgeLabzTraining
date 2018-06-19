package com.bridgelabz.objectorientedprograms;

import java.io.Serializable;

/**
 * purpose-To create person details pojo class(plain old java object) which provides getter and setter methods.
 * @author Yuga
 * @version 1.0
 * @since 07-06-2018
 */
@SuppressWarnings("serial")
public class PersonDetails implements Serializable {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private long phoneNum;
	/**Constructor to assign the value for parameter
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param city
	 * @param state
	 * @param zipCode
	 * @param phoneNum
	 */
	public PersonDetails(String firstName, String lastName, String address, String city, String state, String zipCode,
			long phoneNum) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNum = phoneNum;
	}
	public PersonDetails() {
	}
	/**
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**To set first name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**To set lastName
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**To set address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**To set city
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return state
	 */
	public String getState() {
		return state;
	}
	/**To set state
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * @return phoneNum
	 */
	public long getPhoneNum() {
		return phoneNum;
	}
	/**To set contact number
	 * @param contact number
	 */
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	/**
	 * @return zipcode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**To set zipcode
	 * @param zipcode
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		System.out.println();
		return "PersonDetails [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zipCode=" + zipCode + ", phoneNum=" + phoneNum + "]";
	}

}
