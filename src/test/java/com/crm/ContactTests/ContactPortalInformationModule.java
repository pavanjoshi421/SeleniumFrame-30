
package com.crm.ContactTests;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
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

public class ContactPortalInformationModule extends BaseClass {
@Test
public void ContactPortalInformationmodule () throws Throwable  
{
        //read data from excel sheet
  String enddate = elib.Readdataexcel("ProdutModule", 36, 2);
  String startdate = elib.Readdataexcel("ProdutModule", 36, 1);
  String CLnameran = elib.Readdataexcel("ProdutModule", 36, 3)+"_"+jlib.getRandomNumber();
  String In = elib.Readdataexcel("ProdutModule", 36, 4);
    
	/*Step 4: Navigate to Contacts Link*/
    HomePage hp=new HomePage(driver);
    hp.clickoncontactLnk();
    
	ContactPages cp=new ContactPages(driver);
	cp.clickOnContactImg();
	
	//create contact and edit information
	CreateContactPage ccp=new CreateContactPage(driver);
	ccp.EditContact(driver, CLnameran, startdate, enddate, In);
	
    }
}
