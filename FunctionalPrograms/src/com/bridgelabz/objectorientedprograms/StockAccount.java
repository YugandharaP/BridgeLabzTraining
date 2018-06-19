package com.bridgelabz.objectorientedprograms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class StockAccount implements BankDetails {
	static final String FILEPATH = "/home/adminsitrator/Documents/JavaProgramming/FunctionalPrograms/src/com/bridgelabz/objectorientedprograms/userDetails.json";
	static final String FILEPATH_SHARE = "/home/adminsitrator/Documents/JavaProgramming/FunctionalPrograms/src/com/bridgelabz/objectorientedprograms/companyStockReport.json";
	Random random = new Random();
	static long userAmount;
	static int shares;
	static long newVodafoneShare;
	static long newUserSharePrice;
	static String userName;
	static long phoneNumber;
	static long accountNumber;
	static String dateAndTime =Utility.todayDateAndTime();
	public static void main(String[] args)
			throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		String stock_Symbol = "";
		int amount = 0;
		StockAccount stock = new StockAccount();
		System.out.println("Register Here");
		stock.stockAccount(FILEPATH);
		System.out.println("\n\t\tWelcome to stock market: \n" + "we have following details of stocks");
		displayStockMarket();
		System.out.println("What do you want to do?");
		System.out.println("\t1.Buy shares\t\t 2.Sell Shares");
		int input = Utility.reInteger();
		switch (input) {
		case 1:
			System.out.println("Enter the amount for purches the share:");
			amount = Utility.reInteger();
			if (userAmount > amount) {
				if (amount > 1000) {
					System.out.println("Enter the stock_symbol :");
					stock_Symbol = Utility.retNext();
					userAmount = userAmount - amount;
					stock.buy(amount, stock_Symbol);
				} else {
					System.err.println(
							"Not Suffiecient balance(minimum balance required 1000rs). You are exit from our market");
					System.exit(0);
				}
			} else {
				System.err.println("You don't have suffiecient balance.You are exit from our market");
				System.exit(0);
			}
		case 2:
			stock.sell(amount, stock_Symbol);
			break;
		}
	}

	public static void displayStockMarket() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(FILEPATH_SHARE));
		JSONObject jsonObject = (JSONObject) object;
		System.out.println(jsonObject.get("VodaFone"));
		System.out.println(jsonObject.get("BSNL"));
		System.out.println(jsonObject.get("JIO"));
	}

	@Override
	public void stockAccount(String fileName) throws JsonGenerationException, JsonMappingException, IOException {
		CustomerDetails details = new CustomerDetails();
		CustomerInfo customer = new CustomerInfo();
		customer = userDetails();
		details.getCustomerArray().add(customer);
		JsonUtil.convertJavaToJson(new File(FILEPATH), details);
		System.out.println("Your data store successfully");
	}

	private CustomerInfo userDetails() {
		CustomerInfo customer = new CustomerInfo();
		System.out.println("Enter Username: ");
		userName = Utility.retNext();
		customer.setUserName(userName);
		System.out.println("Enter Contact Details: ");
		phoneNumber = Utility.readLong();
		customer.setPhoneNumber(phoneNumber);
		accountNumber = random.nextInt(10000);
		customer.setAccountNumber(accountNumber);
		System.out.println("How many shares you have:");
		long shareNumber = Utility.readLong();
		customer.setShareNumber(shareNumber);
		customer.setSharePrice(1000);
		System.out.println("enter Your initial amount:");
		userAmount = Utility.readLong();
		return customer;
	}

	@Override
	public double valueOf() {
		return 0;
	}

	@Override
	public void buy(int amount, String symbol) throws ParseException, FileNotFoundException, IOException {
		switch (symbol) {
		case "$"://System.out.println("$ enter");
			shares = calculateShares(symbol, amount);
			shares=readUserJSON(shares,symbol);
			System.out.println(shares+"shares of user");
			newUserSharePrice=shares*1000;
			System.out.println(newUserSharePrice+" price");
			save(FILEPATH);
			break;
		case "@":
			break;
		case "#":
			break;

		default:
			System.err.println(" Stock_Symbol not exist");
		}
	}

	private int readUserJSON(int shares, String symbol) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(FILEPATH));
		JSONObject jsonObject = (JSONObject) object;
		if (symbol.equals("$")) {
			JSONArray vodafone = (JSONArray) jsonObject.get("customerArray") ;
			for(int i=0;i<vodafone.size();i++)
			{
				JSONObject object1= (JSONObject) vodafone.get(i);
				shares+=(long)object1.get("shareNumber");
				System.out.println("newsharesOf user: "+shares);
				return shares;
			}

		}
		return shares;
	}

	private int calculateShares(String symbol, int amount) throws ParseException, FileNotFoundException, IOException {
		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(FILEPATH_SHARE));
		JSONObject jsonObject = (JSONObject) object;
		CustomerDetails details=new CustomerDetails();
		CustomerInfo custom=new CustomerInfo();
		System.out.println("done");
		if (symbol.equals("$")) {
			JSONObject vodafone = (JSONObject) jsonObject.get("VodaFone");
			long totalvodafoneCost = (long) vodafone.get("NoOfShares") * (long) vodafone.get("sharePrice");
			if (totalvodafoneCost >= amount) {
				shares = stockCalculation(amount, totalvodafoneCost);
				//System.out.println(shares);
			//	System.out.println("useramount old"+userAmount);
				userAmount += amount % 1000;
				System.out.println("useramount new"+userAmount);
				newVodafoneShare=(long) vodafone.get("NoOfShares")-shares;
				System.out.println("newVodafoneShare "+newVodafoneShare);
				return shares;
			}
		}

		/*} else if (symbol.equals("@")) {

		} else if (symbol.equals("#")) {

		}*/
		return shares;
	}

	private int stockCalculation(int amount, long totalvodafoneCost) {
		int shares = 0;
		shares = amount / 1000;
		return shares;
	}

	@Override
	public void sell(int amount, String symbol) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public void save(String fileName) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		CustomerDetails details=new CustomerDetails();
		CustomerInfo customer=new CustomerInfo();
		CompanyShares company=new CompanyShares();
		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(FILEPATH_SHARE));
		JSONObject jsonObject = (JSONObject) object;
		JSONObject vodafone = (JSONObject) jsonObject.get("VodaFone");
		
		
		customer.setUserName(userName);
		customer.setPhoneNumber(phoneNumber);
		customer.setAccountNumber(accountNumber);
		customer.setShareNumber(shares);
		customer.setSharePrice(newUserSharePrice);
		customer.setCompanyArray((ArrayList<CompanyShares>) vodafone.get("Stock_Symbol"));
		
		details.getCustomerArray().add(customer);
		
		JsonUtil.convertJavaToJson(new File(fileName), details);
		System.out.println("User file update successfully");
	}

	@Override
	public void printReport() {

	}
	

}
