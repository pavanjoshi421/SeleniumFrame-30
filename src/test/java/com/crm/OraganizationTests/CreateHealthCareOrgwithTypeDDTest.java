package com.crm.OraganizationTests;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOraganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OraganizationInfoPage;
import com.crm.ObjectRepository.OraganizationsPage;

//scenario-3
public class CreateHealthCareOrgwithTypeDDTest extends BaseClass {  
@Test
public void CreateHealthCareOrgtest() throws Throwable  {

	//Read data from excel sheet
	String Oragname = elib.Readdataexcel("Org", 4, 3)+"_"+jlib.getRandomNumber();
	 String industryDD = elib.Readdataexcel("Org", 4, 2);
	 String TypeDD = elib.Readdataexcel("Org", 4, 4);
		  
			/*Step 4: Navigate to Organizations Link*/
			HomePage hp=new HomePage(driver);
			hp.clickonOraganizationLnk();
			
			/*Step 5: Click on create organization button*/
			OraganizationsPage op=new OraganizationsPage(driver);
			op.clickOnCreateOrgImg();
			
			
			/*Step 6: Enter mandatory fields and select org as healthcare and then save*/
			CreateOraganizationPage cop=new CreateOraganizationPage(driver);
			cop.createNewOrg(Oragname);
			cop.getIndustryDropDown().sendKeys(industryDD);
			cop.getIndustryDropDown().sendKeys(TypeDD);
			cop.getSavebtn().click();
			
			/*Validate*/
			OraganizationInfoPage oip = new OraganizationInfoPage(driver);
			String actHeader = oip.organizationinfo();
			Assert.assertTrue(actHeader.contains(Oragname), "Verifide");
			Reporter.log("verification successful",true);
			
    }
}
