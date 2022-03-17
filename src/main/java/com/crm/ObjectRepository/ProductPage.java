package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
       
	//step  1  : Declaration
			@FindBy(xpath="//img[@alt='Create Product...']")
			private WebElement createProductLookupImg;
			
			//step 2 : initialization 
			public ProductPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
			//step 3 : Utilization
			public WebElement getProductPageLookupImg()  {
				return createProductLookupImg;
			}
			
			//Business Library
			public void clickOnCreateProductImg()  {
				createProductLookupImg.click();
			}
	
}
