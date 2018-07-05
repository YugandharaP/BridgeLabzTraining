package com.bridgelabz.junit;

public class AssertClassMethods {

	public int add(int a, int b) {
		return a + b;
	}

	public boolean compareStrings(String first, String second) {
		if (first.equalsIgnoreCase(second))
			return true;
		else
			return false;
	}

	public String concatString(String first, String second) {

		return first.concat(second);
	}

	public int[] oneToArray(int[] number) {
		int length = number.length;
		int[] output = new int[length];
		for (int i = 0; i < length; i++) {
			output[i] = number[i] + 1;
		}
		return output;

	}

	public void toCheckPerformance() {
		for (int i = 0; i < 1000000; i++) {
			// System.out.println("execute");
		}
		System.out.println("Finish");
	}

	public void checkException(int number) {
		int result = 10 / number;
		System.out.println("throwing Arithmetic Exception");
	}

}
