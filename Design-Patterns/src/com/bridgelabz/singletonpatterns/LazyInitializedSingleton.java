package com.bridgelabz.singletonpatterns;

public class LazyInitializedSingleton {
	private static  LazyInitializedSingleton instance;
	private LazyInitializedSingleton() {
		int count=1;
		System.out.println((count++)+" object created");
	}
	public static LazyInitializedSingleton getInstance()
	{
		if(instance==null)
		{
			instance=new LazyInitializedSingleton();
		}
		return instance;
	}
}
