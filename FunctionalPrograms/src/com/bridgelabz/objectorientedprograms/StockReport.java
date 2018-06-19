package com.bridgelabz.objectorientedprograms;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import com.bridgelabz.utility.Utility;

/**To generate stock report
 *@author yuga
 *@version 1.0
 *@since   02-06-2018
 */
public class StockReport {

	public static final String filepath="/home/adminsitrator/Documents/JavaProgramming/FunctionalPrograms/src/com/bridgelabz/objectorientedprograms/stockReport.json";
	static Stockportflio stock=new Stockportflio();
	static long totalOfEachStock;
	static long totalOfStock;
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		 Stock data = new Stock();
		System.out.println("Enter how many stocks you having: ");
		int stockNumber=Utility.reInteger();
		for(int i=0;i<stockNumber;i++)
		{
			data=checkDetails();
			stock.getStockList().add(data);
		}
		JsonUtil.convertJavaToJson(new File(filepath), stock);
		System.out.println("File write successfully");
		
		JSONParser parser= new JSONParser();
		Object object=parser.parse(new FileReader(filepath));
		JSONObject jsonObject=(JSONObject) object;
		JSONArray stockArray= (JSONArray) jsonObject.get("stockList");
		
		for(int i=0;i<stockArray.size();i++)
		{
			JSONObject object1=(JSONObject) stockArray.get(i);
			totalOfEachStock =(long) object1.get("shareNumber") * (long)object1.get("stockPrice");
			System.out.println("total value of "+object1.get("shareNumber")+" stock : "+totalOfEachStock);
			totalOfStock+=totalOfEachStock;
		}
		System.out.println("total value of all stocks : " +totalOfStock);
	}
	

	public static Stock checkDetails() {
		Stock data = new Stock();
		System.out.println("Enter stock name: ");
		String stockName=Utility.retNext();
		data.setStockName(stockName);
		System.out.println("Enter Number of share : ");
		long shareNumber=Utility.readLong();
		data.setShareNumber(shareNumber);
		System.out.println("Enter share price : ");
		long stockPrice = Utility.readLong();
		data.setStockPrice(stockPrice);
		return data;
	}

}
