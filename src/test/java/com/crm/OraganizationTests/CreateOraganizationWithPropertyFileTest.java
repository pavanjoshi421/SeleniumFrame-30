package com.crm.OraganizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
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

public class CreateOraganizationWithPropertyFileTest extends BaseClass
{
	@Test
	public void CreateoraganizationWithPropertyFile() throws Throwable 
	{
	       
		String Oragname = elib.Readdataexcel("ProdutModule", 11, 1)+"_"+jlib.getRandomNumber();
		
			//Step 4: navigate to organizations link
	        HomePage hp=new HomePage(driver);
	    	hp.clickonOraganizationLnk();
			
			//Step 4: click on create Organization link I'm
	    	OraganizationsPage op=new OraganizationsPage(driver);
	    	op.clickOnCreateOrgImg();
			
			//Step 5:create organization with mandatory fields
	    	CreateOraganizationPage cop=new CreateOraganizationPage(driver);
	    	cop.createNewOrg(Oragname);
	    	
	    	//step 6 : /*Validate*/
	    	OraganizationInfoPage oip=new OraganizationInfoPage(driver);
	    	String actOrgName = oip.organizationinfo();
			Assert.assertTrue(actOrgName.contains(Oragname), "Verifide");
			Reporter.log("verification successful",true);
			
		}
}
