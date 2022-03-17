package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class WebTableXpath1 extends BaseClass 
{
	
@Test 
  public void WebTableXpath()
	{
	//navigate contact link and click cbox one by one
	 HomePage hp=new  HomePage(driver);
	 hp.clickoncontactLnk();
	 List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
	 for (WebElement cbox : ele) 
	 {
		 cbox.click();        
	 } 
	 for (int i=20; i>=1; i--) {
   driver.findElement(By.xpath("(//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id'])["+i+"]")).click();
   
	}
     }
}
	
