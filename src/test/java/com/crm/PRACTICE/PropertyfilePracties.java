package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyfilePracties {
   @Test
   public void Propertyfile() throws IOException  
   {
	   //step1  : read the file
	   FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	   //step2 : Create object of Properties
	   Properties pojb=new Properties();
	   pojb.load(fis);
	   //step3 : read the data
	   String username = pojb.getProperty("url");
	   //step4  : if we want we just do verification
	   System.out.println(username);
   }
}
   