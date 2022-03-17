package com.crm.GenericLibrary;

import java.util.Date;
import java.util.Random;

import org.apache.poi.ss.formula.functions.Replace;

/**
 * This class consists of Generic Methods wrt to java
 * @author Dell
 *
 */
public class JavaUtility {
/**
 * This method will generate a random numbers and and return it to user 
 * @return
 */
  public int getRandomNumber()  {
	  Random ran =new Random();
	  int random = ran.nextInt(500);
	  return random;
  }
  /**
   * This Method will generate current date and return it to user
   * @return
   */

public String getSystemDate()  {
	Date d= new Date();
	String date = d.toString();
	return date;
}
/**
 * This method will generate the current date and return the date after formating
 * @return
 */
	public String getSystemDateInFormate()  {
		Date d=new  Date();
		String d1 = d.toString();
		String[] date = d1.split(" ");
		
		String mon=date[1];
		String day=date[2];
		String Time=date[3].replace(":", "-");
		String year=date[5];
		
		String dataformate = day+"-"+mon+"-"+year+"-"+Time;
		return dataformate;
		
	}
}
