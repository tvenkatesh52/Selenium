package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	
	public static XSSFWorkbook wbName;
	public static XSSFSheet sheet;
	public static String xlFilePath;
	/*
	 public static void setExcelFile(String path,String sheetname) throws IOException {
			
	        FileInputStream fis=new FileInputStream(path);
			
			XSSFWorkbook wbook=new XSSFWorkbook(fis);
			sheet=wbook.getSheet(sheetname);
			fis.close();
		}
		*/

	/*
	public static String getData(int rowNo,String columnName) {
		XSSFRow row=sheet.getRow(0);
		XSSFCell cell=null;
		
		int columnNum=-1;
		try {
		for(int i=0;i<row.getLastCellNum();i++) {
			if(row.getCell(i).getStringCellValue().toString().trim().equals(columnName)) {
				columnNum=i;
			}
		}
		}catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("entered Column Name is not available in excel data file");
		}
		String value=sheet.getRow(rowNo).getCell(columnNum).getStringCellValue().toString().trim();
		return value;

	}
*/
	public static String getData(int rowNo,String columnName) throws IOException {
		String CellData;
		FileInputStream  fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Orange_Hrm.xlsx");
		XSSFWorkbook wbName = new XSSFWorkbook(fis);
		XSSFSheet sheetName = wbName.getSheet("Sheet1");
		
		XSSFRow row=sheet.getRow(0);
		XSSFCell cell=null;
		
		int columnNum=-1;
		try {
		for(int i=0;i<row.getLastCellNum();i++) {
			if(row.getCell(i).getStringCellValue().toString().trim().equals(columnName)) {
				columnNum=i;
			}
		}
		}catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("entered Column Name is not available in excel data file");
		}
		String value=sheet.getRow(rowNo).getCell(columnNum).getStringCellValue().toString().trim();
		return value;

	}



}
