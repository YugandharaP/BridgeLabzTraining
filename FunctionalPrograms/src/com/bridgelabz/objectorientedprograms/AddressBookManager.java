package com.bridgelabz.objectorientedprograms;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

/**
 * purpose-To create an address book which stores users address details and
 * perform operations like add user,update user details,delete user details,sort
 * user either by last name or zipcode.
 * 
 * @author Yuga
 * @version 1.0
 * @since 07-06-2018
 *
 */
public class AddressBookManager {
	static final String BOOK_FILE_PATH = "/home/adminsitrator/Documents/JavaProgramming/FunctionalPrograms/src/com/bridgelabz/objectorientedprograms/";

	ArrayList<String> bookList = null;
	AddressBook addressBook;
	String select;

	/**This constructor will extract all the file paths from json at the time of execution
	 * @param storagefilepath
	 */
	AddressBookManager(String storagefilepath) {
		if (bookList == null) {
			bookList = Utility.convertJsonToList(storagefilepath,bookList);
			System.out.println();
		} else {

			System.out.println("No Address book is present");
			bookList = new ArrayList<>();
			// System.out.println("lists are :"+bookList);
		}
	}

	/***********************************************************************************************************/

	/**
	 * This function show all options to the user
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void showOptions() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("Which oeration you want to perform,Choose following options");
		System.out.println("1. Add person\t\t\t 2. Edit Person");
		System.out.println("3. Delete Person details\t 4. Sort_By_LastName");
		System.out.println("5. Sort_By_Zip\t\t\t 6. Show All Persons Address ");
		System.out.println("7. Quit From Current AddressBook \t 8. Exit from Application");

		int option = Utility.reInteger();
		performOperations(option);
	}

	/**
	 * This function to take option from user and call corresponding function using
	 * switch case
	 * 
	 * @param option
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	private void performOperations(int option) throws JsonGenerationException, JsonMappingException, IOException {

		switch (option) {
		case 1:
			addPerson();
			break;
		case 2:
			showBook();
			System.out.println("Which person details you want to change ?");
			System.out.println("Enter index");
			int index = Utility.reInteger();
			editPerson(index);
			break;
		case 3:
			showBook();
			System.out.println("Which person details you want to delete ?");
			System.out.println("Enter index");
			int index1 = Utility.reInteger();
			deletePerson(index1);
			break;
		case 4:
			sortByLastName();
			break;
		case 5:
			sortByZip();
			break;
		case 6:
			showBook();
			showOptions();
			break;
		case 7:
			close();
			break;
		case 8:
			exit();
			break;
		default:
			System.err.println("No such Option");
		}

	}

	/**This function perform the close address book operation
	 */
	public void close() {
		System.out.println("you want to save all details in same address book ?  Save/Cancle\t \n  save[0]  cancle[1]");
		int choice = Utility.reInteger();
		if (choice == 0)
			try {
				Utility.convertJavaToJson(addressBook.getPersonList(), select);
				System.out.println("data save successfully");
				showBook();
				AddressBookManager manager = new AddressBookManager(UserIntefaceOfAddressBook.STORAGE_FILE_PATH);
				UserIntefaceOfAddressBook.showInitialOptions(manager);
			} catch (IOException e) {
				e.printStackTrace();
			}
		else if (choice == 1) {
			System.out.println("data not saved");
			AddressBookManager manager = new AddressBookManager(UserIntefaceOfAddressBook.STORAGE_FILE_PATH);
			UserIntefaceOfAddressBook.showInitialOptions(manager);
		}
	}

	/**
	 * this function quit the program
	 */
	public void exit() {
		System.out.println("Do You Really Want To Exit From Address Book Application ?");
		System.out.println("yes[0]/no[1]");
		AddressBook book=new AddressBook(select);
		int input = Utility.reInteger();
		if (input == 0) {
			System.err.println("Thanks! Visit Again...");
			System.exit(0);
		} else {
			AddressBookManager manager = new AddressBookManager(UserIntefaceOfAddressBook.STORAGE_FILE_PATH);
			UserIntefaceOfAddressBook.showInitialOptions(manager);
		}
	}

	/**
	 * This function show the address book lists
	 */
	public void showList() {
		bookList = Utility.convertJsonToList(UserIntefaceOfAddressBook.STORAGE_FILE_PATH,bookList);
		for (int i = 0; i < bookList.size(); i++) {
			
			System.out.println("index : " + i + " " + bookList.get(i));
		}
		
		/*for(int i=0;i<bookList.size();i++)
		{
			String temp=bookList.get(i);
			String array[]=temp.split("/");
		}*/
		
	}

	/**
	 * this function delete the perticular address book from list
	 * 
	 * @param index
	 */
	public void deleteAddressBook(int index) {
		bookList.remove(index);
		System.err.println("Address Book delete successfully");
		try {
			Utility.convertJavaToJson(bookList, UserIntefaceOfAddressBook.STORAGE_FILE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this function create new address book
	 */
	public void createNew() {
		System.out.println("Enter the name of new address book: ");
		String bookName = BOOK_FILE_PATH + Utility.retNext() + ".json";
		File file = new File(bookName);
		try {
			if (file.createNewFile()) {
				System.out.println("AddressBook is created!");
				bookList.add(bookName);// arraylist add file
				Utility.convertJavaToJson(bookList, UserIntefaceOfAddressBook.STORAGE_FILE_PATH);
			} else {
				System.out.println("AddressBook Allready exist!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		closeCurrentAddressBook();
	}

	/**
	 * this function close current address book
	 */
	private void closeCurrentAddressBook() {
		AddressBookManager addressManager = new AddressBookManager(UserIntefaceOfAddressBook.STORAGE_FILE_PATH);
		UserIntefaceOfAddressBook.showInitialOptions(addressManager);
	}

	/**this funtion open the existing address books
	 * @param indexOfFile
	 */
	public void openExistingAddressBook(int indexOfFile) {
		select = bookList.get(indexOfFile);
		addressBook = new AddressBook(select);
		try {
			showOptions();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This function add the new person in address book
	 */

	public void addPerson() throws JsonGenerationException, JsonMappingException, IOException {
		String fName;
		String lName;
		String address;
		String city;
		String state;
		String zipCode;
		long phoneNumber;
		System.out.println("Enter First Name: ");
		fName = Utility.retNext();
		System.out.println("Enter Last Name: ");
		lName = Utility.retNext();
		System.out.println("Enter Address: ");
		address = Utility.retNext();
		System.out.println("Enter city: ");
		city = Utility.retNext();
		System.out.println("Enter state: ");
		state = Utility.retNext();
		System.out.println("Enter zipCode: ");
		zipCode = Utility.retNext();
		System.out.println("Enter contact number: ");
		phoneNumber = Utility.readLong();
		PersonDetails person = new PersonDetails(fName, lName, address, city, state, zipCode, phoneNumber);
		addressBook.getPersonList().add(person);
		System.err.println("Person details added successfully");
		Utility.convertJavaToJson(addressBook.getPersonList(), select);
		showOptions();
	}

	/**
	 * This function update the person details
	 */
	public void editPerson(int index) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("What do you want to update ? ");
		System.out.println("1: To change \"Address\"");
		System.out.println("2: To change \"City\"");
		System.out.println("3: To change \"State\"");
		System.out.println("4: To change \"zipCode\"");
		System.out.println("5: To change \"contact number\"");
		int option = Utility.reInteger();
		switch (option) {
		case 1:
			System.out.println("Enter new Address");
			String newAddress = Utility.retNext();
			addressBook.getPersonList().get(index).setAddress(newAddress);
			//Utility.convertJavaToJson(addressBook.getPersonList(), select);
			System.err.println("Person details update successfully");
			//showBook();
			showOptions();
			break;
		case 2:
			System.out.println("Enter the new city name");
			String newCity = Utility.retNext();
			addressBook.getPersonList().get(index).setCity(newCity);
			//Utility.convertJavaToJson(addressBook.getPersonList(), select);
			System.err.println("Person details update successfully");
			//showBook();
			showOptions();
			break;
		case 3:
			System.out.println("Enter the new state name");
			String newState = Utility.retNext();
			addressBook.getPersonList().get(index).setState(newState);
			//Utility.convertJavaToJson(addressBook.getPersonList(), select);
			System.err.println("Person details update successfully");
			//showBook();
			showOptions();
			break;
		case 4:
			System.out.println("Enter the new ZipCode");
			String newZipCode = Utility.retNext();
			addressBook.getPersonList().get(index).setZipCode(newZipCode);
			//Utility.convertJavaToJson(addressBook.getPersonList(), select);
			System.err.println("Person details update successfully");
			//showBook();
			showOptions();
			break;
		case 5:
			System.out.println("Enter the new Contact number");
			String newMobNumber = Utility.retNext();
			addressBook.getPersonList().get(index).setZipCode(newMobNumber);
			//Utility.convertJavaToJson(addressBook.getPersonList(), select);
			System.err.println("Person details update successfully");
			//showBook();
			showOptions();
			break;
		}
	}

	/**
	 * This function delete the person details
	 */
	public void deletePerson(int index1) throws JsonGenerationException, JsonMappingException, IOException {
		addressBook.getPersonList().remove(index1);
		System.err.println("data delete successfully");
		//Utility.convertJavaToJson(addressBook.getPersonList(), select);
		//showBook();
		showOptions();
	}

	/**
	 * This function sort the person details by last name
	 */
	public void sortByLastName() throws JsonGenerationException, JsonMappingException, IOException {
		for (int i = 0; i < addressBook.getPersonList().size() - 1; i++) {
			for (int j = i + 1; j < addressBook.getPersonList().size(); j++) {
				if (addressBook.getPersonList().get(i).getLastName()
						.compareTo(addressBook.getPersonList().get(j).getLastName()) > 0) {
					PersonDetails optional = addressBook.getPersonList().get(i);
					addressBook.getPersonList().set(i, addressBook.getPersonList().get(j));
					addressBook.getPersonList().set(j, optional);
				} else if (addressBook.getPersonList().get(i).getLastName()
						.compareTo(addressBook.getPersonList().get(j).getLastName()) == 0) {
					sortByFirstName(addressBook.getPersonList().get(i), i, addressBook.getPersonList().get(j), j);
				}
			}
		}
		System.err.println("sorted by LastName successfully");
		//Utility.convertJavaToJson(addressBook.getPersonList(), select);
		//showBook();
		showOptions();
	}

	/**
	 * this function sort the user details by zipcode
	 */
	public void sortByZip() throws JsonGenerationException, JsonMappingException, IOException {
		for (int i = 0; i < addressBook.getPersonList().size() - 1; i++) {
			for (int j = i + 1; j < addressBook.getPersonList().size(); j++) {
				if (addressBook.getPersonList().get(i).getZipCode()
						.compareTo(addressBook.getPersonList().get(j).getZipCode()) > 0) {
					PersonDetails optional = addressBook.getPersonList().get(i);
					addressBook.getPersonList().set(i, addressBook.getPersonList().get(j));
					addressBook.getPersonList().set(j, optional);
				} else if (addressBook.getPersonList().get(i).getZipCode()
						.compareTo(addressBook.getPersonList().get(j).getZipCode()) == 0) {
					sortByFirstName(addressBook.getPersonList().get(i), i, addressBook.getPersonList().get(j), j);
				}
			}
		}
		System.err.println("sorted by zipcode successfully");
		//Utility.convertJavaToJson(addressBook.getPersonList(), select);
		//showBook();
		showOptions();
	}

	/**
	 * this function sort the user details by first name
	 * @param object1 is the one person detail
	 * @param i is the index
	 * @param object2 is the another person detail
	 * @param j is the index
	 */
	private void sortByFirstName(PersonDetails object1, int i, PersonDetails object2, int j) {

		if (object1.getFirstName().compareTo(object2.getFirstName()) > 0) {
			PersonDetails optional = object1;
			addressBook.getPersonList().set(i, object2);
			addressBook.getPersonList().set(j, optional);
		}
	}

	/**
	 * this function print the json file on console
	 */
	public void showBook() throws JsonGenerationException, JsonMappingException {
		System.out.println("\t\t\t---This is our addressBook---");
		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader(select));
			JSONArray personArray = (JSONArray) object;
			for (int i = 0; i < personArray.size(); i++) {
				JSONObject details = (JSONObject) personArray.get(i);
				System.out.println("index : " + i + " " + details);
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

}
