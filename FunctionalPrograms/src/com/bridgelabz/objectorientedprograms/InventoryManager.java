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

/**
 *@author yuga
 *@version 1.0
 *@since   02-06-2018
 */
public class InventoryManager {

static final String PATH = "/home/adminsitrator/Documents/JavaProgramming/FunctionalPrograms/src/com/bridgelabz/objectorientedprograms/inventory.json";
static long totalRiceCost;
static long totalPulsesCost;
static long totalWheatsCost;

	/**
	 * @return
	 */
	public static Products makeRiceObject() {
		Products rice = new Products();
		System.out.println("Enter rice name: ");
		String name = Utility.retNext();
		rice.setName(name);
		System.out.println("Enter the price per kg: ");
		long price = Utility.readLong();
		rice.setPrice(price);
		System.out.println("Enter rice weight: ");
		long weight = Utility.readLong();
		rice.setWeight(weight);
		return rice;
	}

	/**
	 * @return
	 */
	public static Products makePulsesObject() {
		Products pulses = new Products();
		System.out.println("Enter the name of pulses");
		String name = Utility.retNext();
		pulses.setName(name);
		System.out.println("Enter the price per kg:");
		long price = Utility.readLong();
		pulses.setPrice(price);
		System.out.println("Enter the weight:");
		long weight = Utility.readLong();
		pulses.setWeight(weight);
		return pulses;
	}

	/**
	 * @return
	 */
	public static Products makeWheatObjects() {
		Products wheat = new Products();
		System.out.println("Enter the name of wheats");
		String name = Utility.retNext();
		wheat.setName(name);
		System.out.println("Enter the price per kg:");
		long price = Utility.readLong();
		wheat.setPrice(price);
		System.out.println("Enter the weight:");
		long weight = Utility.readLong();
		wheat.setWeight(weight);
		return wheat;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static  void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		InventoryPojoClass inventory = new InventoryPojoClass();
		System.out.println("Enter how many types of rice you are having");
		int riceTypes = Utility.reInteger();
		Products rice = new Products();
		for (int i = 0; i < riceTypes; i++) {
			rice = makeRiceObject();
			inventory.getListRice().add(rice);
		}
		System.out.println("Enter how many types of pulses you are having");
		int pulseTypes = Utility.reInteger();
		Products pulse = new Products();
		for (int i = 0; i < pulseTypes; i++) {
			pulse = makePulsesObject();
			inventory.getListPulse().add(pulse);
		}
		System.out.println("Enter how many types of Wheats you are having");
		int wheatTypes = Utility.reInteger();
		Products wheat = new Products();
		for (int i = 0; i < wheatTypes; i++) {
			wheat = makeWheatObjects();
			inventory.getListWheat().add(wheat);
		}
		JsonUtil.convertJavaToJson(new File(PATH),inventory);
		System.out.println("successfully write file");
		
		JSONParser parser=new JSONParser();
		Object object=parser.parse(new FileReader(PATH));
		JSONObject jsonObject= (JSONObject) object;
		
		JSONArray riceArray = (JSONArray) jsonObject.get("listRice") ;
		for(int i=0;i<riceArray.size();i++)
		{
			JSONObject object1= (JSONObject) riceArray.get(i);
			totalRiceCost +=(long) object1.get("price") * (long)object1.get("weight");
		}
		
		JSONArray pulsesArray = (JSONArray) jsonObject.get("listPulse") ;
		for(int i=0;i<pulsesArray.size();i++)
		{
			JSONObject object2= (JSONObject) pulsesArray.get(i);
			totalPulsesCost +=(long) object2.get("price") * (long)object2.get("weight");
		}
		
		JSONArray wheatArray = (JSONArray) jsonObject.get("listWheat") ;
		for(int i=0;i<wheatArray.size();i++)
		{
			JSONObject object3= (JSONObject) wheatArray.get(i);
			totalWheatsCost +=(long) object3.get("price") * (long)object3.get("weight");
		}
		System.out.println("Total cost of rice : "+totalRiceCost);
		System.out.println("Total cost of pulses : "+totalPulsesCost);
		System.out.println("Total cost of wheat : "+totalWheatsCost);
	}
}
