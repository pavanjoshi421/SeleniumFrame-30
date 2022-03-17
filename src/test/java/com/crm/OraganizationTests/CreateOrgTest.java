package com.crm.OraganizationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
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

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.GenericLibrary.Listenersimplementationclass.class)
public class CreateOrgTest extends BaseClass
{

@Test
public void CreateOrgtest() throws Throwable  {  //Scenario - 1
	
	
	
	   //read data from excel sheet
	 String Oragname = elib.Readdataexcel("Org", 1, 2)+"_"+jlib.getRandomNumber();
	  
	/*Step 4: Navigate to Organizations Link*/
	HomePage hp=new HomePage(driver);
	hp.clickonOraganizationLnk();
	 String actdata = driver.findElement(By.linkText("Organizations")).getText();
	 String exceptedData = "Organizations";
	Assert.assertEquals(actdata, exceptedData);
	Reporter.log("Org link clicked",true);
	
	/*Step 5: click on create organization button*/
	OraganizationsPage op=new OraganizationsPage(driver);
	op.clickOnCreateOrgImg();
	
	/*Step 6: enter mandatory Fields and save*/
	CreateOraganizationPage cop=new CreateOraganizationPage(driver);
	cop.createNewOrg(Oragname);

	
	//step 7 : verification
	OraganizationInfoPage oip=new OraganizationInfoPage(driver);
	String actOrgName = oip.organizationinfo();
	Assert.assertTrue(actOrgName.contains(Oragname));
	Reporter.log(actOrgName+"matched",true);
   }
}