package com.crm.ProductTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyfileUtility;
import com.crm.GenericLibrary.WebdriverUtility;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditingPricingInformationforProduct extends BaseClass {
@Test
public void EditingPricingInformationforproduct() throws Throwable   {
	
	
	
	//Read data from Excel sheet
	String Productnameran = elib.Readdataexcel("ProdutModule", 27, 1)+"_"+jlib.getRandomNumber();
	String Unitprice = elib.Readdataexcel("ProdutModule", 27, 1);
	String In = elib.Readdataexcel("ProdutModule", 27, 1);
			
    	 
	
	/*Navigate to product link and click on product link*/
	HomePage hp=new HomePage(driver);
	hp.ClickonProductLnk();
	
	//driver.findElement(By.linkText("Products")).click();  //done
	
	//click on product create img
	ProductPage pp=new ProductPage(driver);
	pp.clickOnCreateProductImg();
	
	//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();//done
	
	    //create a  product
	driver.findElement(By.name("productname")).sendKeys(Productnameran);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.name("search_text")).sendKeys(Productnameran);
	WebElement ele1 = driver.findElement(By.name("search_field"));
	wlib.select(In, ele1);
	//Select sel=new Select(driver.findElement(By.name("search_field")));
	//sel.selectByValue(In);
	driver.findElement(By.name("submit")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[.='edit']")).click();
	
	//enter the price
	driver.findElement(By.name("unit_price")).clear();
	driver.findElement(By.name("unit_price")).sendKeys(Unitprice);
	
	//check the check boxes
	driver.findElement(By.name("tax1_check")).click();
	driver.findElement(By.name("tax2_check")).click();
	driver.findElement(By.name("tax3_check")).click();
	
	//click on More link and click cancel
	driver.findElement(By.xpath("//a[.='more currencies »']")).click();
	driver.findElement(By.xpath("//input[@class='crmbutton small edit']")).click();
	driver.findElement(By.xpath("//img[@style='cursor: pointer;']")).click();
	Thread.sleep(2000);
	
	//click on save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
   }
}
