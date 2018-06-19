package com.bridgelabz.objectorientedprograms;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.parser.ParseException;

public interface BankDetails {

	public void stockAccount(String fileName) throws JsonGenerationException, JsonMappingException, IOException ;

	public double valueOf();

	public void buy(int amount, String symbol) throws ParseException, FileNotFoundException, IOException;

	public void sell(int amount, String symbol);

	public void save(String fileName) throws JsonGenerationException, JsonMappingException, IOException, ParseException ;

	public void printReport();
}
