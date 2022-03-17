package com.crm.GenericLibrary;
/**
 * This class of generic methods  wrt to java
 * @author Dell
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyfileUtility {
	/**
	 * This method read data from property file key given by user
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String Readdatafrompropertyfile(String key) throws Throwable  {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

	
	
	
}
