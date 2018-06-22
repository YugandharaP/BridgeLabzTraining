package com.bridgelabz.singletonpatterns;

public class StaticBlockSingleton {
	private static StaticBlockSingleton instance;

	private StaticBlockSingleton() {
		int count=1;
		System.out.println((count++)+" object created");
	}
	static {
		try {
			instance = new StaticBlockSingleton();
		} catch (Exception e) {
			throw new RuntimeException("Further object not created");
		}
	}
	public static StaticBlockSingleton getInstance()
	{
		return instance;
	}
}
