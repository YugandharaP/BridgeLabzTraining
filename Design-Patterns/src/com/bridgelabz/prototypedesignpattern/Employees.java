package com.bridgelabz.prototypedesignpattern;

import java.util.ArrayList;
import java.util.List;


public class Employees {
	private List<String> empList;

	public Employees() {
		empList = new ArrayList<String>();
	}

	public Employees(List<String> list) {
		this.empList = list;
	}

	public void loadData() {
		empList.add("yuga");
		empList.add("vishal");
		empList.add("Bijaya");
		empList.add("Sweta");
	}

	public List<String> getEmpList() {
		return empList;
	}
	
	public Object clone() {
		List<String> temp = new ArrayList<String>();
		for(String s : this.getEmpList()){
			temp.add(s);
		}
		return new Employees(temp);
	}
}
