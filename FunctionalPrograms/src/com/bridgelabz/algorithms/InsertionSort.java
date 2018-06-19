
/************************************************************************************************************
 * purpose-to sort the Strings using Insertion sort algorithm
 *@author  Yuga
 *@version 1.0
 *@since   21-05-2018
 **************************************************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

/**to sort the Strings using Insertion sort algorithm
 * @author yuga
 */
public class InsertionSort {

	public static <T> void main(String[] args) {
		System.out.println("How many String you want to sort ?: ");
		int size = Utility.reInteger();
		System.out.println("What type of elements you want to insert : \n 1. Integer \t 2.String");
		System.out.println("Press 1 for Integer \nPress 2 for String");
		int input = Utility.reInteger();
		switch (input) {
		case 1:
			Integer[] array1 = new Integer[size];
			System.out.println("Enter Integer Elements");
			for (int i = 0; i < size; i++) {
				array1[i] = Utility.reInteger();
			}
			Utility.insertionSort(array1);
			Utility.printArray(array1);
			break;
		case 2:
			String[] array = new String[size];
			System.out.println("Enter String Elements");
			for (int i = 0; i < size; i++) {
				array[i] = Utility.retNext();
			}
			Utility.insertionSort(array);
			Utility.printArray(array);
			break;
		default:
			System.out.println("No such data type!");
		}
	}
}
