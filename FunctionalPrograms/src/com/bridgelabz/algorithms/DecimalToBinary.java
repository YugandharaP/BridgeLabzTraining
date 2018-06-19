/************************************************************************************************************
 *purpose-To convert decimal to binary and padd the zero's to make 8-digit binary length
 *@author  Yuga
 *@version 1.0
 *@since   23-05-2018
 **************************************************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

/**To convert decimal to binary and padd the zero's to make 8-digit binary length
 * @author yuga
 */
public class DecimalToBinary {

	public static void main(String[] args) {
		System.out.println("Enter the decimal number");
		int decimalNum=Utility.reInteger();
		
		String binary=Utility.toBinary(decimalNum);
		System.out.println("The binary number is: "+binary);
	}
}
