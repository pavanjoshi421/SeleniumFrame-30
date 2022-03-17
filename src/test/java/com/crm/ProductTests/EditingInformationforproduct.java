package com.crm.ProductTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.crm.ObjectRepository.CreateVendorPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductPage;
import com.crm.ObjectRepository.VendorInfoPage;
import com.crm.ObjectRepository.VendorPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditingInformationforproduct extends  BaseClass{
	@Test
	public void EditingInformationforProduct() throws Throwable  {

		//read data from excel sheet
		String productnameran = elib.Readdataexcel("ProdutModule", 19, 1)+"_"+jlib.getRandomNumber();
		String ProductNameran = elib.Readdataexcel("ProdutModule", 19, 2)+"_"+jlib.getRandomNumber();
		String ProductNum= elib.Readdataexcel("ProdutModule", 19, 3);
		String SalesStartdate = elib.Readdataexcel("ProdutModule", 19, 4);
		String PartNum = elib.Readdataexcel("ProdutModule", 19, 5);
		String Manufacturer = elib.Readdataexcel("ProdutModule", 19, 6);
		String ProductCategory = elib.Readdataexcel("ProdutModule", 19, 7);
		String SalesEndDate = elib.Readdataexcel("ProdutModule", 19, 8);
		String SupportStartDate = elib.Readdataexcel("ProdutModule", 19, 9);
		String SupportEndDate = elib.Readdataexcel("ProdutModule", 19, 10);
		String VendorNum= elib.Readdataexcel("ProdutModule", 19, 11);
		String GLaccount = elib.Readdataexcel("ProdutModule", 19, 12);
		//vendor
		String Website = elib.Readdataexcel("ProdutModule", 21, 1);
		String ProductSheet = elib.Readdataexcel("ProdutModule", 21,2);
		String MfrPartNum = elib.Readdataexcel("ProdutModule", 21, 3);
		String SerialNum = elib.Readdataexcel("ProdutModule", 21, 4);
		String VendorName = elib.Readdataexcel("ProdutModule", 21, 5);

		/*Create a vendor as per CRS*/
		//mouse move over action on "More" option
		HomePage homepage=new HomePage(driver);
		homepage.ClickOnMoreOptionLnk();

		//click on vendor link
		homepage.clickOnVendor();

		//click on create vendor
		VendorPage vend=new VendorPage(driver);
		vend.clickOnCreateVendorImg();

		//fill mandatory fields 
		CreateVendorPage cvp=new CreateVendorPage(driver);
		cvp.CreateVendor(VendorName);

		//verification of vendor name
		VendorInfoPage vip=new VendorInfoPage(driver);
		String header = vip.VendorInfo();
		Assert.assertTrue(header.contains(VendorName), "Verified");

		/*Navigate to product link and click on product link*/
		homepage.ClickonProductLnk();

		//click on product create img
		ProductPage pp=new ProductPage(driver);
		pp.clickOnCreateProductImg();

		//create a  product and fill with manadatory fields 
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.EditingInformationforProduct(driver, productnameran, ProductNameran, SalesStartdate, SalesEndDate, ProductCategory,
				VendorName, ProductSheet, GLaccount, ProductCategory, ProductNum, PartNum, Manufacturer, SupportStartDate, 
				SupportEndDate, Website, MfrPartNum, SerialNum, MfrPartNum);

		//verify the edit sucessfully or not
		ProductInfoPage pip=new ProductInfoPage(driver);
		String header3 = pip.ProductInfo();
		Assert.assertTrue(header3.contains(ProductNameran), "Verified");
	}
}
