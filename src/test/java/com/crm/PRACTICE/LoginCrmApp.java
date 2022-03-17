package com.crm.PRACTICE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.LoginPage;

public class LoginCrmApp extends BaseClass
{
	@Test
  public void Login() 
	{
	  WebDriver driver=new ChromeDriver();
	  driver.get("http://localhost:8888/");
	  LoginPage lp=new LoginPage(driver);
	  lp.loginToApplication("admin", "admin");	  
  }
}
