package com.bridgelabz.algorithms;

import java.util.Arrays;

import com.bridgelabz.utility.Utility;

/** purpose-to search the element from array using binary search algorithm
 *@author  Yuga
 *@since   21-05-2018
 */
public class BinarySearch {

	public static <T> void main(String[] args) {
		System.out.println("How many elements you want to enter ?");
		int size = Utility.reInteger();
		System.out.println("What type of elements you want to insert : \n 1. Integer \t 2.String");
		System.out.println("Press 1 for Integer \nPress 2 for String");
		int input = Utility.reInteger();
		switch (input) {
		case 1:
			Integer[] array = new Integer[size];
			System.out.println("Enter elements: ");
			for (int i = 0; i < size; i++) {
				array[i] = Utility.reInteger();
			}
			System.out.println("Which element you want to search?");
			int searchWord = Utility.reInteger();
			Arrays.sort(array);
			System.out.println(Utility.binarySearch(array, searchWord));
			break;
		case 2:
			String[] array1 = new String[size];
			System.out.println("Enter elements: ");
			for (int i = 0; i < size; i++) {
				array1[i] = Utility.retNext();
			}
			Arrays.sort(array1);
			System.out.println("Which element you want to search?");
			String searchWord1 = Utility.retNext();
			System.out.println(Utility.binarySearch(array1, searchWord1));
			break;
		default:
			System.out.println("No such datatype!");
		}

	}
}
