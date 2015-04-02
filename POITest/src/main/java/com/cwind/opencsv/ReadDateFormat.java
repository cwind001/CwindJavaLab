package com.cwind.opencsv;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import au.com.bytecode.opencsv.CSVReader;

public class ReadDateFormat {
	public static void main(String[] args) throws IOException {
		String csvPath = "timezone-dateformat-mapping.csv";
		
		InputStream csv = new FileInputStream(csvPath);
		
		InputStreamReader inputStreamReader = new InputStreamReader(csv, "UTF-8");
		
		CSVReader csvReader = new CSVReader(inputStreamReader);
		String[] row = null;
		while((row = csvReader.readNext()) != null) {
		    System.out.println(row[0] + " # " + row[1]);
		}
		csvReader.close();
	}
}
