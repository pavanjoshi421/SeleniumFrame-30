package com.crm.ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyfileUtility;
import com.crm.GenericLibrary.WebdriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPages;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOraganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OraganizationInfoPage;
import com.crm.ObjectRepository.OraganizationsPage;

public class ContactwithMultipleData extends BaseClass {
        
		
		@Test(dataProvider = "contactTest")
		public void createOrgWithMltipleData(String LastName) throws Throwable
		{
	          
			
	
			String Lastnameran= LastName+jlib.getRandomNumber();
			//navigate to contact
			HomePage hp = new HomePage(driver);
			hp.clickoncontactLnk();
			Reporter.log("navigated to org link",true);
	
			//create contact
			ContactPages cp = new ContactPages(driver);
			cp.clickOnContactImg();
			Reporter.log("click on create contact link",true);
	
			//create new contact
			CreateContactPage ccp = new CreateContactPage(driver);
			ccp.CreatenewContact(Lastnameran);
			Reporter.log("create org with insustry type",true);
			
			//validate
		ContactInfoPage cip = new ContactInfoPage(driver);
			String actHeader = cip.Contactinfopage();
			
			if (actHeader.contains(Lastnameran)) {
				System.out.println("passed");
			}
			else
			{
				System.out.println("failed");
			}
			Reporter.log("verification successful",true);		
		}
			
		@DataProvider(name = "contactTest")
		public Object[][] getData() throws Throwable
		{
			Object[][] data = elib.readmultipleDataFromExcel("ContactsLname");
			return data;
		}
	}
