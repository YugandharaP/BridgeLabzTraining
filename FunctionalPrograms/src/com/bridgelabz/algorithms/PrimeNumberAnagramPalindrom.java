/*****************************************************************************************************************************
 *purpose-to check which two Prime numbers are Anagram and also check which prime numbers are palindrom.
 *Anagram means both strings contain same number and palindrom means the reverse number exact same as the original number
 *@author  Yuga
 *@version 1.0
 *@since   21-05-2018
 ****************************************************************************************************************************/

package com.bridgelabz.algorithms;

import java.util.Arrays;
import com.bridgelabz.utility.Utility;

/**to check which two Prime numbers are Anagram and also check which prime numbers are palindrom.
 *Anagram means both strings contain same number and palindrom means the reverse number exact same as the original number
 * @author yuga
 */
class PrimeNumberAnagramPalindrom {
	public static void main(String[] args) {
		String store = "";
		for (int num = 2; num <= 100; num++) {
			if (Utility.isPrime(num)) {
				store += num + " ";
			}
		}
		String[] array = store.split(" ");
		store = "";
		for (int i = 0; i < array.length; i++) {
			String temp = array[i];
			if (isPalindrome(temp)) {
				store += temp + " ";
			}
		}
		System.out.println("Prime Palindrom Numbers are: \n" + store);
		System.out.println("\n");
		System.out.println("Prime Anagram Nu7mbers are: ");
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (Utility.isAnagram(array[i], array[j])) {
					System.out.println(array[i] + " and " + array[j] + " are Anagram");
				}
			}
		}
	}
	/**
	 * this function check which numbers are palindrom
	 * @param number
	 * @return boolean value after checking the palindrom condition
	 */
	public static boolean isPalindrome(String number) {
		String optional = "";
		for (int i = number.length() - 1; i >= 0; i--)
			optional += number.charAt(i);
		if (optional.equals(number))
			return true;
		else
			return false;
	}
}
