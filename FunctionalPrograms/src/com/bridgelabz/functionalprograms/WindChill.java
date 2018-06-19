/** purpose-To calculate the weather temperature is to be windchill
* @author Yuga
* @version 1.0
* @since 18-05-2018
*/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

/**To calculate the weather temperature is to be windchill
 * @author yuga
 */
public class WindChill {
	public static void main(String[] args) {
		double temparature = Double.parseDouble(args[0]);
		double speed = Double.parseDouble(args[1]);
		if (temparature >= 50 && speed >= 3 && speed <= 120) {
			double weather = Utility.calculateWindChill(temparature, speed);
			System.out.println(
					"National Weather Service defines the effective temperature the wind chill to be: " + weather);
		} else {
			System.out.println("Error: This program is only applicable if temparature is greater than 50 and speed is greater than 3 and less than 120 ");
		}
	}
}
