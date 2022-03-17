package com.crm.PRACTICE;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest {

	@Test
	public void ReadDatafromCmdLine() {
		String BROWSER=System.getProperty("browser");
		String URL=System.getProperty("url");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		
		
		System.out.println("BROWSERNAME is "+BROWSER);
		System.out.println("URL is "+URL);
		System.out.println("USERNAME is "+USERNAME);
		System.out.println("PASSWORD is "+PASSWORD);
	}
}
