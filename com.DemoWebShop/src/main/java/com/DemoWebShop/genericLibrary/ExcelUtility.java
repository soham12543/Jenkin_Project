package com.DemoWebShop.genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	/*
	 * this method is used to fetch the data from excel file
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 */
	
	public String getDataFromExcelSheet(String path,String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream f = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(f);
		Sheet sheet = book.getSheet(sheetName);
		return sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
		
	}
	
	public Object[][] getMultipleData(String path,String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream f = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(f);
		Sheet sheet = book.getSheet(sheetName);
		int row = sheet.getPhysicalNumberOfRows();//10
		int cell = sheet.getRow(0).getPhysicalNumberOfCells();//2
		Object[][] obj = new Object[row-1][cell];
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<cell;j++)
			{
				obj[i-1][j]= sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}
	

}
