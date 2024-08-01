package org.prashant.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExcelUtils {


    public ExcelUtils() {
        //For xlsx file type we have XSSF and HSSF for 97-2007

    }

    private static List<Map<String, String>> readData(String filename) {

        try (FileInputStream fis = new FileInputStream(new File(filename))) {

            //XSSFWorkbook workbook

            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.iterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    cell.getCellType();
                    //case Cell.CELL_TYPE_NUMERIC:
                    System.out.println(cell.getNumericCellValue());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to read from Excel file");
        }
        return new ArrayList<Map<String, String>>();
    }
}
