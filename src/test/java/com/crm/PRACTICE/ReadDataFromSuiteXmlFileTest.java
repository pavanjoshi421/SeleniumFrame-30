package com.crm.PRACTICE;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromSuiteXmlFileTest {
@Test
public void eadDataFromSuiteXmlFile(XmlTest xml)  {
	String Browser=xml.getParameter("browser");
	String Url=xml.getParameter("url");
	
	System.out.println(Browser);
	System.out.println(Url);
}
}
