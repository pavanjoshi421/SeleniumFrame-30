package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataIntoExcelSheet {
@Test
public void WriteDataIntoexcelSheet() throws Throwable  {
	//step 1: load the data excel file
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
	//create the workbook
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	Row ro = sh.getRow(7);
	//create a cell to write new data
	Cell ce = ro.createCell(0);
	//set the cell value
	ce.setCellValue("tyss1");
	//open file in  write mode
	FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Data.xlsx");
	wb.write(fos);
}
}
