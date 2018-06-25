package com.bridgelabz.addressbook.serviceimplementation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.bridgelabz.addressbook.controller.AddressBookApplication;
import com.bridgelabz.addressbook.model.PersonDetails;
import com.bridgelabz.addressbook.service.AddressBookMediator;
import com.bridgelabz.addressbook.utility.Utility;

public class AddressBookJSON implements AddressBookMediator {
	static final String STORAGE_FILE_PATH = "/home/adminsitrator/Documents/Program/AddressBook/src/com/bridgelabz/addressbook/files/AddressBookList.json";
	static final String BOOK_FILE_PATH = "/home/adminsitrator/Documents/Program/AddressBook/src/com/bridgelabz/addressbook/files/";
	static ArrayList<String> addressBookList = null;
	AddressBook addressBook;
	String currentAddressBook;
	static {
			if (addressBookList == null) {
				addressBookList = Utility.convertJsonToList(STORAGE_FILE_PATH,addressBookList);
				System.out.println();
			} else {

				System.out.println("No Address book is present");
				addressBookList = new ArrayList<>();
				// System.out.println("lists are :"+bookList);
			}
	}

	@Override
	public boolean createNew() {
		String bookName = BOOK_FILE_PATH + Utility.retNext() + ".json";
		File file = new File(bookName);
		try {
			if (file.createNewFile()) {
				addressBookList.add(bookName);// arraylist add file
				Utility.convertJavaToJson(addressBookList, STORAGE_FILE_PATH);
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void closeCurrentAddressBook() {
		System.out.println("Do you want to save ? yes[0]/No[1]");
		int option = Utility.reInteger();
		if (option == 0) {
			save();
		} 
		AddressBookApplication.showInitialOptions();
	}
	/**
	 * This function show the address book lists
	 */
	@Override
	public void showList() {
		addressBookList = Utility.convertJsonToList(STORAGE_FILE_PATH, addressBookList);
		for (int i = 0; i < addressBookList.size(); i++) {
			System.out.println("index : " + i + " " + addressBookList.get(i));
		}
	}

	@Override
	public void openExistingAddressBook(String indexOfFile) {
		int index = Integer.parseInt(indexOfFile);
		currentAddressBook = addressBookList.get(index);
		addressBook = new AddressBook(currentAddressBook);
		AddressBookApplication.showOptions();
	}

	@Override
	public void deleteAddressBook(String name) {
		int index = searchIndexByName(name);
		String fileName = addressBookList.get(index);
		if (index > -1) {
			addressBookList.remove(index);
		} else {
			System.out.println("given adderess book is not present");
		}
		try {
			Utility.convertJavaToJson(addressBookList, STORAGE_FILE_PATH);
			File file = new File(fileName);
			if (file.delete()) {
				System.out.println("File Deleted Successfully");
			} else {
				System.out.println("Failed to delete file");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int searchIndexByName(String name) {
		String fullName = BOOK_FILE_PATH + name + ".json";
		int i = 0;
		for (i = 0; i < addressBookList.size(); i++)
			if (addressBookList.get(i).equals(fullName)) {
				return i;
			}
		return -1;
	}

	@Override
	public void exit() {
		AddressBook book = new AddressBook(currentAddressBook);
		int input = Utility.reInteger();
		if (input == 0) {
			System.out.println("Do you want to save ? yes[0]/No[1]");
			int option = Utility.reInteger();
			if (option == 0)
				save();
			else {
				System.out.println("Thanks Visit again");
				System.exit(0);
			}
		} else {
			AddressBookApplication.showInitialOptions();
		}
	}

	@Override
	public void showpersons() {
		
		addressBook.getAll();
		/*for(int i=0;i<addressBook.getPersonList().size();i++)
		{
			System.out.println(addressBook.getPersonList().get(i));
		}*/
	}

	@Override
	public void personOperations(int option, PersonDetails person, long mobile) {
		if (option == 1) {
			addressBook.add(person);
		} else if (option == 2) {
			int index = searchByMobileNumber(mobile);
			selectOptionAndEdit(index, mobile);

		} else if (option == 3) {
			addressBook.delete(mobile);
		}
	}

	/**To search person using mobile number 
	 */
	@Override
	public int searchByMobileNumber(long mobile) {
		for (int i = 0; i < addressBook.getPersonList().size(); i++) {
			if (addressBook.getPersonList().get(i).getPhoneNum() == mobile) {
				return i;
			}
		}
		return -1;
	}

	private void selectOptionAndEdit(int index, long mobile) {
		System.out.println("What do you want to update ? ");
		System.out.println("1: To change \"Address\"");
		System.out.println("2: To change \"City\"");
		System.out.println("3: To change \"State\"");
		System.out.println("4: To change \"zipCode\"");
		int option = Utility.reInteger();
		switch (option) {
		case 1:
			System.out.println("Enter new Address");
			String newAddress = Utility.retNext();
			addressBook.getPersonList().get(index).setAddress(newAddress);
			AddressBookApplication.showOptions();
			break;
		case 2:
			System.out.println("Enter the new city name");
			String newCity = Utility.retNext();
			addressBook.getPersonList().get(index).setCity(newCity);
			AddressBookApplication.showOptions();
			break;
		case 3:
			System.out.println("Enter the new state name");
			String newState = Utility.retNext();
			addressBook.getPersonList().get(index).setState(newState);
			AddressBookApplication.showOptions();
			break;
		case 4:
			System.out.println("Enter the new ZipCode");
			String newZipCode = Utility.retNext();
			addressBook.getPersonList().get(index).setZipCode(newZipCode);
			AddressBookApplication.showOptions();
			break;
		}
	}

	@Override
	public void save() {
		try {
			Utility.convertJavaToJson(AddressBook.personList, currentAddressBook);
			System.out.println("Data Saved Successfully");
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}