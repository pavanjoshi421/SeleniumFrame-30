package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class SampleJDBCExcuteUpdate {
   @Test
   public void SampleJDBCexcuteUpdate() throws SQLException 
   {
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	Statement state = con.createStatement();
	//execute the query 
	//insert into students values('5','racchuu','Female')
	int result = state.executeUpdate("insert into students values('5','racchuu','Female')");
	if(result==1)  {
		System.out.println("Created");
	}else{
		System.out.println("Not created");
	}
	con.close();
   }
}
