package com.freedom.exceltool;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadSheet {
    static XSSFRow row;
    //文件路径
    private static final String path = "writeSheet.xlsx";

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("mysheet");

        //获取一个行的迭代器
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            row = (XSSFRow) rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellTypeEnum()) {
                    case NUMERIC:
                        double val = cell.getNumericCellValue();
                        System.out.println(" numberic   val:" + val);
                        break;
                    case STRING:
                        String str = cell.getStringCellValue();
                        System.out.println("String value :" + str);
                }
                System.out.println();

            }
            fis.close();

        }
    }
}
