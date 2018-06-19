/**Purpose: This program takes a command­line argument N and prints a table of the
powers of 2 that are less than or equal to 2^N.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
*  @author  Yuga
*  @version 1.0
*  @since   16-05-2018
*/

package com.bridgelabz.functionalprograms;

import java.lang.Math;

import com.bridgelabz.utility.Utility;

/**This program takes a command­line argument N and prints a table of the
powers of 2 that are less than or equal to 2^N.  
 * @author yuga
 */
public class PowerOfTwo {
	public static void main(String[] args) {
		int input = Integer.parseInt(args[0]);

		if (input>=0 && input < 31) {
			Utility.powerOfTwo(input);
		}
	}

}
