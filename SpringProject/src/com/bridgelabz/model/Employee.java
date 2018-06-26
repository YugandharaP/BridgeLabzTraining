package com.bridgelabz.model;

public class Employee {
	 int eid;
	 String name;
	 String address;

	public Employee() {
		System.out.println("Employee object Constructed");
	}

	Employee(int eid, String name, String address) {
		this.eid = eid;
		this.name = name;
		this.address = address;

	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", address=" + address + "]";
	}
}
