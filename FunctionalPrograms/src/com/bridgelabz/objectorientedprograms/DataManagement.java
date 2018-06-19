package com.bridgelabz.objectorientedprograms;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**purpose-Create a JSON file having Inventory Details for Rice, Pulses and Wheats
with properties name, weight, price per kg.
 * @author yuga
 * @version 1.0
 * @since   01-06-2018
 */
public class DataManagement {
	static long totalRiceCost;
	static long totalPulsesCost;
	static long totalWheatsCost;
	public static void main(String[] args) throws IOException, ParseException {
		String path="/home/adminsitrator/Documents/JavaProgramming/FunctionalPrograms/src/com/bridgelabz/objectorientedprograms/inventoryDetails.json";
		JSONParser parser=new JSONParser();
		FileReader file=new FileReader(path);
		Object object=parser.parse(file);
		calculation(object,parser);
		
	}
	/**to convert object type to JSON and calculate the inventory value
	 * @param object
	 * @param parser
	 * @throws ParseException
	 */
	private static void calculation(Object object, JSONParser parser) throws ParseException {
		JSONObject jsonObject= (JSONObject) object;
		//converting object to Json
		JSONObject rice = (JSONObject) jsonObject.get("rice");
		JSONObject pulses = (JSONObject) jsonObject.get("pulses");
		JSONObject wheats = (JSONObject) jsonObject.get("wheats");
	
		
		totalRiceCost= (long)rice.get("price")*(long)rice.get("weight");
		totalPulsesCost=(long)  pulses.get("price")*(long)pulses.get("weight");
		totalWheatsCost=(long) wheats.get("price")*(long)wheats.get("weight");
		
		System.out.println("rice detils :" +rice +"\n"+"Total cost of rice : "+totalRiceCost);
		System.out.println("pulses details :"+pulses +"\n"+"Total cost of pulses : "+totalPulsesCost);
		System.out.println("wheat details :"+wheats+"\n"+"Total cost of pulses : "+totalWheatsCost);
	}

	
}
