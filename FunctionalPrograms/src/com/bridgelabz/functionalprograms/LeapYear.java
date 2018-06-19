/*Purpose: To check given year is leap year or not                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
* @author  Yuga
* @version 1.0
* @since   17-05-2018
*  */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

/**To check given year is leap year or not  
 * @author yuga
 */
public class LeapYear {
	public static void main(String[] args) {
			System.out.println("Enter the year: ");
			int year =Utility.reInteger();
		
			boolean result=Utility.isLeapYear(year);
			if(result==true)
			{
				System.out.println(year +" is leap year");
			}else
			{
				System.out.println(year +" is not leap year");
			}
		}
}

