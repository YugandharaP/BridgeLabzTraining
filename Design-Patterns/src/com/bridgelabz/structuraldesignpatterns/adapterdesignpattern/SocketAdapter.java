package com.bridgelabz.structuraldesignpatterns.adapterdesignpattern;

public interface SocketAdapter {
	public Volts get120Volt();

	public Volts get12Volt();

	public Volts get3Volt();
}
