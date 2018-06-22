package com.bridgelabz.structuraldesignpatterns.adapterdesignpattern;

public class SocketObjectAdapterImpl implements SocketAdapter {
	private Socket sock = new Socket();

	@Override
	public Volts get120Volt() {
		return sock.getVolt();
	}

	@Override
	public Volts get12Volt() {
		Volts v = sock.getVolt();
		return convertVolt(v, 10);
	}

	@Override
	public Volts get3Volt() {
		Volts v = sock.getVolt();
		return convertVolt(v, 40);
	}

	private Volts convertVolt(Volts v, int i) {
		return new Volts(v.getVolt() / i);
	}
}
