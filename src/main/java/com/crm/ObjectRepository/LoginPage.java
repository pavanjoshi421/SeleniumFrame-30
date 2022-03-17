package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.PropertyfileUtility;

public class LoginPage extends PropertyfileUtility {

	//step 1: declration use @findBy annotation
	@FindBy(name="user_name")
	private WebElement usernamEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement sumbitBtn;
	
	//step 2 : Initializaton use constructor
  public LoginPage(WebDriver driver)  
  {
		PageFactory.initElements(driver, this);
}
  
//step 3 : utilization - provide getters 

public WebElement getUsernamEdt() {
	return usernamEdt;
}

public WebElement getPasswordEdt() {
	return passwordEdt;
}

public WebElement getSumbitBtn() {
	return sumbitBtn;
}


//business library 
public void loginToApplication(String username, String Password)
{
	usernamEdt.sendKeys(username);
	passwordEdt.sendKeys(Password);
	sumbitBtn.click();
}
  
}  
  
  
  

