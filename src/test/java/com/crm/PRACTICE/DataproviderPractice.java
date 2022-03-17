package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderPractice {

	@Test(dataProvider = "getdata")
	public void DataproviderPractice4R3C(String name,String model,int qty)  {
		System.out.println(name+"----->"+model+"----->"+qty);	
	}
	
	@DataProvider
	public Object[][] getdata()  {
		Object[][] obj=new Object[4][3];
		
		obj[0][0]="Mi";
		obj[0][1]="13 pro";
		obj[0][2]=12;
		
		obj[1][0]="iphone";
		obj[1][1]="11 pro";
		obj[1][2]=21;
		
		obj[2][0]="samsung";
		obj[2][1]="A 50";
		obj[2][2]=500;
		
		obj[3][0]="micromax";
		obj[3][1]="15 pro";
		obj[3][2]=100;
		
		return obj;
		
	}
}
