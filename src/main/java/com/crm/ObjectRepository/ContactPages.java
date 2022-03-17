package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPages {
  
	//Declaration
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createcontactLookupImg;
	
	//Initializaation
	public ContactPages(WebDriver driver) {
	 PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getcreatecontactLookupImg()  {
		return createcontactLookupImg;
	}
	
	//Business library
	public void clickOnContactImg()  {
		createcontactLookupImg.click();
		
	}	
}
