package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.GenericLibrary.WebdriverUtility;

public class CreateCampaignsPage extends WebdriverUtility {

	//Step 1 Declaration
		@FindBy(name="campaignname")
		private WebElement CampaignNameEdt;
		
		@FindBy(name="assigntype")
		private WebElement assignedTypeRadioBtn;
		
		@FindBy(name="assigned_group_id")
		private WebElement assignedToDropDown;
		
		@FindBy(xpath="//img[@alt='Select']")
		private WebElement AddProductBtn;
		
		@FindBy(name="campaigntype")
		private WebElement CampaigntypeDropDown;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement savebtn;
		
		@FindBy(name="search_text")
		private WebElement SearchEdt;
		
		@FindBy(name="search")
		private WebElement searchBtn;
		
		//step 2 : initialization
		public CreateCampaignsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//step3 : utilization
		public WebElement getCampaignNameEdt() {
			return CampaignNameEdt;
		}

				public WebElement getAssignedTypeRadioBtn() {
			return assignedTypeRadioBtn;
		}

		public WebElement getAssignedToDropDown() {
			return assignedToDropDown;
		}

		public WebElement getSearchEdt() {
			return SearchEdt;
		}

		public WebElement getSearchBtn() {
			return searchBtn;
		}

		public WebElement getAddProductBtn() {
			return AddProductBtn;
		}

		public WebElement getCampaigntypeDropDown() {
			return CampaigntypeDropDown;
		}

		public WebElement getSavebtn() {
			return savebtn;
		}
		//Business library
		public void CreateCampaign(WebDriver driver,String ProductName,String CampaignName,String AsignedToDropDown)  {
			CampaignNameEdt.sendKeys(CampaignName);
			//select(AsignedToDropDown, assignedToDropDown);
			AddProductBtn.click();
			switchToWindow(driver, "Products");
			SearchEdt.sendKeys(ProductName);
        	searchBtn.click();
        	driver.findElement(By.xpath("//a[.='"+ProductName+"']")).click(); //this for only dynamic(xpath) elements
             switchToWindow(driver, "Campaigns");
			savebtn.click();
			
		}

		






}









