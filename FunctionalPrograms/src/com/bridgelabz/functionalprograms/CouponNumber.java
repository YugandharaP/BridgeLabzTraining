
/**************************************************************************************************************************
 * purpose-Given N distinct Coupon Numbers, how many random numbers do you need to generate that distinct coupon number?
 * @author Yuga
 * @version 1.0
 * @since   18-05-2018
 *************************************************************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

/**
 * Given N distinct Coupon Numbers, how many random numbers do you need to generate that distinct coupon number.
 */
public class CouponNumber {

	public static void main(String[] args) {
		System.out.println("Enter how many coupon number you want :");
		int couponNumber = Utility.reInteger();
		int output = Utility.couponGenerator(couponNumber);
		System.out.println("To generate dinstinct coupon number," + output + " times generate the random value");
	}

}
