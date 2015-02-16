package com.cwind.opencsv;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import au.com.bytecode.opencsv.CSVReader;

public class ReadCSVDemo {
	public static void main(String[] args) throws IOException {
		String csvPath = "CSVTest.csv";
		
		InputStream csv = new FileInputStream(csvPath);
		//Read the byte order mark.
		for (int i = 0; i < 3; i++) {
			csv.read();
		}
		
		InputStreamReader inputStreamReader = new InputStreamReader(csv, "UTF-8");
		
		CSVReader csvReader = new CSVReader(inputStreamReader);
		String[] row = null;
		while((row = csvReader.readNext()) != null) {
		    System.out.println(row[0] + " # " + row[1] + " #  " + row[2] + " #  " + row[3]
		    		+ " #  " + row[4] + " #  " + row[5]);
		}
		csvReader.close();
	}
}
