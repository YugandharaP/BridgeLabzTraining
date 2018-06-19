package com.bridgelabz.dataStructure;

import com.bridgelabz.utility.Utility;
/**purpose- To check string is palindrom or not .In that string added into deque list and then remove character by character to check palindrom condition
 *@author Yuga
 *@since   28-05-2018
 */
public class PalindromChecker {
	public static void main(String[] args) {
		System.out.println("Enter a String: ");
		String string = Utility.retNextLine();
		boolean condition = checkPalindrom(string);
		if (condition == true) {
			System.out.println("String is Palindrom");
		} else
			System.out.println("String is not Palindrom");
	}
	/**this function is check the palindrom conditon
	 * @param string to be given by user
	 * @return boolean value
	 */
	public static boolean checkPalindrom(String string) {
		char[] array = string.toCharArray();
		for (int i = 0; i < string.length(); i++) {
			MyDeque.addRaer(array[i]);
		}
		int size = MyDeque.size() / 2;
		for (int i = 0; i < size; i++) {
			if (!MyDeque.removeFront().equals(MyDeque.removeRaer())) {
				return false;
			}
		}
		return true;
	}
}
