/*********************************************************************************************************************************************************
 *purpose-takes a command­line argument N, asks you to think of a number between 0 and N­-1,and ask random questions to guess the number using binary search 
 *Anagram means both strings contain same number and palindrom means the reverse number exact same as the original number
 *@author  Yuga
 *@version 1.0
 *@since   21-05-2018
 *************************************************************************************************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

/**takes a command­line argument N, asks you to think of a number between 0 and N­-1,and ask random questions to guess the number using binary search 
 *Anagram means both strings contain same number and palindrom means the reverse number exact same as the original number
 * @author yuga
 */
public class GuessingNumber {
	public static void main(String[] args) {
		int power = Integer.parseInt(args[0]);
		int low = 0;
		int high = power - 1;
		System.out.println("Guess the number between: " + low + " - " + high);
		SearchElement(low, high);
	}

	/**this function call recursively to guess the number */
	public static void SearchElement(int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			System.out.println("Is number in between " + low + " - " + mid);
			if (Utility.readBoolean()) {
				SearchElement(low, mid);
				return;
			} else {
				SearchElement(mid + 1, high);
				return;
			}
		} else
			System.out.println(low);

	}

}
