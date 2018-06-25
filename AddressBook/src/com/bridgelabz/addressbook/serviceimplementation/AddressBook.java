package com.bridgelabz.addressbook.serviceimplementation;

import java.util.ArrayList;
import com.bridgelabz.addressbook.model.PersonDetails;
import com.bridgelabz.addressbook.utility.Utility;

public class AddressBook {
	static ArrayList<PersonDetails> personList = new ArrayList<PersonDetails>();

	public AddressBook(String selectFile) {
		personList = Utility.convertJsonToList(selectFile, personList);
	}

	public AddressBook() {

	}

	public  ArrayList<PersonDetails> getPersonList() {
		return personList;
	}

	public  void setPersonList(ArrayList<PersonDetails> personList) {
		AddressBook.personList = personList;
	}

	/**
	 * @param person
	 */
	public void add(PersonDetails person) {
		personList.add(person);
	}

	/**
	 * @param mobile
	 */
	public void delete(long mobile) {
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getPhoneNum() == mobile) {
				personList.remove(i);
			}
		}
	}

	public void getAll() {
		for (int i = 0; i < personList.size(); i++) {
			System.out.println(personList.get(i));
		}
	}

}
