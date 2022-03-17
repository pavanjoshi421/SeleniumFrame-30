package com.crm.PRACTICE;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class WebTableXpath2 extends BaseClass
{
	@Test
	public void WebTableXpath() throws Throwable  {
		HomePage hp=new HomePage(driver);
	     hp.clickoncontactLnk();
	     driver.findElement(By.xpath("(//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id'])[last()]")).click();
	     Thread.sleep(3000);
	}
}
