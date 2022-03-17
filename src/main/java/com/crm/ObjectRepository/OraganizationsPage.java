package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebdriverUtility;

public class OraganizationsPage extends WebdriverUtility 
{
    //step  1  : Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLookupImg;
	
	//step 2 : initialization 
	public OraganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step 3 : Utilization
	public WebElement getcreateOrgLookupImg()  {
		return createOrgLookupImg;
	}
	
	//Business Library
	public void clickOnCreateOrgImg()  {
		createOrgLookupImg.click();
	}
}
