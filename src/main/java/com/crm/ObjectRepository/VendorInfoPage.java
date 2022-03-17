package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {
	//step 1 :declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement headerText;
	
	//step 2 :initialization
	public VendorInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step 3 : utilization
	public WebElement getHeaderText()
	{
		return headerText;
	}
	
	//business libarary
	public String VendorInfo()
	{
		String header = headerText.getText();
		return header;
	}
}
