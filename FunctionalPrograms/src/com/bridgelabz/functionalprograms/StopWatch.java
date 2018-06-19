
/***************************************************************************************************************
 * purpose-To measure the time elapsed between start time and end time.
 * @author Yuga
 * @version 1.0
 * @since   18-05-2018
 *
 ***************************************************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

/**To measure the time elapsed between start time and end time.
 * @author yuga
 *
 */
public class StopWatch {
	public static void main(String[] args) {
		long startTime = 0; // store startTime
		long stopTime = 0; // store stopTime
		long elapsedTime=Utility.stopWatch(startTime,stopTime);
		System.out.println("Elapsed time is : "+elapsedTime);
	}
}
