package com.bridgelabz.model;

public class Stock {
	private String companyName;
	private long NumberOfShares;
	private long sharePrice;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getNumberOfShares() {
		return NumberOfShares;
	}

	public void setNumberOfShares(long numberOfShares) {
		NumberOfShares = numberOfShares;
	}

	public long getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(long sharePrice) {
		this.sharePrice = sharePrice;
	}

	@Override
	public String toString() {
		return "Stock [companyName=" + companyName + ", NumberOfShares=" + NumberOfShares + ", sharePrice=" + sharePrice
				+ "]";
	}
}
