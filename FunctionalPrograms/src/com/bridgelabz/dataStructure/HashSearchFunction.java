package com.bridgelabz.dataStructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.utility.Utility;

public class HashSearchFunction {

	public static void main(String[] args) throws IOException {
		String path = "/home/adminsitrator/Documents/JavaProgramming/FunctionalPrograms/src/com/bridgelabz/dataStructure/hashFile";
		FileReader fReader = new FileReader(new File(path));
		BufferedReader bReader = new BufferedReader(fReader);
		String string = bReader.readLine();
		String[] array = string.split(",");
		Integer[] arrayInt = new Integer[array.length];
		for (int i = 0; i < arrayInt.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}
		MyLinkedList[] listArray = new MyLinkedList[11];
		for (int i = 0; i < 11; i++) {
			listArray[i] = new MyLinkedList();

		}
		int index = 0;
		for (int i = 0; i < arrayInt.length; i++) {
			index = arrayInt[i] % 11;
			System.out.println("i:" + i + "  index: " + index + "  array element " + arrayInt[i]);
			listArray[index].addElement(arrayInt[i]);
		}

		// printListArray(listArray);

		System.out.println("Enter number which you want to search: ");
		int searchNumber = Utility.reInteger();
		index = searchNumber % 11;

		if (listArray[index].searchElement(searchNumber) == true) {
			System.out.println("The number found in the List");
			MyLinkedList.removeElement(searchNumber);
			
		} else {
			System.out.println("Don't worry.We will add it into List");
			listArray[index].addElement(searchNumber);
		}
		printListArray(listArray);
	}

	public static void printListArray(MyLinkedList[] listArray) {
		// System.out.println(listArray.length);
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < listArray[i].size(); j++) {
				System.out.print(listArray[i].get(j) + " ");
				//System.out.println("i: " + i + "  J:" + listArray[i].get(j));
			}
			System.out.println();
		}
	}

}
