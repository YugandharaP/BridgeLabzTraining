package com.bridgelabz.structuraldesignpatterns.adapterdesignpattern;

public class Socket {
	public Volts getVolt(){
		return new Volts(120);
	}
}
