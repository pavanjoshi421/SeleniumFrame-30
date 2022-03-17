package com.crm.GenericLibrary;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all generic methods related to webdriverActions
 * @author Dell
 *
 */
public class WebdriverUtility 
{
	/**
	 * This method will maximize the window
	 * @param driver
	 */
public void maximizewindow(WebDriver driver)  {
	driver.manage().window().maximize();
}
/**
 * This method will wait for 20 second for the page to load
 * @param driver
 */
public void waitForpageload(WebDriver driver)  {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
/**
 * This method will wait for 10 sec for an element to be clickable
 * @param driver
 * @param element
 */
public void webelementtoclickable(WebDriver driver,WebElement element)  
{
	WebDriverWait wait= new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * This method will wait for 20 seconds for the the element to be visible
 * @param driver
 * @param element
 */
public void waitforelementToBeVisisble (WebDriver driver,WebElement element)  
{
  WebDriverWait wait =  new WebDriverWait(driver, 20);
  wait.until(ExpectedConditions.visibilityOfAllElements(element));
}
/**
 * This method will select data from dropdown using index
 * @param element
 * @param index
 */
public void select(WebElement element,int index)  {
	Select sel = new Select(element);
	sel.selectByIndex(index);
}
/**
 * This method will select data from dropdown using text
 * @param element
 * @param text
 */
public void select(WebElement element,String text)  {
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
}
/**
 * This method will select data from dropdown using value
 * @param value
 * @param element
 */
public void select(String value,WebElement element)  
{
	Select sel=new Select(element);
	sel.selectByValue(value);
}
/**
 * This method will perform mouse Hover action
 * @param driver
 * @param element
 */
public void MouseHover(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 * This method will perform Drag and Drop action
 * @param driver
 * @param src
 * @param target
 */
public void dragAndDrop(WebDriver driver,WebElement src,WebElement target) {
	Actions act=new Actions(driver);
	act.dragAndDrop(src, target).perform();
}
/**
 * This method will doubleclick on element
 * @param driver
 * @param element
 */
public void doubleclickAction(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
     act.doubleClick(element).perform();
}
/**
 * This method will doubleclick on webpage
 * @param driver
 */
public void doubleclickAction(WebDriver driver)  {
	Actions act=new Actions(driver);
    act.doubleClick().perform();
}
/**
 * This method will right click on webpage
 * @param driver
 */
public void rightclick(WebDriver driver)  {
	Actions act=new Actions(driver);
	act.contextClick().perform();
}
/**
 * This method will right click on webelement
 * @param driver
 * @param element
 */
public void rightclick(WebDriver driver,WebElement element)  {
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * This method will press enter key
 * @param driver
 */
public void enterkeyspress(WebDriver driver)  {
	Actions act=new Actions(driver);
    act.sendKeys(Keys.ENTER).perform();
}
/**
 * This method will press enter key
 * @throws Throwable
 */
public void enterkey() throws Throwable  {
	Robot rb=new Robot();
	rb.keyPress(KeyEvent.VK_ENTER);
}
/**
 * This method will  Release enter key
 * @throws Throwable
 */
public void EnterRelease() throws Throwable  {
	Robot rb=new Robot();
	rb.keyRelease(KeyEvent.VK_ENTER);
}
/**
 * This method will perform Switch frame based on ID
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver,int index)  {
	driver.switchTo().frame(index);
}
/**
 * This method will perform Switch frame based on nameId
 * @param driver
 * @param nameId
 */
public void switchToFrame(WebDriver driver,String nameId)  {
	driver.switchTo().frame(nameId);
}
/**
 * This method will perform Switch frame based on address of the element
 * @param driver
 * @param address
 */
public void switchToFrame(WebDriver driver,WebElement address) {
	driver.switchTo().frame(address);
}
/**
 * This method will accept alert pop up
 * @param driver
 */
public void acceptAlert(WebDriver driver)  {
	driver.switchTo().alert();
}
/**
 * This method will cancel alert pop up
 * @param driver
 */
public void CancelAlert(WebDriver driver)  {
	driver.switchTo().alert().dismiss();
}
/**
 * This method will Handle the Multiple windows
 * @param driver
 * @param PartialWinTitle
 */
public void switchToWindow(WebDriver driver,String PartialWinTitle) 
{
	//step  1: use getwindowHandles to capture all window ids
	Set<String> windows = driver.getWindowHandles();
	
	//step 2  :iterate the windows
	Iterator<String> it = windows.iterator();
	
	//Step 3  : check weather there is next window
	while(it.hasNext())  {
	
	//step 4 : check whether there window id 
	String winId = it.next();
	
	//step 5  : switch to current window and capture title
	String currentwinTitle = driver.switchTo().window(winId).getTitle();

   //step 6  :  check whether the current window is expected
  if(currentwinTitle.contains(PartialWinTitle)) 
  {
	  break;
  }
}	
}


/**
 * This method will scrollActions By jse
 * @param driver
 */
public void scrollActions (WebDriver driver) {
	JavascriptExecutor jse=(JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0,500)", "");
}
/**
 * This method scrollActions y axis
 * @param driver
 * @param element
 */
public void scrollAction(WebDriver driver,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	int y = element.getLocation().getY();
	js.executeScript("window.scrollBy(0 ,"+y+")", element);
	//js.executeScript("arguments[0].scrollIntoView()",element);
}
/**
 * This method take screenShot strone it in file
 * @param driver
 * @param screenshotName
 * @return 
 * @throws Throwable
 */
public String getScreenshot(WebDriver driver,String screenshotName) throws Throwable {
  TakesScreenshot ts=  (TakesScreenshot) driver;
  File src=ts.getScreenshotAs(OutputType.FILE);
  String path = ".\\Screenshot\\"+screenshotName+".png";
  File dst=new File(path);
  Files.copy(src, dst);
  
  return dst.getAbsolutePath();
}
}



























