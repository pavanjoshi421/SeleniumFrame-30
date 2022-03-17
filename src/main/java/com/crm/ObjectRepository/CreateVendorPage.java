package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorPage {
      
	     //declaration
		@FindBy(name="vendorname")
		private WebElement vendornameEdt;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
	    //initialization with constructor
		public CreateVendorPage(WebDriver driver) 
		{	
			PageFactory.initElements(driver, this);
		}

		//utilization 
		public WebElement getVendornameEdt() {
			return vendornameEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		 //Business Library
		public void CreateVendor(String Vendorname)  {
			vendornameEdt.sendKeys(Vendorname);
			saveBtn.click();
		}
		
	
	
}
