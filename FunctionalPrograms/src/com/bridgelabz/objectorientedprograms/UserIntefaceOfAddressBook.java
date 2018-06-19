package com.bridgelabz.objectorientedprograms;

import java.io.IOException;
import com.bridgelabz.utility.Utility;

/**The software to be designed is a program that can be used to maintain an address book. An address book
holds a collection of entries,of persons and creates multiple address books as per users need
 * @author yuga
 * @version 1.0
 * @since 07/06/2018
 *
 */
public class UserIntefaceOfAddressBook {
	static final String STORAGE_FILE_PATH = "/home/adminsitrator/Documents/JavaProgramming/FunctionalPrograms/src/com/bridgelabz/objectorientedprograms/StorageFiles.json";
	public static void main(String[] args) throws IOException {
		AddressBookManager bookManager = new AddressBookManager(STORAGE_FILE_PATH);
		showInitialOptions(bookManager);
	}

	/**This function show initial options to perform some operations such as create ,delete,open, view address book
	 * @param bookManager
	 */
	public static void showInitialOptions(AddressBookManager bookManager) {
		System.out.println("Choose One from following options: ");
		System.out.println("1.CREATE\t\t 2.OPEN\t\t 3.VIEW\t\t 4.DELETE\t\t 5.QUIT");
		int option = Utility.reInteger();
		switch (option) {
		case 1:
			bookManager.createNew();
			bookManager.showList();
			break;
		case 2:
			System.out.println("Which AddressBook you want to open ? ");
			bookManager.showList();
			System.out.println("Enter index");
			int indexOfFile = Utility.reInteger();
			bookManager.openExistingAddressBook(indexOfFile);
			break;
		case 3:
			System.out.println(" This Address Books are exist");
			bookManager.showList();
			showInitialOptions(bookManager);
			break;
		case 4:
			System.out.println("Which address book you want to delete");
			bookManager.showList();
			System.out.println("Enter index: ");
			int index = Utility.reInteger();
			bookManager.deleteAddressBook(index);
			bookManager.showList();
			showInitialOptions(bookManager);
			break;
		case 5:
			bookManager.exit();
			
			break;
		}
	}
}
