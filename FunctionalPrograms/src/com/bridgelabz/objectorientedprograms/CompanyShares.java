package com.bridgelabz.objectorientedprograms;

public class CompanyShares {
	private String stock_Symbol;
	private long NoOfShares;
	private long sharePrice;
	private String dateAndTime;
	public String getStock_Symbol() {
		return stock_Symbol;
	}

	public void setStock_Symbol(String stock_Symbol) {
		this.stock_Symbol = stock_Symbol;
	}

	public long getNoOfShares() {
		return NoOfShares;
	}

	public void setNoOfShares(long noOfShares) {
		NoOfShares = noOfShares;
	}

	public long getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(long sharePrice) {
		this.sharePrice = sharePrice;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

}
