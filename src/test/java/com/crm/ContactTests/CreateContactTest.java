package com.crm.ContactTests;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyfileUtility;
import com.crm.GenericLibrary.WebdriverUtility;
import com.crm.ObjectRepository.ContactPages;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateContactTest extends BaseClass{//scenario-2
@Test(groups={"smoke suite","regression suite"})
public void CreateContacttest() throws Throwable   {
     
	  //read data from excel sheet
	String contactName = elib.Readdataexcel("Contacts", 1, 2)+"_"+jlib.getRandomNumber();
		  		  
	/*Step 4: Navigate to Contacts Link*/
	HomePage hp=new HomePage(driver);
	hp.clickoncontactLnk();
	
	/*Step 5: Click on Create Contact button*/
   ContactPages cp=new ContactPages(driver);
   cp.clickOnContactImg();

	/*Step 6: Enter mandatory fields in create contact page and save*/
	CreateContactPage ccp=new CreateContactPage(driver);
	ccp.CreatenewContact(contactName);
	 }
}
