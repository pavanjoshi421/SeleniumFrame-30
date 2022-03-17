package com.crm.PRACTICE;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyfileUtility;

public class PractiesforGenericutils {
	@Test
public void practies() throws Throwable  {
	JavaUtility jlib=new JavaUtility();
	int ran = jlib.getRandomNumber();
	String dat = jlib.getSystemDate();
	String date = jlib.getSystemDateInFormate();
	System.out.println(ran+date);
	System.out.println(dat);
	
	
	
	PropertyfileUtility plib=new PropertyfileUtility();
	String brows = plib.Readdatafrompropertyfile("browser");  System.out.println(brows);
	
}
}
