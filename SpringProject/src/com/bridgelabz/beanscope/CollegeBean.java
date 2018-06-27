package com.bridgelabz.beanscope;

import java.io.Serializable;

public class CollegeBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String registrationNo;
	private String clgName;
	private String place;
	private String university;
	private StudentBean student;
	public CollegeBean() {
		
	}
	public CollegeBean(String registrationNo, String clgName, String place, String university, StudentBean student) {
		this.registrationNo = registrationNo;
		this.clgName = clgName;
		this.place = place;
		this.university = university;
		this.student = student;
	}
	
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getClgName() {
		return clgName;
	}
	public void setClgName(String clgName) {
		this.clgName = clgName;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	
	public StudentBean getStudentBean() {
		return student;
	}
	public void setStudentBean(StudentBean student) {
		this.student = student;
	}
	public void registerStudent()
	{
		System.out.println("Hello "+this.student.getStudentName()
				+ " you are successfully register in " +this.clgName +" of "+this.university);
	}
}
