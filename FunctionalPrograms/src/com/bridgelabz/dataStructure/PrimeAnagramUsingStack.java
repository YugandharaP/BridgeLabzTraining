package com.bridgelabz.dataStructure;

import com.bridgelabz.utility.Utility;

/**purpose-To check the number is prime number or not and find the anagram number from that. store anagram numbers in stack and prints the reverse order 
 * @author yuga
 *@since   28-05-2018
 */
public class PrimeAnagramUsingStack {
	public static void main(String[] args) {
		String temp = "";
		for (int num = 2; num <= 1000; num++) {
			if (Utility.isPrime(num)) {
				temp += num + " ";
			}
		}
		String[] array = temp.split(" ");
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (Utility.isAnagram(array[i], array[j])) {
					MyStack.push(array[i]);
					MyStack.push(array[j]);
				}
			}
		}
		System.out.println("Prime anagram in Stack");
		MyStack.displayStack();
	}

}
