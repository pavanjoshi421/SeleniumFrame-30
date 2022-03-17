package com.crm.ProductTests;

import java.io.FileInputStream;
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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyfileUtility;
import com.crm.GenericLibrary.WebdriverUtility;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;
public class CreatingStockInformationforProductTest extends BaseClass {
	@Test
	public void CreateStockInformationforProduct() throws Throwable  {

		//Read data from Excel Sheet
		String ProductNameran = elib.Readdataexcel("ProdutModule", 4, 5)+"_"+jlib.getRandomNumber();
		String QtyUnit = elib.Readdataexcel("ProdutModule", 4, 2);
		String ReorderLevel = elib.Readdataexcel("ProdutModule", 4, 3);
		String QtyinDemand = elib.Readdataexcel("ProdutModule", 4, 4);
		String QtyinStock= elib.Readdataexcel("ProdutModule", 4, 1);
		String HandlerGroupDD = elib.Readdataexcel("ProdutModule", 4, 6);
		String UsageUnitDropdown = elib.Readdataexcel("ProdutModule", 4, 7);

		/*Navigate to Product Link*/
		HomePage  hp=new HomePage(driver);
		hp.ClickonProductLnk();

		/* click on create product button*/
		ProductPage pp=new ProductPage(driver);
		pp.clickOnCreateProductImg();

		/*Enter the data mandatory fields and also CRS fields and */
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.CreateStockInformation(driver, ProductNameran, QtyinStock, QtyUnit, ReorderLevel, QtyinDemand, UsageUnitDropdown,HandlerGroupDD);

		/*verification of product is created or not*/
		ProductInfoPage pip=new ProductInfoPage(driver);
		String header = pip.ProductInfo();
		Assert.assertTrue(header.contains(ProductNameran), "Verified");
	}
}




