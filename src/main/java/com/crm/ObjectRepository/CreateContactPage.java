package com.crm.ObjectRepository;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebdriverUtility;

public class CreateContactPage extends WebdriverUtility{

	//step1 :  Declareation
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgNaneLookUpImg;
	
	@FindBy(name="leadsource")
	private WebElement leadSouraceDropDown;
	
	@FindBy (xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="search_text")
	private WebElement SearchEdt;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchFieldDD;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(name="submit")
	private WebElement sumbitBtn;
	
	@FindBy(linkText="edit")
	private WebElement EditBtn;
	
	@FindBy(name="support_end_date")
	private WebElement SupportEdate;
	
	@FindBy(name="support_start_date")
	private WebElement SupportSdate;
	
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement ContactLnk;
	
	//initialization with constructor
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization with help og getters
	
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgNaneLookUpImg() {
		return orgNaneLookUpImg;
	}

	public WebElement getLeadSouraceDropDown() {
		return leadSouraceDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getSumbitBtn() {
		return sumbitBtn;
	}

	public WebElement getEditBtn() {
		return EditBtn;
	}

	public WebElement getSearchFieldDD() {
		return searchFieldDD;
	}

	public WebElement getSupportEdate() {
		return SupportEdate;
	}

	public WebElement getSupportSdate() {
		return SupportSdate;
	}

	public WebElement getContactLnk() {
		return ContactLnk;
	}
	
	//business library
	/**
	 * this method help for create contact
	 * @param lastName
	 */
	public void CreatenewContact(String lastName)  {
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	/**
	 * This method help for create contact with select leadsource dropdown
	 * @param lastName
	 * @param leadsource
	 */
	public void CreateNewContact(String lastName,String leadsource)  {
		lastNameEdt.sendKeys(lastName);
		select(leadsource, leadSouraceDropDown);
		saveBtn.click();
	}
	/**
	 * this method helps to take OrgName by window pop up
	 * @param driver
	 * @param orgName
	 * @param lastName
	 * @param leadsource
	 */
	
        public void CreateNewContact(WebDriver driver,String Oragnameran,String lastName) {
        	lastNameEdt.sendKeys(lastName);
        	orgNaneLookUpImg.click();
        	switchToWindow(driver, "Accounts");
        	SearchEdt.sendKeys(Oragnameran);
        	searchBtn.click();
        	driver.findElement(By.xpath("//a[.='"+Oragnameran+"']")).click(); //this for only dynamic(xpath) elements
              switchToWindow(driver, "Contacts");      	
        	saveBtn.click();
        }
        public void EditContact(WebDriver driver,String lastName,String Edate,String Sdate,String value) throws Throwable  {
        	lastNameEdt.sendKeys(lastName);
        	saveBtn.click();
        	ContactLnk.click();
        	SearchEdt.sendKeys(lastName);
        	//select(value, searchFieldDD);
        	sumbitBtn.click();
        	EditBtn.click();
        	SupportEdate.clear();
        	SupportEdate.sendKeys(Edate);
        	//Alert alt = driver.switchTo().alert();
        	//alt.accept();
        	Thread.sleep(2000);
        	SupportSdate.clear();
        	SupportSdate.sendKeys(Sdate);
        	saveBtn.click();
        }
}
