package com.bridgelabz.addressbook.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.addressbook.factory.AddressBookFactory;
import com.bridgelabz.addressbook.model.PersonDetails;
import com.bridgelabz.addressbook.service.AddressBookMediator;
import com.bridgelabz.addressbook.utility.Utility;

public class AddressBookApplication {
	static AddressBookMediator mediator;

	public static void main(String[] args) {
		System.out.println("Open AddressBook Application In :");
		System.out.println("1. JDBC\t\t 2.JSON");
		int option = Utility.reInteger();
		mediator = AddressBookFactory.getInstance(option);
		showInitialOptions();
	}

	/**
	 * This function show initial options to perform some operations such as create
	 * ,delete,open, view address book
	 */
	public static void showInitialOptions() {
		System.out.println("Choose One from following options: ");
		System.out.println("1.CREATE\t\t 2.OPEN\t\t 3.VIEW\t\t 4.DELETE\t\t 5.QUIT");
		int option = Utility.reInteger();
		switch (option) {
		case 1:
			System.out.println("Enter the name of new address book: ");
			boolean condition = mediator.createNew();
			if (condition == true) {
				System.out.println("AddressBook is created!");
			} else if (condition == false) {
				System.out.println("AddressBook Allready exist!");
			}
			mediator.showList();
			AddressBookApplication.showInitialOptions();
			break;
		case 2:
			System.out.println("Which AddressBook you want to open ? ");
			mediator.showList();
			System.out.println("Enter index/Name");
			String indexOfFile = Utility.retNext();
			mediator.openExistingAddressBook(indexOfFile);
			AddressBookApplication.showOptions();
			break;
		case 3:
			System.out.println(" This Address Books are exist");
			mediator.showList();
			showInitialOptions();
			break;
		case 4:
			System.out.println("Which address book you want to delete");
			mediator.showList();
			System.out.println("Enter name: ");
			String name = Utility.retNext();
			mediator.deleteAddressBook(name);
			mediator.showList();
			showInitialOptions();
			break;
		case 5:
			System.out.println("Do You Really Want To Exit From Address Book Application ?");
			System.out.println("yes[0]/no[1]");
			mediator.exit();
			break;
		}
	}

	/**
	 * This function show all options to the user
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void showOptions() {
		PersonDetails person = null;
		System.out.println("Which oeration you want to perform,Choose following options");
		System.out.println("1. Add person\t\t\t 2. Edit Person");
		System.out.println("3. Delete Person details\t 4. Show All Persons Details ");
		System.out.println("5. Save Data\t\t\t6. Quit From Current AddressBook  \n7. Exit from Application");
		int option = Utility.reInteger();
		switch (option) {
		case 1:
			person = takePersonDetails();
			mediator.personOperations(option, person, 0);
			showOptions();
			break;
		case 2:
			mediator.showpersons();
			System.out.println("Which person details you want to change ?");
			System.out.println("Enter mobileNumber");
			long mobile = Utility.readLong();
			mediator.personOperations(option, null, mobile);
			break;
		case 3:
			mediator.showpersons();
			System.out.println("Which person details you want to delete ?");
			System.out.println("enter mobileNumber");
			long mobileNum = Utility.readLong();
			mediator.personOperations(option, null, mobileNum);
			showOptions();
			break;
		case 4:
			mediator.showpersons();
			showOptions();
			break;
		case 5:
			mediator.save();
			break;
		case 6:
			mediator.closeCurrentAddressBook();
			break;
		case 7:
			System.out.println("Do You Really Want To Exit From Address Book Application ?");
			System.out.println("yes[0]/no[1]");
			mediator.exit();
			break;
		default:
			System.err.println("No such Option");
		}
	}

	private static PersonDetails takePersonDetails() {
		System.out.println("Enter First Name: ");
		String fName = Utility.retNext();
		System.out.println("Enter Last Name: ");
		String lName = Utility.retNext();
		System.out.println("Enter Address: ");
		String address = Utility.retNext();
		System.out.println("Enter city: ");
		String city = Utility.retNext();
		System.out.println("Enter state: ");
		String state = Utility.retNext();
		System.out.println("Enter zipCode: ");
		String zipCode = Utility.retNext();
		System.out.println("Enter contact number: ");
		long phoneNumber = Utility.readLong();
		PersonDetails person = new PersonDetails(fName, lName, address, city, state, zipCode, phoneNumber);
		return person;
	}

}
