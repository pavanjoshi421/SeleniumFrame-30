package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebdriverUtility;

public class HomePage extends WebdriverUtility
{
	//step 1: declration use @findBy annotation
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	
	@FindBy(name="Vendors")
	private WebElement VendorsLnk;
	
	@FindBy(linkText="More")
	private WebElement MoreLnk;
	
	@FindBy(linkText="Campaigns")
	private WebElement CampaignsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminisrtorImg;
	
	@FindBy(linkText ="Sign Out")
	private WebElement  SignOutLnk;
	
	//step 2 : Initializaton use constructor
	  public HomePage(WebDriver driver)  
	  {
			PageFactory.initElements(driver, this);
		}
	//step 3 : utilization - provide getters 

	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getMoreLnk() {
		return MoreLnk;
	}

	public WebElement getCampaignsLnk() {
		return CampaignsLnk;
	}

	public WebElement getAdminisrtorImg() {
		return adminisrtorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	@FindBy(name="Vendors")
	private WebElement VendorLnk;


	//Business Library
	public void clickoncontactLnk() {
		ContactsLnk.click();
	}
	public void clickonOraganizationLnk()  {
		OrganizationsLnk.click();
	}
	public void ClickonProductLnk() {
		ProductsLnk.click();
	}
	public void ClickonCampaignsLnk() {
		CampaignsLnk.click();
	}
	public void ClickOnMoreOptionLnk() {
		MoreLnk.click();
	}
	public void clickOnProductLnk()  {
		ProductsLnk.click();
	}
	public void clickOnVendor()  {
		VendorLnk.click();
	}
	public void logoutofApplication(WebDriver driver) 
	{
	MouseHover(driver, adminisrtorImg);
	SignOutLnk.click();	
}
}
