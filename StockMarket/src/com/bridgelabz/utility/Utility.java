package com.bridgelabz.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.impl.DefaultPrettyPrinter;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

@SuppressWarnings("deprecation")
public class Utility {
	static Scanner scn = new Scanner(System.in);

	/**
	 * @return single String number
	 */
	public static String retNext() {
		return scn.next();
	}

	/**
	 * @return Multiple String number
	 */
	public static String retNextLine() {
		return scn.nextLine();
	}

	/**
	 * @return Integer number
	 */
	public static int reInteger() {
		return scn.nextInt();
	}

	/**
	 * @return double number
	 */
	public static double readDouble() {
		return scn.nextDouble();
	}

	/**
	 * @return boolean number
	 */
	public static boolean readBoolean() {
		return scn.nextBoolean();
	}

	/**
	 * @return long number
	 */
	public static long readLong() {
		return scn.nextLong();
	}

	/**
	 * @param FILEPATH
	 * @param list
	 * @return
	 */
	public static <T> LinkedList<T> convertJsonToList(String FILEPATH, Class<T> list) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JavaType type = mapper.getTypeFactory().constructParametricType(LinkedList.class, list);
			return mapper.readValue(new File(FILEPATH), type);
		} catch (IOException e) {
			System.err.println(" List is empty..! choose following options for add data");
			return new LinkedList<>();
		}
	}

	/**
	 * @param object
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static String convertJavaToJson(Object object)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(object);
		return jsonResult;
	}

	/**
	 * @param 
	 * @param customerList
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> void convertJavaToJson(String file , List<T> list) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		try {
			writer.writeValue(new File(file), list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param min
	 * @param max
	 * @return
	 */
	public static long getRandomDoubleBetweenRange(double min, double max) {

		long number = (long) ((Math.random() * ((max - min) + 1)) + min);

		return number;

	}

	public static String getTimeStamp() {
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return formater.format(date);
	}

	/**
	 * @param FILEPATH
	 * @return
	 */
	public static <T> ArrayList<T> convertJsonToList(String FILEPATH, ArrayList<T> list) {
		ObjectMapper mapper = new ObjectMapper();
		// ArrayList<String> bookList = new ArrayList<>();
		try {
			list = mapper.readValue(new File(FILEPATH), new TypeReference<ArrayList<T>>() {
			});
		} catch (IOException e) {
			System.err.println(" List is empty..! choose following options for add data");
		}
		return list;
	}

}
