package com.bridgelabz.objectorientedprograms;

import com.bridgelabz.utility.Utility;

/**Using Regex to relace the user inputs with template.
 * RegularExpression or Regex (in short) is an API for defining String patterns that can be used for searching, manipulating and editing a text
 * @author yuga
 * @version 1.0
 * @since   31-05-2018
 */
public class RegularExpression {
static String fName;
static String fullName;
static String phoneNo;
static String TEMPLATE="Hello <<name>>, We have your full name as <<full name>> in our system. your contact number is 91­-xxxxxxxxxx.Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.";
	public static void main(String[] args) {
		System.out.println("Enter your FirstName :  ");
		fName=Utility.retNextLine();
		System.out.println("Enter your LastName :  ");
		String lName=Utility.retNextLine();
		System.out.println("Enter your phone Number :  ");
		phoneNo=Utility.retNextLine();
		String date=Utility.todayDate();
		fullName=fName+" "+lName;
		String regexfName= "<<name>>";
		String regexfullName = "<<full name>>";
		String regexphoneNo= "xxxxxxxxxx";
		String regexDate="01/01/2016";
		
		TEMPLATE=Utility.repalceOperation(regexfName,TEMPLATE,fName);
		TEMPLATE=Utility.repalceOperation(regexfullName,TEMPLATE,fullName);
		TEMPLATE=Utility.repalceOperation(regexphoneNo,TEMPLATE,phoneNo);
		TEMPLATE=Utility.repalceOperation(regexDate,TEMPLATE,date);
		
		System.out.println(TEMPLATE);
	}
}
