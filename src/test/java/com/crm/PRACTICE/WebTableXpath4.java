package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class WebTableXpath4 extends BaseClass
{
 @Test
 public void WebTableXpath()   {
	 HomePage hp=new HomePage(driver);
	 hp.clickoncontactLnk();
	List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]"));
	 for (WebElement Lastname : ele) {
		 String text = Lastname.getText();
		System.out.println(text);
	}
 }
}


