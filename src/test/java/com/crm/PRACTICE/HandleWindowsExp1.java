package com.crm.PRACTICE;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleWindowsExp1 {

	@Test
	public void window()  {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.get("https://www.google.com");
		driver.get("https://www.google.com");
		driver.get("https://www.google.com");
	}

}
