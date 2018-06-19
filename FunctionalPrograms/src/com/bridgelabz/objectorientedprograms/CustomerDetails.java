package com.bridgelabz.objectorientedprograms;

import java.io.Serializable;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

import com.bridgelabz.dataStructure.MyLinkedList;
import com.bridgelabz.dataStructure.MyQueue;
import com.bridgelabz.dataStructure.MyStack;

@SuppressWarnings("serial")
public class CustomerDetails implements Serializable{
	private ArrayList<CustomerInfo>customerArray=new ArrayList<CustomerInfo>();
	/*private  ArrayList bookList= new ArrayList();
	
	
	public ArrayList getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList bookList) {
		this.bookList = bookList;
	}*/

	public ArrayList<CustomerInfo> getCustomerArray() {
		return customerArray;
	}

	public void setCustomerArray(ArrayList<CustomerInfo> customerArray) {
		this.customerArray = customerArray;
	}
	public CustomerDetails() {
		ObjectMapper mapper=new ObjectMapper();
	}
	
}
