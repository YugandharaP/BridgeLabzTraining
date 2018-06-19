package com.bridgelabz.dataStructure;

import com.bridgelabz.utility.Utility;

/**purpose-To display calendar using Queue
 * @author yuga
 *@version 1.0
 * @since   30-05-2018
 */
public class BinarySearchTree 
{
	public static void main(String[] args) {
		System.out.println("How many test case you want:  ");
		int testCase=Utility.reInteger();
		int[]result=new int [testCase];
		for(int i=0;i<testCase;i++)
		{
			System.out.println("Enter  nodes you want ");
			int nodes=Utility.reInteger();
			result[i]=countTree(nodes);			
		}
		for(int i=0;i<result.length;i++)
		{
			System.out.println("number of binary search tree : "+result[i]);
		}
}

	public static int countTree(int nodes) {
		int output=0;
		output= factorial(2*nodes)/(factorial(nodes+1) * factorial(nodes));
		return output;
	}

	public static int factorial(int number) {
		int fact=1;
		for(int i=0;i<number;i++)
		{
			fact = fact*i;
		}
		return fact;
	}

}
