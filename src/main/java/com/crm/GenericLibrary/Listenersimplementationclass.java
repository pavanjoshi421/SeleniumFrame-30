package com.crm.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listenersimplementationclass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript Execution started");
		test=report.createTest(methodName);

	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"--->>> TestScript Sucessfull - PASS");
		test.log(Status.PASS,methodName+"----->>>Passed");
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript Execution Failed",true);

		//Step 1: Configure screenshot name
		String screenshotName = methodName+new JavaUtility().getSystemDateInFormate();
		System.out.println(screenshotName);

		String path = null;
		//Step 2: using screenshot method from webDriver Utility
		try {

			path=new WebdriverUtility().getScreenshot(BaseClass.sdriver, screenshotName);
			//EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
			//File src = eDriver.getScreenshotAs(OutputType.FILE);
			//String pa = Sysďtem.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
			//String path = "./Screenshots/"+screenshotName+".png";
			//File dst = new File(pa);
			//Files.copy(src, dst);

		} catch (Throwable e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL,methodName+"----------->>failed");
		//it will capture the exeception and log it in the report
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(path);	

	}

	public void onTestSkipped(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript Execution skipped");
		methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP,methodName+"----->>>skipped");
		//it will capture the exception and log it log it in the report
		test.log(Status.SKIP, result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}

	public void onTestFailedWithTimeout(ITestResult result)
	{


	}

	public void onStart(ITestContext context) 
	{
		//Excution start here
		/*Configure the report*/
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtententReports/Report"+new JavaUtility().getSystemDateInFormate()+".html");
		htmlreport.config().setDocumentTitle("SDET-30 Excution REports");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("selemiun Excution report");

		report=new ExtentReports();
		report.attachReporter(htmlreport); 
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("base-url", "http://localhost:8888");
		report.setSystemInfo("Report Name", "Pavan A J");
	}

	public void onFinish(ITestContext context)
	{
		//Consolidate all the parameters and generate the report
		report.flush();
	}
}