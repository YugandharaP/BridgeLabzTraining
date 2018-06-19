package com.bridgelabz.controller;

import com.bridgelabz.serviceimplementation.CustomerImplementation;
import com.bridgelabz.serviceimplementation.StockImplementation;
import com.bridgelabz.serviceimplementation.TransactionImplementation;
import com.bridgelabz.utility.Utility;

public class StockManager {
	public static final String CUSTOMER_FILE = "/home/adminsitrator/Documents/Program/StockMarket/src/com/bridgelabz/files/Customer.json";
	public static final String STOCK_FILE = "/home/adminsitrator/Documents/Program/StockMarket/src/com/bridgelabz/files/Stock.json";
	public static final String TRANSACTION = "/home/adminsitrator/Documents/Program/StockMarket/src/com/bridgelabz/files/Transaction.json";

	static CustomerImplementation customerImplentation = new CustomerImplementation(CUSTOMER_FILE);
	static StockImplementation stockImplentation = new StockImplementation(STOCK_FILE);
	static TransactionImplementation transactionImplentation = new TransactionImplementation(TRANSACTION);

	public static void main(String[] args) {
		System.out.println("What do you want to do ?");
		showOptions();
	}

	public static void showOptions() {
		System.out.println("1. Add Stocks\t\t\t\t 2. Remove Stock");
		System.out.println("3. Buy Shares\t\t\t\t 4. Sell Shares");
		System.out.println("5. Update balance\t\t\t 6. Remove Customer");
		System.out.println("7. Show Customer Details\t\t 8. Show StockList");
		System.out.println("9. Show Recent Company Transaction Time  10.Show Recent Transaction Company");
		System.out.println("\t\t\t 11.Close");
		int option = Utility.reInteger();
		switch (option) {
		case 1:
			stockImplentation.add();
			showOptions();
			break;
		case 2:
			System.out.println("Enter stock/company name which you want to delete from the market");
			stockImplentation.displayStockList();
			System.out.println("Enter index");
			int index = Utility.reInteger();
			stockImplentation.remove(index);
			showOptions();
			break;
		case 3:
			transactionImplentation.buy();
			showOptions();
			break;
		case 4:
			transactionImplentation.sell();
			showOptions();
			break;
		case 5:
			System.out.println("Whom you want to add balance");
			customerImplentation.showCustomerList();
			System.out.println("Enter index");
			int index2=Utility.reInteger();
			customerImplentation.update(index2);
			showOptions();
			break;
		case 6:
			System.out.println("Enter Customer name which you want to delete from the market");
			customerImplentation.showCustomerList();
			System.out.println("Enter index: ");
			int index1=Utility.reInteger();
			customerImplentation.remove(index1);
			showOptions();
			break;
		case 7:
			customerImplentation.showCustomerList();
			showOptions();
			break;
		case 8:
			stockImplentation.displayStockList();
			showOptions();
			break;
		case 9:
			transactionImplentation.showRecentCompanyTransactionTime();
			showOptions();
			break;
		case 10:
			transactionImplentation.showRecentCompanyTransactions();
			showOptions();
			break;
		case 11:
			transactionImplentation.close();
		}
	}

}
