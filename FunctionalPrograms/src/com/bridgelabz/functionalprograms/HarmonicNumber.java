/**Purpose: Prints the Nth harmonic number: 1/1 + 1/2 + ... + 1/N                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
*  @author  Yuga
*  @version 1.0
*  @since   16-05-2018
 */
package com.bridgelabz.functionalprograms;

import java.util.Scanner;

/** Prints the Nth harmonic number: 1/1 + 1/2 + ... + 1/N     
 * @author yuga
 */
public class HarmonicNumber {

	static double HARMONIC_NUMBER=0;
	static double CONSTANT=1;
	public static void main(String[] args) {
		while(true) {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter The Number: ");
		int input=scn.nextInt();
		if(input!=0)
		{
			for(int i=1;i<=input;i++)
			{
				HARMONIC_NUMBER+=CONSTANT/i;
			}
		
			System.out.println("HARMONIC_NUMBER ("+input+") = "+HARMONIC_NUMBER);
			return;
		}
		else
			System.out.println("Not valid number! \nplease enter again :");
		continue;
		}

	}

}
