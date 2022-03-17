package com.crm.PRACTICE;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class WebTableXpath3 extends BaseClass {

	@Test
	public void WebTableXpath() throws Throwable  
	{
		HomePage hp=new HomePage(driver);
		hp.clickoncontactLnk();
		//check the 5th check box and delete
	 driver.findElement(By.xpath("(//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id'])[position()=5]")).click();
		driver.findElement(By.linkText("del")).click();
		Thread.sleep(3000);
	   Alert alt = driver.switchTo().alert();
	   alt.accept();
	   Thread.sleep(3000);
	}
}
