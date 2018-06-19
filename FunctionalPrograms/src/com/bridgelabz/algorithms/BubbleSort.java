/************************************************************************************************************
 * purpose-to sort the elements using Bubble sort algorithm
 *@author  Yuga
 *@version 1.0
 *@since   21-05-2018
 **************************************************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

/**to sort the elements using Bubble sort algorithm
 * @author yuga
 */
public class BubbleSort {

	public static <T> void main(String[] args) {
		System.out.println("How many elements you want to sort? ");
		int size = Utility.reInteger();
		System.out.println("What type of elements you want to insert : \n 1. Integer \t 2.String");
		System.out.println("Press 1 for Integer \nPress 2 for String");
		int input = Utility.reInteger();
		switch (input) {
		case 1:
			System.out.println("Enter Integer Elements: ");
			Integer[] array = new Integer[size];
			for (int i = 0; i < size; i++) {
				array[i] = Utility.reInteger();
			}
			Utility.bubbleSort(array);
			Utility.printArray(array);
			break;
		case 2:
			System.out.println("Enter Strings: ");
			String[] array1 = new String[size];
			for (int i = 0; i < size; i++) {
				array1[i] = Utility.retNext();
			}
			Utility.bubbleSort(array1);
			Utility.printArray(array1);
			break;
		default:
			System.out.println("No such a type !");
		}
	}
}
