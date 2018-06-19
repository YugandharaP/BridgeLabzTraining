/**Purpose: To take User Input and Replace with String Template                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
*  @author  Yuga
*  @version 1.0
*  @since   16-05-2018
*/

package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class ReplaceString {
	public static void main(String[] args) {

		System.out.println("Enter Username: ");
		String username = Utility.retNext();
		System.out.println(Utility.replaceString(username));

	}

}
