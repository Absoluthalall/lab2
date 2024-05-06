package com.vchanger;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class Export {
    public static void createExcel(String filename, String sheetname, HashMap<String,Double> finalData) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetname);
        int rownum = 0;
        for (String key : finalData.keySet()) {
            XSSFRow row = sheet.createRow(rownum++);
            Double value = finalData.get(key);
            XSSFCell cell0 = row.createCell(0);
            XSSFCell cell1 = row.createCell(1);
            cell0.setCellValue(key);
            cell1.setCellValue(value);

        }
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream out = new FileOutputStream(filename);
        workbook.write(out);
        out.close();
    }
}
