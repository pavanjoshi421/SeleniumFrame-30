package com.crm.PRACTICE;

import org.testng.annotations.Test;

public class DebugPractice
{

	@Test
	public void demo() {
		System.out.println("James Running Sucessfully");
		DebugPractice d=new DebugPractice();
		d.div(50, 10);
	}
	public int div(int a,int b)  {
		int c=a/b;
		return c;
		
	}
}
