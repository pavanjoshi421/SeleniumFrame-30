package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage { 

	 //step  1  : Declaration
		@FindBy(xpath="//img[@alt='Create Campaign...']")
		private WebElement createCampaignsLookupImg;
		
		//step 2 : initialization 
		public CampaignsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//step 3 : Utilization
		public WebElement getcreateOrgLookupImg()  {
			return createCampaignsLookupImg;
		}
		
		//Business Library
		public void clickOnCreateCampaignsImg()  {
			createCampaignsLookupImg.click();
		}
}
