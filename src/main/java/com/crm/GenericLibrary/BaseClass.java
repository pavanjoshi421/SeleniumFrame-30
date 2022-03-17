package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class BaseClass {
    
	     //Create object of all utilities
	public DataBaseUtility dbLib=new DataBaseUtility();
	public ExcelFileUtility elib=new ExcelFileUtility();
	public JavaUtility jlib=new JavaUtility();
	public PropertyfileUtility plib=new  PropertyfileUtility();
	public WebdriverUtility wlib=new WebdriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups={"smoke suite","regression suite"})
	public void connectDataBase() throws Throwable  
	{
		//dbLib.connectToDB();
		Reporter.log("=========dataBase connection sucessful=====",true);
	}
	
	@BeforeClass(groups={"smoke suite","regression suite"})
	//@BeforeTest
	public void launchbrowser() throws Throwable 
	{
		//read the data from property File
		String browser = plib.Readdatafrompropertyfile("browser");
		String url = plib.Readdatafrompropertyfile("url");
	
	//Create Run Time Polymorphisum
	if(browser.equalsIgnoreCase("chrome"))  {
		driver =new ChromeDriver();
	}else if(browser.equalsIgnoreCase("firefox"))  {
		driver =new FirefoxDriver();
	}else{
		System.out.println("invalid browser");
	}
	sdriver=driver;
	wlib.maximizewindow(driver);
	wlib.waitForpageload(driver);
	driver.get(url);
	Reporter.log("Browser launch sucessful",true);
	}
	
	@BeforeMethod(groups={"smoke suite","regression suite"})
     public void login() throws Throwable
     {
		String username = plib.Readdatafrompropertyfile("username");
		String passowrd = plib.Readdatafrompropertyfile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(username, passowrd);
		Reporter.log("=====Login application sucessful=====",true);
		 }
	
	@AfterMethod(groups={"smoke suite","regression suite"})
	public void logout()
	{
		HomePage hp=new HomePage(driver);
		hp.logoutofApplication(driver);
		Reporter.log("log out application sucessful");
		
	}
	
	@AfterClass(groups={"smoke suite","regression suite"})
	//@AfterTest
	public void closebrowser()  {
		driver.quit();
		Reporter.log("browser close sucessful",true);
	}
	
	@AfterSuite(groups={"smoke suite","regression suite"})
	public void closeDB() throws Throwable
	{
		//dbLib.closeDB();
		Reporter.log("=======DB close sucessful=====",true);
		
	}
}