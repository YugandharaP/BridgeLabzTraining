package com.bridgelabz.objectorientedprograms;

import java.io.Serializable;

/**
 * this is a POJO(plain old java object )class Which provides getter and setter
 * methods for each private data members
 * @author yuga
 */
@SuppressWarnings("serial")
public class Stock implements Serializable {
	private String stockName;
	private long shareNumber;
	private long stockPrice;  

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public long getShareNumber() {
		return shareNumber;
	}

	public void setShareNumber(long shareNumber) {
		this.shareNumber = shareNumber;
	}

	public long getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(long stockPrice) {
		this.stockPrice = stockPrice;
	}

}
