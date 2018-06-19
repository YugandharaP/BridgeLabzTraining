/************************************************************************
 *purpose-this function to calculate head and tail percentage after fliping a coin
 *@author Yuga
 *@version 1.0
 *@since   17-05-2018
 *****************************************************************************/
package com.bridgelabz.functionalprograms;
import com.bridgelabz.utility.Utility;

/**
 * this program calculate the percentage of head and tail after fliping coin
 * @author Yuga
 *
 */
public class FlipCoin {
	static double head;
	static double tail;
	static double PERCENTAGE_head;
	static double PERCENTAGE_tail;


	public static void main(String[] args) {
			System.out.println("Enter the number for how many times you want to flip the coin: ");
			int chances = Utility.reInteger();
			for(int i=0;i<chances;i++) {
				if (Math.random() > 0.5)
					head++;
				else
					tail++;
			}
			PERCENTAGE_head = (head / (head+tail)) * 100;
			System.out.println("head percentage: "+PERCENTAGE_head);
			System.out.println("tail percentage: "+(100-PERCENTAGE_head));
		}

}
