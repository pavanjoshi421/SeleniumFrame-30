package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderpractice1 {

	@Test(dataProvider = "getdata")
	public void Dataprovider6C2R(String Bike,int CC) {
		System.out.println(Bike+"--->");
	}
	@DataProvider
	public Object[][] getdata()  {
Object[][] obj=new Object[6][2];
		
		obj[0][0]="M80";
		obj[0][1]=80;
		
		obj[1][0]="kawasaki";
		obj[1][1]=200;
		
		obj[2][0]="Rx100";
		obj[2][1]=100;
		
		obj[3][0]="Hero";
		obj[3][1]=150;
		
		obj[4][0]="Royal Enfield Thunder";
		obj[4][1]=300;
		
		obj[5][0]="splender";
		obj[5][1]=120;
		
		return obj;
		
	}
}
