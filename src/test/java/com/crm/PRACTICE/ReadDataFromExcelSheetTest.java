package com.crm.PRACTICE;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelSheetTest {
	@Test
	public void ReadDatafromExcelSheetTest() throws Throwable  {
		//step1  : Load excel file
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		//step2  :  create workbook
		Workbook wb = WorkbookFactory.create(fis);
		//step3 : get sheet
		Sheet sh = wb.getSheet("Sheet1");
		//get row
		Row co = sh.getRow(0);
		//get the cell
		Cell ce = co.getCell(0);
		//read the data from cell
		String value=ce.getStringCellValue();
		System.out.println(value);
	}

}
