package com.bridgelabz.addressbook.serviceimplementation;

import java.sql.SQLException;

import com.bridgelabz.addressbook.DAO.DataAccessObject;
import com.bridgelabz.addressbook.controller.AddressBookApplication;
import com.bridgelabz.addressbook.model.PersonDetails;
import com.bridgelabz.addressbook.service.AddressBookMediator;
import com.bridgelabz.addressbook.utility.Utility;

public class AddressBookJDBC implements AddressBookMediator {
	static DataAccessObject object = new DataAccessObject();
	static String currentAddressBook;
	AddressBook addressBook = new AddressBook();

	public AddressBookJDBC() {
		doInitially();
	}

	private void doInitially() {
		object.connectionPoolFactory();
		System.out.println("connection establish");
	}

	@Override
	public boolean createNew() {
		String bookName = Utility.retNext();
		String createNew = "create table " + bookName
				+ "(FirstName varchar(10),LastName varchar(10),Address varchar(30),City varchar(10), State varchar(10), ZipCode bigint, PhoneNum bigint)";
		try {
			object.pst = object.con.prepareStatement(createNew);
			object.pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public void showList() {
		String addressBookList = "show tables";
		try {
			object.pst = object.con.prepareStatement(addressBookList);
			object.res = object.pst.executeQuery();
			while (object.res.next()) {
				String table = object.res.getString(1);
				System.out.println("AddressBook : " + table);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void openExistingAddressBook(String bookName) {
		currentAddressBook = bookName;
		String fetch = "select * from " + currentAddressBook;
		try {
			object.pst = object.con.prepareStatement(fetch);
			object.res = object.pst.executeQuery();
			while (object.res.next()) {
				String fname = object.res.getString(1);
				String lname = object.res.getString(2);
				String address = object.res.getString(3);
				String city = object.res.getString(4);
				String state = object.res.getString(5);
				String zipcode = object.res.getString(6);
				long mobileNum = object.res.getLong(7);
				PersonDetails oldPerson = new PersonDetails(fname, lname, address, city, state, zipcode, mobileNum);
				addressBook.add(oldPerson);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAddressBook(String name) {
		String delete = "drop table " + name;
		try {
			object.pst = object.con.prepareStatement(delete);
			object.pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void exit() {
		int input = Utility.reInteger();
		if (input == 0) {
			System.out.println("Do you want to save ? yes[0]/No[1]");
			int option = Utility.reInteger();
			if (option == 0) {
				save();
			}
			System.out.println("Thanks Visit again");
			object.closeCostlyConnections();
			System.exit(0);
		} else {
			AddressBookApplication.showInitialOptions();
		}
	}

	@Override
	public void save() {
		try {
			object.stmt.executeBatch();
			System.out.println("Data Saved Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	@Override
	public void personOperations(int option, PersonDetails person, long mobile) {
		if (option == 1) {
			String fname = person.getFirstName();
			String lname = person.getLastName();
			String address = person.getAddress();
			String city = person.getCity();
			String state = person.getState();
			String zipcode = person.getZipCode();
			mobile = person.getPhoneNum();
			addressBook.add(person);
			String insert = "insert into " + currentAddressBook + " values('" + fname + "','" + lname + "','" + address
					+ "','" + city + "','" + state + "','" + zipcode + "','" + mobile + "')";
			connection(insert);
		} else if (option == 2) {
			int index = searchByMobileNumber(mobile);
			person = addressBook.getPersonList().get(index);
			selectOptionAndEdit(index, mobile, person);

		} else if (option == 3) {
			addressBook.delete(mobile);
			String delete = "delete from " + currentAddressBook + " where PhoneNum = " + mobile;
			connection(delete);
		}
	}

	@Override
	public int searchByMobileNumber(long mobile) {
		for (int i = 0; i < addressBook.getPersonList().size(); i++) {
			if (addressBook.getPersonList().get(i).getPhoneNum() == mobile) {
				return i;
			}
		}
		return -1;
	}

	public void selectOptionAndEdit(int index, long mobile, PersonDetails person) {
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
			String update = "update " + currentAddressBook + " set  Address = '" + newAddress + "' where PhoneNum ="
					+ mobile;
			connection(update);
			AddressBookApplication.showOptions();
			break;
		case 2:
			System.out.println("Enter the new city name");
			String newCity = Utility.retNext();
			addressBook.getPersonList().get(index).setCity(newCity);
			String update1 = "update " + currentAddressBook + " set  City = '" + newCity + "' where PhoneNum ="
					+ mobile;
			connection(update1);
			AddressBookApplication.showOptions();
			break;
		case 3:
			System.out.println("Enter the new state name");
			String newState = Utility.retNext();
			addressBook.getPersonList().get(index).setState(newState);
			String update2 = "update " + currentAddressBook + " set  State = '" + newState + "' where PhoneNum ="
					+ mobile;
			connection(update2);
			AddressBookApplication.showOptions();
			break;
		case 4:
			System.out.println("Enter the new ZipCode");
			String newZipCode = Utility.retNext();
			addressBook.getPersonList().get(index).setZipCode(newZipCode);
			String update3 = "update " + currentAddressBook + " set  ZipCode = '" + newZipCode + "' where PhoneNum ="
					+ mobile;
			connection(update3);
			AddressBookApplication.showOptions();
			break;
		default:
			System.out.println("No such option!");
			AddressBookApplication.showOptions();
		}
	}

	public void connection(String query) {
		try {
			object.stmt = object.con.createStatement();
			object.stmt.addBatch(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showpersons() {
		addressBook.getAll();
	}

}
