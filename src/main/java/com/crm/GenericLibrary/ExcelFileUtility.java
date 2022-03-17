package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic method to read and write data into excel sheet 
 * @author Dell
 *
 */
public class ExcelFileUtility
{
	/**
	 * This method use to Read the data from excel sheet
	 * @param sheetname
	 * @param rowno
	 * @param cellNo
	 * @param value
	 * @throws Throwable
	 */
public String Readdataexcel(String sheetname,int rowno,int cellNo) throws Throwable  
{
	/**
	 * This method use to  Read the data from excel sheet
	 */
	FileInputStream fis=new FileInputStream(IpathConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis);
    Cell cel = wb.getSheet(sheetname).getRow(rowno).getCell(cellNo);
    String value1 = cel.getStringCellValue();
	return value1;
    
}
public void writedataintoExcelsheet(String sheetname,int rowno,int cellNo,String value) throws Throwable, Throwable
{
	/**
	 * This method use to read the data from Excel sheet
	 */
	FileInputStream fis=new FileInputStream(IpathConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis);
    Cell cel = wb.getSheet(sheetname).getRow(rowno).getCell(cellNo);
    cel.setCellValue(value);
    FileOutputStream fos=new FileOutputStream(IpathConstants.Excelpath);
    wb.write(fos);
}
public int getRowcount(String SheetName) throws Throwable 
{
	/**
	 * This method use to count the total number of data present in sheet
	 */
	FileInputStream fis=new FileInputStream(IpathConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis);
     Sheet sh = wb.getSheet(SheetName);
     int row = sh.getLastRowNum();
     return row;
}
/**
 * This method will read multiple data from excel sheet with the help of sheetname
 * and return 2 dimensional object [][]
 * @param SheetName
 * @return
 * @throws Throwable
 */
public Object[][] readmultipleDataFromExcel(String SheetName) throws Throwable
{
	FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(SheetName);
	int lastRow = sh.getLastRowNum();
	int lastCell = sh.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[lastRow][lastCell];
	
	for(int i = 0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	
	return data;
   }
}