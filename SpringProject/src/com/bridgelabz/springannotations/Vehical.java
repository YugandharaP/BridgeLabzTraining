package com.bridgelabz.springannotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "vehical")
public class Vehical {
	@Value("Bike")
	String name;
	@Value("30000")
	long price;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vehical [name=" + name + ", price=" + price + "]";
	}
}
