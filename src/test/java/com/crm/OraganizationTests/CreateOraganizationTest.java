package com.crm.OraganizationTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOraganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OraganizationInfoPage;
import com.crm.ObjectRepository.OraganizationsPage;
@Listeners(com.crm.GenericLibrary.Listenersimplementationclass.class)

public class CreateOraganizationTest extends BaseClass {
    @Test//(retryAnalyzer=com.crm.GenericLibrary.RetryListenersImplementation.class)
    public void CreateoraganizationTest() throws Throwable 
    {
    	
    	//read data from excel sheet
	     String Oragname = elib.Readdataexcel("Org", 1, 2)+"_"+jlib.getRandomNumber();
	   
   //Step 3: navigate to organizations link
    HomePage hp=new HomePage(driver);
    hp.clickonOraganizationLnk();
    
    OraganizationsPage org=new OraganizationsPage(driver);
    org.clickOnCreateOrgImg();
   Assert.fail();
    
   //Step 4:create organization with mandatory fields
        CreateOraganizationPage cop=new CreateOraganizationPage(driver);
        cop.createNewOrg(Oragname);
        
        /*Validate*/
        OraganizationInfoPage oip = new OraganizationInfoPage(driver);
		String actHeader = oip.organizationinfo();
		Assert.assertTrue(actHeader.contains(Oragname), "Verifide");
		Reporter.log("verification successful",true);
    }
}
