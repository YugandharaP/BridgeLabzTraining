package com.bridgelabz.creationaldesignpatterns.factorydesignpattern;


public class TestFactory {

	public static void main(String[] args) {
		Computer pc=ComputerFactory.getComputer("pc", "2GB", "500GB", "2.5GHz");
		Computer server=ComputerFactory.getComputer("Server", "8GB", "1TB", "2.4GHz");
		System.out.println("PC: "+pc);
		System.out.println("Server: "+server);
	}

}
