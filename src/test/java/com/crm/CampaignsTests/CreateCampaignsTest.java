package com.crm.CampaignsTests;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
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
import com.crm.ObjectRepository.CampaignInfoPage;
import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.CreateCampaignsPage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductPage;

public class CreateCampaignsTest extends BaseClass 
{
@Test
  public void CreateCampaignstest() throws Throwable {
		 
		    //read data from excel sheet
		String campaingsNameran = elib.Readdataexcel("Campaings", 1, 2)+"_"+jlib.getRandomNumber();
		 String productnameran = elib.Readdataexcel("Campaings", 1, 3)+"_"+jlib.getRandomNumber();
		 String AssignedDD = elib.Readdataexcel("Campaings", 1, 4);
		 
			/*Step 4: Navigate to product link and click*/
            HomePage hp=new HomePage(driver);
            hp.ClickonProductLnk();
            
			/*step 5: Create product in product page*/
             ProductPage pg=new ProductPage(driver);
             pg.clickOnCreateProductImg();
              
			/*Step 6: enter mandatory fields in product Module and click on save*/
			CreateProductPage cp=new CreateProductPage(driver);
			cp.createProductName(productnameran, AssignedDD);
			
			
			/*Step 7:verify for productname */
			ProductInfoPage pip=new ProductInfoPage(driver);
			pip.getHeaderText();
			
			/* step8 : click on More*/
			hp.ClickOnMoreOptionLnk();
			
			//Click on Campaign Link
			hp.ClickonCampaignsLnk();
			//click on create campaigns img
			CampaignsPage csp=new CampaignsPage(driver);
			csp.clickOnCreateCampaignsImg();
			
			//create the campaigns 
    CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
    ccp.CreateCampaign(driver, productnameran, campaingsNameran,AssignedDD);
			
					
			/*Step 10: verfify for */
    CampaignInfoPage cip=new CampaignInfoPage(driver);
    cip.CampaignInfo();
    
  }
}
