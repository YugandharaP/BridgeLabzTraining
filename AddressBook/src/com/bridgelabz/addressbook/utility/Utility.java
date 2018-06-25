package com.bridgelabz.addressbook.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.impl.DefaultPrettyPrinter;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

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
	public static <T> ArrayList<String> convertJsonToList(String FILEPATH, Class<T> list) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JavaType type = mapper.getTypeFactory().constructParametricType(ArrayList.class, list);
			return mapper.readValue(new File(FILEPATH), type);
		} catch (IOException e) {
			System.err.println(" List is empty..! choose following options for add data");
		}
		return new ArrayList<>();
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
	 * @param object
	 * @param file
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> void convertJavaToJson(T object, String file)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		writer.writeValue(new File(file), object);
	}

	public static <T> ArrayList<T> convertJsonToList(String FILEPATH,ArrayList<T> list) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			list = mapper.readValue(new File(FILEPATH), new TypeReference<ArrayList<T>>() {});
		} catch (IOException e) {
			System.err.println("Error in loading Address Books");
		}
		return list;
	}

}
