package com.bridgelabz.dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.bridgelabz.utility.Utility;

/**Read the Text from a file, split it into words and arrange it as Linked List.
Take a user input to search a Word in the List. If the Word is not found then add it
to the list, and if it found then remove the word from the List. In the end save the
list into a file
 * @author yuga
 *@since   26-05-2018
 */
public class UnOrderdList {
	
	/**this function is used to read the file
	 * @param path of the file
	 * @return array which contains data
	 * @throws IOException
	 */
	private static String[] readFile(String path) throws IOException {
		FileReader fRead = new FileReader(path);
		BufferedReader bReader = new BufferedReader(fRead);
		String string = bReader.readLine();
		String[] array = string.split(",");
		return array;
	}

	/**To write the data into file
	 * @param file
	 * @throws IOException
	 */
	public static void writeFile(File file) throws IOException {
		FileWriter fWriter = new FileWriter(file);
		System.out.println("Enter the words whith comma separated: ");
		String input = Utility.retNextLine();
		BufferedWriter bWriter = new BufferedWriter(fWriter);
		bWriter.write(input);
		bWriter.flush();
	}
	/**To search the element from the file,If found then remove that element from list otherwise add to the list
	 * @param array which contains data
	 */
	private static void SearchAndRemove(String[] array) {
		for (int i = 0; i < array.length; i++) {
			MyLinkedList.addElement(array[i]);
		}
		System.out.println("Enter the word which you to search in the  list: ");
		String searchWord = Utility.retNext();
		boolean value = MyLinkedList.searchElement(searchWord);
		if (value == true) {
			System.out.println("The word found in the List");
			MyLinkedList.removeElement(searchWord);
			System.out.println("search word removed from the list");
		} else if (value == false) {
			System.out.println("Don't worry.We will add it into List");
			MyLinkedList.addElement(searchWord);
		}
		MyLinkedList.display();
	}

	/**this is the main function
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String path = "/home/adminsitrator/Documents/JavaProgramming/FunctionalPrograms/src/com/bridgelabz/dataStructure/UnOrderdList";
		File file = new File(path);
		writeFile(file);
		String[] array = readFile(path);
		SearchAndRemove(array);
	}
}
