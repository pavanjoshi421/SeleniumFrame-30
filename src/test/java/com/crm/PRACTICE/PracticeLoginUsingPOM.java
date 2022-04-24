package com.crm.PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class PracticeLoginUsingPOM {
@Test
public void PracticeLoginUsing() throws Throwable  {
	//WebDriverManager.chromedriver().setup();
	
	
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888");
	
	LoginPage lp = new LoginPage(driver);
	lp.loginToApplication("admin", "admin");
	
	
	HomePage hp=new HomePage(driver);
	hp.clickonOraganizationLnk();
	hp.getSignOutLnk();
	hp.acceptAlert(driver);
	System.out.println("bye tata");
}
	
}
