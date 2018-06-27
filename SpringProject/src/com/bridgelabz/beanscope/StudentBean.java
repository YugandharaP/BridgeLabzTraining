package com.bridgelabz.beanscope;

import java.io.Serializable;

public class StudentBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String studentName;
	private String address;
	private String phoneNum;

	@Override
	public String toString() {
		return "StudentBean [studentName=" + studentName + ", address=" + address + ", phoneNum=" + phoneNum + "]";
	}

	public StudentBean() {
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}
