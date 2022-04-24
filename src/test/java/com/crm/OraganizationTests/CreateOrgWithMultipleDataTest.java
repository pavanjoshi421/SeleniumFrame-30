package com.crm.OraganizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

public class CreateOrgWithMultipleDataTest extends BaseClass {
          
	
	@Test(dataProvider = "OrgtestData")
	public void createOrgWithMltipleData(String orgName, String indType,String Type) throws Throwable
	{
            //navigate to organization
		HomePage hp = new HomePage(driver);
		hp.clickonOraganizationLnk();
		Reporter.log("navigated to org link",true);
		
		//create Org
		OraganizationsPage op = new OraganizationsPage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("click on create org link",true);
		
		//create new org
		CreateOraganizationPage cop = new CreateOraganizationPage(driver);
		cop.createNewOrg(orgName, indType);
		Reporter.log("create org with insustry type",true);
		
		//validate
		OraganizationInfoPage oip = new OraganizationInfoPage(driver);
		String actHeader = oip.organizationinfo();
		Assert.assertTrue(actHeader.contains(orgName), "Verifide");
		Reporter.log("verification successful",true);			
        	}
	
	@DataProvider(name = "OrgtestData")
	public Object[][] getData() throws Throwable
	{
		Object[][] data = elib.readmultipleDataFromExcel("OrgMultipleData");
		return data;
	}
}
