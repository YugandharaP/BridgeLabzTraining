package com.bridgelabz.singletonpatterns;

public class TestClass {

	public static void main(String[] args) {
		
		/*System.out.println(EagerInitializedSingleton.getInstance());
		System.out.println(EagerInitializedSingleton.getInstance());
		System.out.println(EagerInitializedSingleton.getInstance());
		 */		
		/*System.out.println(LazyInitializedSingleton.getInstance());
		System.out.println(LazyInitializedSingleton.getInstance());
		System.out.println(LazyInitializedSingleton.getInstance());*/
		
		/*
		System.out.println(StaticBlockSingleton.getInstance());
		System.out.println(StaticBlockSingleton.getInstance1());
		System.out.println(StaticBlockSingleton.getInstance());*/
		
		/*System.out.println(ThreadSafeSingleton.getInstance().hashCode());*/
		/*System.out.println(ThreadSafeSingletonUsingSynchronized.getInstance().hashCode());*/
		
		/*System.out.println(BillPughSingleton.getInstance());*/
		System.out.println(SerializedSingleton.getInstance());
	}

}
