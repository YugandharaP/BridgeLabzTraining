package com.bridgelabz.functionalprograms;

import java.util.Scanner;

public class StringTemplate {

	static String TEMPLATE = "Hello <<username>>, How are you?";

	public static void main(String[] args) {

		while (true) {
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter Username: ");
			String username = scn.next();
			String output = "";

			if (username.length() < 3) {
				System.out.println("username should contain minimum three character!");
				System.out.println("please enter again: ");
				continue;
			} else {
				String[] array = TEMPLATE.split(" ");

				for (int i = 0; i < array.length; i++) {
					if (array[i].equals("<<username>>,")) {
						array[i] = username + ",";
					}
				}
				for (int i = 0; i < array.length; i++) {
					output += array[i] + " ";

				}
				System.out.println(output);
				return;
			}
		}
	}

}
