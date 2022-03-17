package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectAnyMonthDate {

	@Test
	public void SelectAnyMonthdate() {
		String date="15";
		String monthAndYear="May 2022";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");

		
		Actions actions=new Actions(driver);
		actions.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		String nextpath = "//span[@aria-label='Next Month']";
		String datepath = "//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
	   
		for(;;) {
			try{
				driver.findElement(By.xpath(datepath)).click();
				break;
			}
			catch(Exception e)  {
				driver.findElement(By.xpath(nextpath)).click();
			}
			//driver.close();
		}
	}
}
