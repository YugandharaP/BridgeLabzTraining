/************************************************************************************************************
 * purpose-prints the day of the week that date falls on.
 *@author  Yuga
 *@version 1.0
 *@since   23-05-2018
 **************************************************************************************************************/
package com.bridgelabz.algorithms;

import com.bridgelabz.utility.Utility;

/**prints the day of the week that date falls on.
 * @author yuga
 */
public class DayOfWeek {

	public static void main(String[] args) {
		int year= Integer.parseInt(args[0]);
		int date= Integer.parseInt(args[1]);
		int month= Integer.parseInt(args[2]);
		String [] array= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		if(Utility.isValidDate(month, date, year))
		{
			int result=Utility.dayOfWeek( month, date,year);
				System.out.println("Day is "+array[result]);
		}
	}

}
