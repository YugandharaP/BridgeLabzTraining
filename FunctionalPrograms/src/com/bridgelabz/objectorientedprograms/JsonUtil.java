package com.bridgelabz.objectorientedprograms;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.impl.DefaultPrettyPrinter;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonUtil {

	private static ObjectMapper mapper;
	private static ObjectWriter writer;
	/**
	 * static block used to declare constructor for object mapper.beacause object
	 * mapper create once in whole program
	 */
	static {
		mapper = new ObjectMapper();
	}

	/**
	 * this function convert java object to json in string type using
	 * writeValueAsString method
	 */
	public static String convertJavaToJson(Object object)
			throws JsonGenerationException, JsonMappingException, IOException {
		String jsonResult = mapper.writeValueAsString(object);
		return jsonResult;
	}

	/**
	 * this function convert json to java in generic type using readValue method.
	 * @param String type jsonString
	 * @param .class file
	 */
	public static <T> T convertJsonToJava(String jsonString, Class<T> cls)
			throws JsonParseException, JsonMappingException, IOException {
		T result = null;
		// ObjectMapper mapper=new ObjectMapper();
		result = mapper.readValue(jsonString, cls); // readvalue to read json string
		return result;
	}

	public static void convertJavaToJson(File file, Object object) throws JsonGenerationException, JsonMappingException, IOException {
		//mapper.writeValue(file, object);
		ObjectWriter writer=mapper.writer(new DefaultPrettyPrinter());
		writer.writeValue(file, object);
		
		
	}
	
}
