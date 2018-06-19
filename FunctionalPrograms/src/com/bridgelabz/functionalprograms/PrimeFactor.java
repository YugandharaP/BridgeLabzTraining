/**Purpose: Computes the prime factorization for given number.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
*  @author  Yuga
*  @version 1.0
*  @since   16-05-2018
*/
package com.bridgelabz.functionalprograms;

import java.util.HashSet;
import com.bridgelabz.utility.Utility;

/**Computes the prime factorization for given number.   
 * @author yuga
 */
public class PrimeFactor {
	public static void main(String[] args) {
		System.out.println("Enter the Number");
		int input = Utility.reInteger();
		HashSet storage = Utility.isprimeFactor(input);
		System.out.println(storage);
	}
}