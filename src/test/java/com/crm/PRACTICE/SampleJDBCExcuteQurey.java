package com.crm.PRACTICE;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExcuteQurey {
   
	@Test
	public void sampleJBDCExcuteQuery() throws SQLException
	{
		
		//step 1:-register to database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		//step--2:-get connector from database  - provide db name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root","root");
		//step 3:--issue create statement
		Statement state = con.createStatement();
		//step 4:-execute the query --- provide table name
		ResultSet result = state.executeQuery("select * from students;");
		while(result.next())  {
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
		//close database
		con.close();
	}
}

   