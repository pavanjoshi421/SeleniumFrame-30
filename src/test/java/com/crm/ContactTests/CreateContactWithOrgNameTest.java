package com.crm.ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyfileUtility;
import com.crm.GenericLibrary.WebdriverUtility;
import com.crm.ObjectRepository.ContactPages;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOraganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OraganizationsPage;

public class CreateContactWithOrgNameTest extends BaseClass { //Integration scenario
@Test
public void CreateContactWithOrgNametest() throws Throwable  {

  
	//read data from Excel sheet
		String ClassLnameran = elib.Readdataexcel("Contacts", 4, 2)+"_"+jlib.getRandomNumber();
		String Oragnameran = elib.Readdataexcel("Contacts", 4, 3)+"_"+jlib.getRandomNumber();
		
	/*Step 4: Navigate to Contacts Link*/
	//click on org link
	HomePage hp=new HomePage(driver);
	hp.clickonOraganizationLnk();
	//
	OraganizationsPage crtorg=new OraganizationsPage(driver);
	crtorg.clickOnCreateOrgImg();
	CreateOraganizationPage cop=new CreateOraganizationPage(driver);
	cop.createNewOrg(Oragnameran);
	Thread.sleep(2000);
	hp.clickoncontactLnk();
	
	/*Step 5: Click on Create Contact button*/
	ContactPages cp=new ContactPages(driver);
	cp.clickOnContactImg();
		
	/*Step 6: Enter mandatory fields with OrgName in create contact page and save*/
	CreateContactPage ccp=new CreateContactPage(driver);
	ccp.CreateNewContact(driver, Oragnameran, ClassLnameran);
	
	}
}
