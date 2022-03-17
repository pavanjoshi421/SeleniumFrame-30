package com.crm.OpportunitiesTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyfileUtility;
import com.crm.GenericLibrary.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpportunitiesEndToEndScenario extends BaseClass {
	

	@Test
	public void OpportunitiesEndToEndscenario() throws Throwable  {
	
		int random = jlib.getRandomNumber();
		
		//read data from excel sheet
	     String CampaingsNameran = elib.Readdataexcel("OpprtunityModule", 1, 1)+"_"+random;
	     String ContactLNameran = elib.Readdataexcel("OpprtunityModule", 3, 1)+"_"+random;
	     String OpportunityNameran = elib.Readdataexcel("OpprtunityModule", 5, 1)+"_"+random;
	     String RelatedDD = elib.Readdataexcel("OpprtunityModule", 5, 2);
	     String LeadSource= elib.Readdataexcel("OpprtunityModule", 5, 3);
	     
		/* step4 : create campaigns*/
		driver.findElement(By.xpath("//a[@href='javascript:;']")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(CampaingsNameran);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*Step 5: verfify of campaing */
		String campaignHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(campaignHeader.contains(CampaingsNameran))
		{
			System.out.println(campaignHeader +" campaign is created");
		}
		else
		{
			System.out.println("campaign is not created");
		}
		
		/*Step 6 : Create the Contact*/
		
		/* Navigate to Contacts Link*/
		driver.findElement(By.linkText("Contacts")).click();
		
		/* Click on Create Contact button*/
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		/* Enter mandatory fields in create contact page and save*/
		driver.findElement(By.name("lastname")).sendKeys(ContactLNameran);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*Step 7 : verification of contact  */
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains(ContactLNameran))
		{
			System.out.println(contactHeader +" contact created");
		}
		else
		{
			System.out.println("contact not created");
		}
		
		/*Step 8 : Create opportunity */
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		driver.findElement(By.name("potentialname")).sendKeys(OpportunityNameran);
		
		//Handle drop down
		WebElement ele = driver.findElement(By.name("related_to_type"));
		wlib.select(RelatedDD, ele);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		wlib.switchToWindow(driver, "Contacts");
		driver.findElement(By.name("search_text")).sendKeys(ContactLNameran);
		driver.findElement(By.name("search")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText(ContactLNameran)).click();
		wlib.switchToWindow(driver, "Potentials");
		WebElement ele1 = driver.findElement(By.name("leadsource"));
		wlib.select(LeadSource, ele1);
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[2]")).click();
		wlib.switchToWindow(driver, "Campaigns");
		driver.findElement(By.name("search_text")).sendKeys(CampaingsNameran);
		driver.findElement(By.name("search")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='"+CampaingsNameran+"']")).click();
		wlib.switchToWindow(driver, "Potentials");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		/* Opportunity verification*/
		Thread.sleep(2000);
		String OpportunityHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OpportunityHeader.contains(OpportunityNameran))
		{
			System.out.println(OpportunityHeader +" Opportunity is created");
		}
		else
		{
			System.out.println("Opportunity not created");
		}
    }
}