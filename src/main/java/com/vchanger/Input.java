package com.vchanger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.HashMap;

public class Input {
    Sheet sheet;
    public Input(Sheet sheet){
        this.sheet=sheet;
    }
    public HashMap<String, double[]> getData() {
        HashMap<String, double[]> hashMap = new HashMap<>();
        for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
            String columnName = sheet.getRow(0).getCell(i).getStringCellValue();
            double[] data = new double[sheet.getLastRowNum()];
            for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                Row row = sheet.getRow(j);
                Cell cell = row.getCell(i);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    data[j - 1] = cell.getNumericCellValue();
                } else if (cell.getCellType() == CellType.FORMULA) {
                    data[j - 1] = cell.getNumericCellValue();
                }
            }
            hashMap.put(columnName, data);
        }
        return hashMap;
    }
}
