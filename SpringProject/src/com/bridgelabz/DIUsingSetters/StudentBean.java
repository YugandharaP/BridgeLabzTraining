package com.bridgelabz.DIUsingSetters;

public class StudentBean {
	int sid;
	String sname;
	String branch;

	public StudentBean(int sid, String sname, String branch) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.branch = branch;
	}

	public StudentBean() {
		System.out.println("object constructed");
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getbranch() {
		return branch;
	}

	public void setbranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "StudentBean [sid=" + sid + ", sname=" + sname + ", branch=" + branch + "]";
	}

	public void myInit() {
		System.out.println("Java bean life cycle start");
	}

	public void myDestroy() {
		System.out.println("Java bean destroy");
	}
}
