package com.bridgelabz.serviceimplementation;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.controller.StockManager;
import com.bridgelabz.model.Stock;
import com.bridgelabz.service.StockService;
import com.bridgelabz.utility.Utility;

public class StockImplementation implements StockService {
	static List<Stock> stockList = new LinkedList<>();

	public StockImplementation(String stockFile) {
		stockList = Utility.convertJsonToList(stockFile, Stock.class);
	//System.out.println(stockList);
	}

	public StockImplementation() {
	}
	Stock stock = null;

	@Override
	public void add() {
		stock = new Stock();
		System.out.println("Enter Stock/Company Name");
		String companyName = Utility.retNext();
		stock.setCompanyName(companyName);
		System.out.println("Enter Number Of Shares you have");
		long numberOfShares = Utility.readLong();
		stock.setNumberOfShares(numberOfShares);
		System.out.println("Enter price of each share");
		long sharePrice = Utility.readLong();
		stock.setSharePrice(sharePrice);
		stockList.add(stock);
		Utility.convertJavaToJson(StockManager.STOCK_FILE, stockList);
		System.out.println("Stock details added successfully");
	}

	@Override
	public void remove(int index) {
		stockList.remove(index);
		System.out.println("Stock remove from market successfully");
		Utility.convertJavaToJson(StockManager.STOCK_FILE, stockList);
	}

	@Override
	public void displayStockList() {
		
		for(int i=0;i<stockList.size();i++)
		{
			System.out.println("index : "+i+" "+stockList.get(i));
		}
	}

}
