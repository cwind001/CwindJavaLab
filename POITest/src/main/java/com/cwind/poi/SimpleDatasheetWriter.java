
package com.cwind.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Billy Chen
 */
public class SimpleDatasheetWriter {

    private static final String[] titles = {
            "姓名", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    //sample data to fill the sheet.
    private static final String[][] data = {
            {"AngelaBaby", "跑了", "跑了", "跑了", "跑了", "跑了"},
            {"邓超", "跑了", "跑了", "没跑", "跑了", "跑了" },
            {"王祖蓝", "没跑", "没跑", "没跑", "跑了", "跑了" },
            {"王宝强", "跑了", "跑了", "跑了", "跑了", "跑了" },
            {"郑恺", "跑了", "跑了", "跑了", "跑了", "跑了" }
    };

    public static void main(String[] args) throws Exception {
        Workbook wb;

        if(args.length > 0 && args[0].equals("-xls")) wb = new HSSFWorkbook();
        else wb = new XSSFWorkbook();

        Sheet sheet = wb.createSheet("Running Man");

        Row headerRow = sheet.createRow(0);
        headerRow.setHeightInPoints(12.75f);
        for (int i = 0; i < titles.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(titles[i]);
        }

        Row row;
        Cell cell;
        int rownum = 1;
        for (int i = 0; i < data.length; i++, rownum++) {
            row = sheet.createRow(rownum);
            if(data[i] == null) continue;

            for (int j = 0; j < data[i].length; j++) {
                cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
            }
        }

        System.out.println("Default column width: " + sheet.getRow(0).getLastCellNum());
        System.out.println("Default column width: " + sheet.getRow(0).getPhysicalNumberOfCells());
        
        // Write the output to a file
        String file = "RunningMan.xls";
        if(wb instanceof XSSFWorkbook) file += "x";
        FileOutputStream out = new FileOutputStream(file);
        wb.write(out);
        out.close();
    }
}
