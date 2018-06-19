package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

/** purpose-to check two strings are Anagram or not.Anagram means both strings contain same characters
 *@author  Yuga
 *@version 1.0
 *@since   19-05-2018
 */
public class Anagram {

	/**
	 * this function remove the spaces between the string_characters
	 * @param string its taking the both strings to remove spaces
	 * @return modified string
	 */
	private static String removeSpace(String string) {
		String temp = "";
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != ' ') {
				temp += string.charAt(i);
			}
		}
		return temp;
	}
	public static void main(String[] args) {
		System.out.println("Enter first String: ");
		String string1 = Utility.retNextLine();
		System.out.println("Enter second String: ");
		String string2 = Utility.retNextLine();

		string1 = removeSpace(string1);
		string2 = removeSpace(string2);
		// check length of two strings.if not equal then print the message otherwise
		// check other conditions
		if (string1.length() == string2.length()) {
			string1 = string1.toLowerCase();
			string2 = string2.toLowerCase();
			string1 = Utility.sort(string1);
			string2 = Utility.sort(string2);
			// two strings are compare using equals method of Object class
			if (string1.equals(string2)) {
				System.out.println("Strings are Anagram");
			} else {
				System.out.println("Strings are not Anagram !");
			}
		} else {
			System.out.println("Strings are not Anagram !");
		}
	}
}
