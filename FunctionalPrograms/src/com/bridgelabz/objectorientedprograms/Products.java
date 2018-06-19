package com.bridgelabz.objectorientedprograms;

import java.io.Serializable;

/**This is POJO(plain old java object)class which provides setter and getter methods for private data members
 * @author yuga
 */
@SuppressWarnings("serial")
public class Products implements Serializable{
	private String name;
	private long weight;
	private long  price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getWeight() {
		return weight;
	}
	public void setWeight(long weight) {
		this.weight = weight;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}

}
