package com.cwind.jxl;

import java.io.File;
import java.io.IOException;

import jxl.*;
import jxl.write.*;

public class JXLDataSheetWriter {
	private static final String[] titles = { "姓名", "Monday", "Tuesday",
			"Wednesday", "Thursday", "Friday" };

	// sample data to fill the sheet.
	private static final String[][] data = {
			{ "AngelaBaby", "跑了", "跑了", "跑了", "跑了", "跑了" },
			{ "邓超", "跑了", "跑了", "没跑", "跑了", "跑了" },
			{ "王祖蓝", "没跑", "没跑", "没跑", "跑了", "跑了" },
			{ "王宝强", "跑了", "跑了", "跑了", "跑了", "跑了" },
			{ "郑恺", "跑了", "跑了", "跑了", "跑了", "跑了" } };
	
	public static void main(String[] args) {
		try {
			// create writable wookbook
			WritableWorkbook workbook = Workbook.createWorkbook(new File("jxlOutput.xls"));
			
			// create writable sheet
			WritableSheet sheet = workbook.createSheet("First Sheet", 0);
			for(int i = 0; i < data.length; i++) {
				for(int j = 0; j < data[i].length; j++){
					
					// create a cell at position (i, j) and add to the sheet
					Label label = new Label(i, j, data[i][j]);
					sheet.addCell(label);
				}
			}
			workbook.write();
			workbook.close();
		} catch (IOException | WriteException e) {
			e.printStackTrace();
		}
	}
}
