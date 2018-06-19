package com.bridgelabz.dataStructure;

import com.bridgelabz.utility.Utility;

/**purpose-To check The arithmetic expression is balanced or not.For that we use stack for push and pop the expression brackets to check the expression 
 *@author  Yuga
 *@version 1.0
 *@since   28-05-2018*/
public class BalancedParanthesis<T> {

	public static void main(String[] args) {
		System.out.println("Enter Expression :  ");
		String expression = Utility.retNextLine();
		Boolean condition = checkValidExpression(expression);
		if (condition == true) {
			System.out.println("Your expression is Balanced");
		} else
			System.out.println("Your expression is not Balanced");
	}

	/**To check the given expression is balanced or not
	 * @param arithmetic expression
	 * @return boolean type values
	 */
	public static <T> boolean checkValidExpression(String expression) {

		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '[') {
				MyStack.push(expression.charAt(i));
			} 
			else {
				if (MyStack.isEmpty()) {
					return false;
				}
				switch (expression.charAt(i)) {
				case ')':
					if (MyStack.peak().equals('(')) {
						MyStack.pop();
						continue;
					} else
						return false;
				case '}':
					if (MyStack.peak().equals('{')) {
						MyStack.pop();
						continue;
					} else
						return false;
				case ']':
					if (MyStack.peak().equals('[')) {
						MyStack.pop();
						continue;
					} else
						return false;
				}
			}
		}
		return true;
	}

}
