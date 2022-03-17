package com.crm.OraganizationTests;

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
import com.crm.ObjectRepository.CreateOraganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OraganizationInfoPage;
import com.crm.ObjectRepository.OraganizationsPage;

public class createNewOrgWithTypeDropDownMulData extends BaseClass{
	
		@Test(dataProvider = "OrgtestData")
		public void createNewOrgWithTypeDropDownMuldata(String orgname,String industryDropDown,String typedropdown) throws Throwable {
			
			
			String orgnameran = orgname+jlib.getRandomNumber();
			
			//navigate to organization
			HomePage hp = new HomePage(driver);
			hp.clickonOraganizationLnk();
			Reporter.log("navigated to org link",true);
			
			//click on create orf button
			OraganizationsPage op = new OraganizationsPage(driver);
			op.clickOnCreateOrgImg();
			Reporter.log("click on create org link",true);
			
			//create new org with indType and Type
			CreateOraganizationPage cop = new CreateOraganizationPage(driver);
			cop.createNewOrgWithTypeDropDown(orgnameran, industryDropDown, typedropdown);
			Reporter.log("create org with insustry type and typeDD",true);
			
			//validate 
			OraganizationInfoPage oip = new OraganizationInfoPage(driver);
			String actHeader = oip.organizationinfo();
			if (actHeader.contains(orgnameran)) {
				System.out.println("passed");
			}
			else
			{
				System.out.println("failed");
			}
			Reporter.log("verification successful",true);
			
		}
		
		@DataProvider(name = "OrgtestData")
		public Object[][] getData() throws Throwable
		{
			Object[][] data = elib.readmultipleDataFromExcel("OrgMultipleData");
			return data;
			}
}
