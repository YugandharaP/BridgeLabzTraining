/************************************************************************************************************
 * purpose-To convert binary to decimal and swap nibbles and again convert binary to decimal
 *@author  Yuga
 *@version 1.0
 *@since   23-05-2018
 **************************************************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

/**To convert binary to decimal and swap nibbles and again convert binary to decimal
 * @author yuga
 */
public class BinarySwapNibble {

	public static void main(String[] args) {
		System.out.println("Enter the decimal number");
		int decimalNum=Utility.reInteger();
		
		String binary=Utility.toBinary(decimalNum);
		System.out.println("The binary number is: "+binary);
		String newBinary =Utility.swapNibble(binary);
		System.out.println("The binary number is: "+newBinary);
		int newDecimal=Utility.toDecimal(newBinary);
		System.out.println("The new decimal Number is : "+newDecimal);
	}

}
