package com.crm.PRACTICE;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;

public class DynamicDateXpath
{
	@Test
	public void DynamicDatexpath()  
	{
		 Date dt = new Date();
		    Calendar c = Calendar.getInstance();
		    c.setTime(dt);
                //d MMMM yy     //"MMMM d"
		    SimpleDateFormat dateFormatter = new SimpleDateFormat(" MM ");
		    String today = dateFormatter.format(dt);
		    System.out.println(today);
		    String[] Date = today.split(" ");
		WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		
	}
}
