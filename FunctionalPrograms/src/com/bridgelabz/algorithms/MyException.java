/**This is created to user defined exception
 * @author Yuga
 *@version 1.0
 *@since   21-05-2018
 */
package com.bridgelabz.algorithms;

public class MyException extends Exception {
	String str1;
	public MyException(String str2) {
		str1 = str2;
	}
	@Override
	public String toString() {
		return "MyException: " + str1;
	}
}
