/*****************************************************************************************************************
 * purpose- this is design to solve the Quadratic cequations.In that three condition is their if delta>0,
 *  if delta<0 (here calculate the real and imaginary part and find roots of that)and if delta==0
 * @author Yuga
 * @version 1.0
 * @since   18-05-2018
 ******************************************************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

/**this is design to solve the Quadratic cequations.In that three condition is their if delta>0,
 *  if delta<0 (here calculate the real and imaginary part and find roots of that)and if delta==0
 * @author yuga
 *
 */
public class QuadraticEquation {

	/**this function find the roots of the number
	 * @param numFirst to taking the value for 'a' from user
	 * @param numSecond to taking the value for 'b' from user
	 * @param numThird to taking the value for 'c' from user
	 */
	public static void findRoots(int numFirst, int numSecond, int numThird) {
		double delta = (numSecond * numSecond) - (4 * numFirst * numThird);
		double root1Ofx = 0;
		double root2Ofx = 0;
		if (delta > 0) {
			root1Ofx = (-(numSecond) + Math.sqrt(delta)) / (2 * numFirst);
			root2Ofx = (-(numSecond) - Math.sqrt(delta)) / (2 * numFirst);
			System.out.println("root-1 of 'x' = " + root1Ofx);
			System.out.println("root-2 of 'x' = " + root2Ofx);
		} else if (delta < 0) {
			System.out.println("root 1 of x:is the real part = " + (-numSecond) / (2 * numFirst));
			System.out.println("root 2 of x:is the imaginary part = " + Math.sqrt((-delta) / (2 * numFirst)));
		} else {
			System.out.println("root-1 of 'x' and root-2 of 'x' = " + (-numSecond) / (2 * numFirst));
		}
	}
	public static void main(String[] args) {
		System.out.println("Enter the values for 'a' :");
		int numFirst = Utility.reInteger();
		System.out.println("Enter the values for 'b' :");
		int numSecond = Utility.reInteger();
		System.out.println("Enter the values for 'c' :");
		int numThird = Utility.reInteger();
		findRoots(numFirst, numSecond, numThird);
	}

	
	
	
	
	
	
	
	
}
