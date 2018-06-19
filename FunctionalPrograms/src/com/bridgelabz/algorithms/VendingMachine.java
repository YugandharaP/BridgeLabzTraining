/*************************************************************************************************************************
 * purpose-Calculate the minimum number of Notes as well as the Notes to be returned by the Vending Machine as a Change
 *taking array for Notes
 *using Recursion Calculating number of minimum Notes Return by Vending machine
 *@author  Yuga
 *@version 1.0
 *@since   22-05-2018
 *************************************************************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

/**Calculate the minimum number of Notes as well as the Notes to be returned by the Vending Machine as a Change
 *taking array for Notes
 *using Recursion Calculating number of minimum Notes Return by Vending machine
 * @author yuga
 */
public class VendingMachine {
	public static void main(String[] args) {
		System.out.println("Enter amout:");
		int money = Utility.reInteger();
		int index = 0;
		Utility.calculatingNotes(money, index);
	}
}
