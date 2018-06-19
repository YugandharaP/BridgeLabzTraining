
/************************************************************************************************************
 * purpose-read the file and Search the string index using binary search
 *@author  Yuga
 *@version 1.0
 *@since   22-05-2018
 **************************************************************************************************************/
package com.bridgelabz.algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.bridgelabz.utility.Utility;

/**read the file and Search the string index using binary search
 * @author yuga
 */
class BinarySearchForString {
	public String[] fileReader() throws IOException {
		FileReader fileReader = new FileReader("/home/adminsitrator/Documents/JavaProgramming/FunctionalPrograms/src/com/bridgelabz/Algorithms/file1");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String str = bufferedReader.readLine();
		String []array=str.split(",");
		return array;
	}
	 public static void main(String[] args) throws Exception {
	        BinarySearchForString bss=new BinarySearchForString();
	        String[] stringArray=bss.fileReader();
	        System.out.println("Sorting the String first");
	        Arrays.sort(stringArray);
			for(int i=0;i<stringArray.length;i++)
			{
				System.out.println(stringArray[i]);
			}
	        System.out.println("Enter the word you want to search");
	        String element= Utility.retNextLine();
	      System.out.println(Utility.binarySearch(stringArray, element));
	        
	    }
}