/**This is find the root of number using newton method
 * @author Yuga
 *@version 1.0
 *@since   21-05-2018
 */
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

/**This is find the root of number using newton method
 * @author yuga
 */
public class NewtonMethod {

	public static void main(String[] args) {
		System.out.println("Enter the number");
		int number= Utility.reInteger();
		
		if(number>0)
		{
			double root=sqrt(number);
			System.out.println("The square root of number is :" +root);
		}
		else
		{
			try {
				throw new MyException("Only enter positive integer");
			}catch(MyException exp){
				System.err.println(exp) ;
			}
		}
	}

	/**This function calculate the root of number using newton method and return root
	 * @param number
	 * @return root
	 */
	private static double sqrt(int number) {
			double t=number;
			double epsilon=1e-15;
			while(Math.abs(t-number/t) > epsilon*t)
			{
				t = (number/t + t)/2;
			}
			return t;
	}

}
