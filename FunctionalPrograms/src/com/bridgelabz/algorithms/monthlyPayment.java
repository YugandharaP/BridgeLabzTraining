/************************************************************************************************************
 * purpose-To calculate monthly payment based on rate,year and principal
 *@author  Yuga
 *@version 1.0
 *@since   21-05-2018
 **************************************************************************************************************/
package com.bridgelabz.algorithms;

/**To calculate monthly payment based on rate,year and principal
 * @author yuga
 */
public class monthlyPayment {

	public static void main(String[] args) {
		double principal= Integer.parseInt(args[0]);
		double year= Integer.parseInt(args[1]);
		double rate= Integer.parseInt(args[2]);
		calculatePayment(principal,year,rate);
	}

	/**this function to calculate the monthly payment
	 * @param principal,year,rate
	 */
	private static void calculatePayment(double principal, double year, double rate) {
		double payment=0;
		double rPerc =rate/(1200);
		double month=12*year;
		payment= (principal*rPerc)/(1-1/(Math.pow((1+rPerc), month)));
		System.out.println("The Monthly Payment is : "+payment);
	}
}
