package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {
	//step  1  : Declaration
	@FindBy(xpath="//img[@alt='Create Vendor...']")
	private WebElement createVendorLookupImg;
	
	//step 2 : initialization 
	public VendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step 3 : Utilization
	public WebElement getVendorPageLookupImg()  {
		return createVendorLookupImg;
	}
	
	//Business Library
	public void clickOnCreateVendorImg()  {
		createVendorLookupImg.click();
	}
}
