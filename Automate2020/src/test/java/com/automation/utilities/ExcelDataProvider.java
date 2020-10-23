package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//To read XLSX, XSSF implementation of POI library will be the choice.


public class ExcelDataProvider 
{
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		File src = new File("./TestData/Data.xlsx");
		
	try 
	   {
		FileInputStream fis = new FileInputStream(src);
		
		wb = new XSSFWorkbook(fis);
		}
	     catch (Exception e) 
	      {
	    	 System.out.println("Not able to read file" +e.getMessage());
		  }	
	}
	
	public String getStringData(int sheetIndex,int row,int column)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}

	public String getStringData(String SheetName,int row,int column)
	{
		return wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
	}
	public double getNumericData(String SheetName,int row,int column)
	{
		return wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
	}

}


