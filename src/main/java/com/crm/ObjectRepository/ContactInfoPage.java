package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	//declaration
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	
	//step 2 :initialization
		public  ContactInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//step 3 : utilization
		public WebElement getHeaderText()
		{
			return headerText;
		}
		
		//business libarary
		public String Contactinfopage()
		{
			String header = headerText.getText();
			return header;
		}
	
}
