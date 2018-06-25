package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.model.PersonDetails;

public interface AddressBookMediator {
	public boolean createNew();
	public void showList();
	public void deleteAddressBook(String name);
	public void closeCurrentAddressBook();
	public void openExistingAddressBook(String indexOfFile);
	public void exit();
	
	public void personOperations(int option, PersonDetails person,long value);
	public int searchByMobileNumber(long value);
	public void showpersons();
	public void save();
	
}
