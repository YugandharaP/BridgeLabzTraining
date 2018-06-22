package com.bridgelabz.structuraldesignpatterns.adapterdesignpattern;

public class SocketTestClass {

	public static void main(String[] args) {
		testClassAdapter();
		testObjectAdapter();
	}

	private static void testObjectAdapter() {
		SocketAdapter sockAdapter=new SocketObjectAdapterImpl();
		Volts v3=getVolt(sockAdapter,3);
		Volts v12=getVolt(sockAdapter,12);
		Volts v120=getVolt(sockAdapter,120);
		System.out.println("v3 volts using Object Adapter=" + v3.getVolt());
		System.out.println("v12 volts using Object Adapter=" + v12.getVolt());
		System.out.println("v120 volts using Object Adapter=" + v120.getVolt());
	}

	private static void testClassAdapter() {
		SocketAdapter sockAdapter = new SocketAdapterImpl();
		Volts v3 = getVolt(sockAdapter, 3);
		Volts v12 = getVolt(sockAdapter, 12);
		Volts v120 = getVolt(sockAdapter, 120);
		System.out.println("v3 volts using Class Adapter=" + v3.getVolt());
		System.out.println("v12 volts using Class Adapter=" + v12.getVolt());
		System.out.println("v120 volts using Class Adapter=" + v120.getVolt());
	}

	private static Volts getVolt(SocketAdapter sockAdapter, int i) {
		switch (i) {
		case 3:
			return sockAdapter.get3Volt();
		case 12:
			return sockAdapter.get12Volt();
		case 120:
			return sockAdapter.get120Volt();
		default:
			return sockAdapter.get120Volt();
		}
	}
}
