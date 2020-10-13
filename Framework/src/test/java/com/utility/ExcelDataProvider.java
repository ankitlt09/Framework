package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider
{
	
	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		File src = new File("./TestData/Data.xlsx");
		
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("Unable to read Excel File " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public String getStringData(int sheetIndex, int row, int column)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	
	public String getStringData(String sheetName, int row, int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String sheetName, int row, int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	

}
