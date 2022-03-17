package com.crm.ProductTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.BaseClass;

public class EditingProductImageInformationforproduct extends BaseClass{
@Test
public void EditingProductImageInformationforProduct() throws Throwable  {
	
	
	     //Read data from Excel sheet
		String ProductName = elib.Readdataexcel("ProdutModule", 33, 1);
		String In = elib.Readdataexcel("ProdutModule", 33, 1);
	 	
		/*Navigate to product link and click on product link*/
		driver.findElement(By.linkText("Products")).click();
		
		/*Search product click on edit*/
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.name("search_text")).sendKeys(ProductName);
		WebElement ele1 = driver.findElement(By.name("search_field"));
		wlib.select(In, ele1);
		Thread.sleep(1000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='edit']")).click();
	 
	    //click on choose file
     WebElement upload = driver.findElement(By.id("my_file_element"));
     upload.sendKeys("C:\\Users\\Dell\\Pictures\\Screenshots\\Screenshot (14).png");
     Thread.sleep(7000);
     
   //click on save
 	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
 	}
}
