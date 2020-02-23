package com.freedom.exceltool;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteSheetTest {
    //文件路径
    private static final String path = "writeSheet.xlsx";

    public static void main(String[] args) throws IOException {
        FileInputStream fis  = new FileInputStream(path);

        //创建一个工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建一个电子表格
        XSSFSheet sheet = workbook.createSheet("mysheet");
        //行对象
        XSSFRow row;
        for (int r = 0; r < 3; r ++){
            //1.创建一个对象
            row = sheet.createRow(r);
            for (int c = 0; c < 4; c ++){
                //2.创建一个单元格
                Cell cell = row.createCell(c);
                cell.setCellValue("单元格的值" + r+c);
            }
        }
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        fis.close();
        fos.close();



    }
}
