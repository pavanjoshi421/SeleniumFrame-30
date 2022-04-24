package com.crm.ProductTests;

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
	
	/*click on product create img*/
	ProductPage pp=new ProductPage(driver);
	pp.clickOnCreateProductImg();
		
	    /*EditingPricingInformationProduct*/
	      CreateProductPage cpp=new CreateProductPage(driver);
	      cpp.EditingPricingInformationProduct(Productnameran, In, Unitprice);
   }
}
