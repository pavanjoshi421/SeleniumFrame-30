package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCVerifydata {
   @Test
   public void SampleJDBCverifydata() throws SQLException {
	   String ExpData = "racchuu";
	   Driver driverref=new Driver();
	   DriverManager.registerDriver(driverref);
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	   Statement stat = con.createStatement();
	   try  {
	   ResultSet result = stat.executeQuery("select * from students;");
	   while(result.next()){
		   String ActData = result.getString(2);
		   if(ExpData.equalsIgnoreCase(ActData))
		   {
			   System.out.println(ActData + "Data is Verified");
			   break;
		   }
	   }
	   }
	   catch(Exception e)  {
	   }
	   finally {
		   con.close();
		   System.out.println("conn closed");
	   }
	   }
}