/*****************************************************************************************************************************
 *purpose-to check Numbers are prime number or not within the given range
 *@author  Yuga
 *@version 1.0
 *@since   21-05-2018
 ****************************************************************************************************************************/

package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

/**to check Numbers are prime number or not within the given range
 * @author yuga
 */
public class PrimeNumber {
	public	static String storage = "";
	public static void main(String[] args) {
		
		for (int num = 2; num <= 1000; num++) {
			if (Utility.isPrime(num)) {
				storage += num + " ";
			}
		}
		System.out.println("Prime numbers between 0-1000 are : \n "+storage);
	}
}
