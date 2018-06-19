package com.bridgelabz.service;

import com.bridgelabz.model.Customer;

public interface CustomerService {
	Customer add(long mobileNumber);
	public void remove(int index);
	public void update(int index);
	public void showCustomerList();

}
