package com.bridgelabz.objectorientedprograms;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class demo {
	static final String storageFilePath = "/home/adminsitrator/Documents/JavaProgramming/FunctionalPrograms/src/com/bridgelabz/objectorientedprograms/";
	
public static void main(String[] args) {
	List<String> results = new ArrayList<String>();


	File[] files = new File("storageFilePath").listFiles();
	//If this pathname does not denote a directory, then listFiles() returns null. 

	for (File file : files) {
	    if (file.isFile()) {
	        results.add(file.getName());
	    }
	}
}
}