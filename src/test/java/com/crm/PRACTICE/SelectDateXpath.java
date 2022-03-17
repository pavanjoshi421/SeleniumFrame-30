package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectDateXpath {

	@Test
	public void SelectDatexpath()  
	{
		String date="15";
		String monthAndYear="March 2022";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");

		
		Actions actions=new Actions(driver);
		actions.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		driver.findElement(By.xpath("//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']")).click();
	}
}
