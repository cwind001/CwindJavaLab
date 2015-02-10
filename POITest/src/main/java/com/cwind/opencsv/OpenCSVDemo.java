package com.cwind.opencsv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import au.com.bytecode.opencsv.CSVWriter;

public class OpenCSVDemo {
	public static void main(String[] args){
		try {
			String xlsPath = "D://LunaWorkspace//POITest//RunningMan.xlsx";
			String csvPath = "D://LunaWorkspace//POITest//CSVTest.csv";
			
			OutputStream csv = new FileOutputStream(csvPath);
			//Write the byte order mark.
			csv.write(239);
			csv.write(187);
			csv.write(191);
			PrintWriter fwriter = new PrintWriter(new OutputStreamWriter(csv, "UTF-8"));
			CSVWriter csvWriter = new CSVWriter(fwriter);
			
	        File excel = new File(xlsPath);
	        FileInputStream fis = new FileInputStream(excel);
	        XSSFWorkbook book = new XSSFWorkbook(fis);
	        XSSFSheet sheet = book.getSheetAt(0);

	        Iterator<Row> itr = sheet.iterator();
	        List<String> cellList;
	        // Iterating over Excel file in Java
	        while (itr.hasNext()) {
	            Row row = itr.next();

	            cellList = new ArrayList<String>();
	            		
	            // Iterating over each column of Excel file
	            Iterator<Cell> cellIterator = row.cellIterator();
	            while (cellIterator.hasNext()) {

	                Cell cell = cellIterator.next();

	                switch (cell.getCellType()) {
	                case Cell.CELL_TYPE_STRING:
	                    System.out.print(cell.getStringCellValue() + "\t");
	                    break;
	                case Cell.CELL_TYPE_NUMERIC:
	                    System.out.print(cell.getNumericCellValue() + "\t");
	                    break;
	                case Cell.CELL_TYPE_BOOLEAN:
	                    System.out.print(cell.getBooleanCellValue() + "\t");
	                    break;
	                default:

	                }
	                cellList.add(cell.getStringCellValue());
	            }
	            
	            System.out.println("");
	            String[] array = new String[cellList.size()];
	            cellList.toArray(array);
	            csvWriter.writeNext(array);
	        }
	        
	        csvWriter.flush();
	        csvWriter.close();
	        
		}catch(Exception ex){
			ex.printStackTrace();
		}
	
	}
}
