package com.bridgelabz.serviceimplementation;

import java.util.LinkedList;
import java.util.List;

import com.bridgelabz.controller.StockManager;
import com.bridgelabz.lists.MyQueue;
import com.bridgelabz.lists.MyStack;
import com.bridgelabz.model.Customer;
import com.bridgelabz.model.Stock;
import com.bridgelabz.model.Transaction;
import com.bridgelabz.service.TransactionService;
import com.bridgelabz.utility.Utility;

public class TransactionImplementation implements TransactionService {
	static List<Transaction> transactionList = new LinkedList<>();
	static MyQueue<String> timeStampList = new MyQueue<>();
	static MyStack<String> companySymbol = new MyStack<>();
	 Customer customer = null;
	public TransactionImplementation(String transaction) {
		transactionList = Utility.convertJsonToList(transaction, Transaction.class);
	}
	 CustomerImplementation customerImpl = new CustomerImplementation();
	StockImplementation stockImpl = new StockImplementation();
	Stock stock = null;
	Transaction transaction = null;

	@Override
	public void buy() {
		//customer=new Customer();
		transaction = new Transaction();
		System.out.println("Enter your mobile Number : ");
		long mobileNumber = Utility.readLong();
		customer = validateCustomer(mobileNumber);
		System.out.println("Enter company Name from which you want to buy share :");
		//stockImpl.displayStockList();
		String companyName = Utility.retNext();
		System.out.println("How many share you want to buy ?");
		System.out.println("Enter number");
		long shares = Utility.readLong();
		boolean condition = checkShare(shares, companyName);
		if (condition == true) {
			transaction.setCompanyName(companyName);
			transaction.setNumberOfShares(shares);
			transaction.setCustomerName(customer.getCustomerName());
			String timeStamp = Utility.getTimeStamp();
			transaction.setTimeStamp(timeStamp);
			// adding timeStamp into queue
			timeStampList.enqueue(timeStamp);
			// adding company name in stack
			companySymbol.push(companyName);
			transactionList.add(transaction);
			Utility.convertJavaToJson(StockManager.TRANSACTION, transactionList);
			System.out.println("Do you want to buy more shares yes[0]/no[1]");
			condition();
		} else if (condition == false) {
			System.err.println("Entered company/stock name not exist in stock market");
			System.out.println("Re-Enter");
			buy();
		}
	}

	private boolean checkShare(long shares, String companyName) {
		for (int i = 0; i < stockImpl.stockList.size(); i++) {
			if (companyName.equalsIgnoreCase(stockImpl.stockList.get(i).getCompanyName())) {
				Stock tempStock = stockImpl.stockList.get(i);
				if (shares <= tempStock.getNumberOfShares()
						&& customer.getAmount() >= (tempStock.getSharePrice() * shares)) {
					//int newindex=serchIndex(customer,customerImpl.customerList);
					//customerImpl.customerList.remove(newindex);
					//System.out.println("deleted");
					long newShares = tempStock.getNumberOfShares() - shares;
					long newAmount = customer.getAmount() - (tempStock.getSharePrice() * shares);
					tempStock.setNumberOfShares(newShares);
					
					Utility.convertJavaToJson(StockManager.STOCK_FILE, stockImpl.stockList);
					
					customer.setAmount(newAmount);
					customer.setNumberOfShares(customer.getNumberOfShares() + shares);
					customerImpl.customerList.add(customer);
					Utility.convertJavaToJson(StockManager.CUSTOMER_FILE, customerImpl.customerList);
					System.out.println("Stocks added successfully");
				} else {
					System.err.println(" Not enough shares in " + companyName + " account");
					System.out.println("Do you want to buy share from another company ? yes[0]/no[1]");
					condition();
				}
				return true;
			}
		}
		return false;
	}

	public int serchIndex(Customer customer2, List<Customer> customerList) {
		for(int i=0;i<customerList.size();i++)
		{
			if(customer2==customerList.get(i))
				return i;
		}
		return -1;
	}

	private Customer validateCustomer(long mobileNumber) {
		if (CustomerImplementation.customerList == null) {
			customer = customerImpl.add(mobileNumber);
		} else {
			for (int i = 0; i < CustomerImplementation.customerList.size(); i++) {
				if (CustomerImplementation.customerList.get(i).getMobileNumber() == mobileNumber) {
					customer = CustomerImplementation.customerList.get(i);
					break;
				}
			}
		}
		if (customer == null) {
			customer = customerImpl.add(mobileNumber);
		}
		return customer;
	}

	@Override
	public void sell() {
		//customer=new Customer();
		transaction = new Transaction();
		System.out.println("Enter your mobile Number : ");
		long mobileNumber = Utility.readLong();
		customer = validateCustomer(mobileNumber);
		customer.getNumberOfShares();
		System.out.println(customer);
		if(customer.getNumberOfShares()!=0)
		{
			System.out.println("How many shares you want to sell ?");
			long shares=Utility.readLong();
			if(shares<=customer.getNumberOfShares()) {
			System.out.println("Enter index of company to whom you want to sell: ");
			stockImpl.displayStockList();
			int index=Utility.reInteger();
			
			int newindex=serchIndex(customer,customerImpl.customerList);
			customerImpl.customerList.remove(newindex);
			System.out.println("deleted");
			
			long newShares=customer.getNumberOfShares()-shares;
			customer.setNumberOfShares(newShares);
			customerImpl.customerList.add(customer);
			Utility.convertJavaToJson(StockManager.CUSTOMER_FILE,customerImpl.customerList);
			long newCompanyShares=stockImpl.stockList.get(index).getNumberOfShares()+shares;
			stockImpl.stockList.get(index).setNumberOfShares(newCompanyShares);
			stockImpl.stockList.add(stock);
			Utility.convertJavaToJson(StockManager.STOCK_FILE,stockImpl.stockList);
			String timeStamp=Utility.getTimeStamp();
			transaction.setCompanyName(stockImpl.stockList.get(index).getCompanyName());
			transaction.setCustomerName(customer.getCustomerName());
			transaction.setNumberOfShares(shares);
			transaction.setTimeStamp(timeStamp);
			transactionList.add(transaction);
			Utility.convertJavaToJson(StockManager.TRANSACTION, transactionList);
			System.out.println("Transaction done successfully");
			MyQueue.enqueue(timeStamp);
			MyStack.push(stockImpl.stockList.get(index).getCompanyName());
			}
			else {
				System.out.println("you don't have "+shares+" shares");
			}
		}
		else {
			System.out.println("You don't have shares.");
		}
	}


	@Override
	public void showRecentCompanyTransactions() {
		System.out.println("Company names are here!");
		MyStack.displayStack();
	}

	@Override
	public void showRecentCompanyTransactionTime() {
		System.out.println();
		MyQueue.display();

	}

	public void condition() {
		int option = Utility.reInteger();
		switch (option) {
		case 0:
			buy();
			break;
		case 1:
			StockManager.showOptions();
			break;
		}
	}

	public void close() {
		System.out.println("Are you sure you want to leave? yes[0]/no[1]");
		int option = Utility.reInteger();
		if (option == 0) {
			System.out.println("Thanks! Visit again");
			System.exit(0);
		}
		else if(option==1)
		{
			StockManager.showOptions();
		}
	}

}
