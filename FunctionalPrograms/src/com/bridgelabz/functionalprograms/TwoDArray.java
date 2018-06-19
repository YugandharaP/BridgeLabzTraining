
/*
 * purpose-2D arrays of integers and doubles from standard input and printing them out to standard output.
 *@author  Yuga
 *@version 1.0
 *@since   17-05-2018
 */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;


public class TwoDArray {

	public static void main(String[] args) {

		System.out.println("Enter your choice:");
		System.out.println("Press 1 for Integer");
		System.out.println("Press 2 for Double");
		System.out.println("Press 3 for Boolean");
		int input = Utility.reInteger();
		Utility.twoDArray(input);

	}

}
