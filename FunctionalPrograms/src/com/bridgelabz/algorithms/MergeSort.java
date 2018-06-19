/************************************************************************************************************
 * purpose-sort the Strings using mergesort algorithm
 *@author  Yuga
 *@version 1.0
 *@since   23-05-2018
 **************************************************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

/**sort the Strings using mergesort algorithm
 * @author yuga
 */
public class MergeSort {

	public static  void main(String[] args) {
		System.out.println("Enter how many elements you want to sort");
		int input=Utility.reInteger();
		System.out.println("Enter elements");
		String [] array=new String[input];
		for(int i=0;i<input;i++)
		{
			array[i]=Utility.retNext();
		}
		Utility.mergeSort(array,0,array.length-1);
		//printing sorted array
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
		}
	}
}
