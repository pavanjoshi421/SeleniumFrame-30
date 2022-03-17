package com.crm.GenericLibrary;
/**
 * This class it will give data from database
 * @author Dell
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.cj.jdbc.Driver;
/**
 * This method will use to register data 
 * @author Dell
 *
 */
public class DataBaseUtility {
  Connection con=null;
  
  public void connectToDB() throws Throwable {
	  Driver driverref=new Driver();
	  DriverManager.registerDriver(driverref);
	  DriverManager.getConnection(IpathConstants.DBPath, IpathConstants.Dbusername, IpathConstants.Dbpassword);
  }  
  /**
   * This method is use to 
   * @throws Throwable
   */
public void closeDB() throws Throwable  {
	con.close();
}
/**
 * 
 * @param query
 * @param columnIndex
 * @param expData
 * @return
 * @throws Throwable
 */
public String executeQueryAndGetdata(String query,int columnIndex,String expData) throws Throwable  {
	boolean flag=false;
	String data=null;
	ResultSet result = con.createStatement().executeQuery(query);
	while(result.next())
	{
		data=result.getString(columnIndex);
		if(data.equalsIgnoreCase(expData))  {
			flag=true;
			
		}
	}
	if(flag)  {
		System.out.println(data+" data verified");
		return expData;
	}else {
		System.out.println("data not verified");
		return "";
	}
}
 }
