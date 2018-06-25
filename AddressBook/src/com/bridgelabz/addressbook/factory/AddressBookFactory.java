package com.bridgelabz.addressbook.factory;

import com.bridgelabz.addressbook.service.AddressBookMediator;
import com.bridgelabz.addressbook.serviceimplementation.AddressBookJDBC;
import com.bridgelabz.addressbook.serviceimplementation.AddressBookJSON;

public class AddressBookFactory {

	public static AddressBookMediator getInstance(int option) {
		if(option==1)return new AddressBookJDBC();
		else if(option==2)return new AddressBookJSON();
		else return null;
	}
}
