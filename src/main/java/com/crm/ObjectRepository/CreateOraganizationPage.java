package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebdriverUtility;

public class CreateOraganizationPage extends WebdriverUtility
{
  //Step 1 Declaration
	@FindBy(name="accountname")
	private WebElement OragNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typedropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	//step 2 : initialization
	public CreateOraganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//step3 : utilization
	public WebElement getIndustryDropDown()  {
		return industryDropDown;
	}
	public WebElement getOragNameEdt() {
		return OragNameEdt;
	}
	public WebElement getTypedropdown() {
		return typedropdown;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	//Business Library
	public void createNewOrg(String orgName)  {
		OragNameEdt.sendKeys(orgName);
		savebtn.click();
	}
	
	public void createNewOrg(String orgName,String industryDropDown)  {
		OragNameEdt.sendKeys(orgName);
		getIndustryDropDown().sendKeys(industryDropDown);
		savebtn.click();
	}
	public void createNewOrgWithTypeDropDown(String orgName,String industryDropDown,String typedropdown) 
	{
		OragNameEdt.sendKeys(orgName);
		getIndustryDropDown().sendKeys(industryDropDown);
	    getTypedropdown().sendKeys(typedropdown);
	    savebtn.click();
}
}