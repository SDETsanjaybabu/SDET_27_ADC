package com.crm.comcast.genericUtility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author SanjayBabu
 *
 */
public class WebDriverUtility {
	/**
	 * wait for page to load before identifying any synchronized element in DOM[HTML-DOcument]
	 * @param driver
	 */
public void waitForPageToLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}
/**
 * wait for page to load before indentifying any assynchronized[java scripts actions]element in DOM [HTML-Document]
 * @param driver
 */
public void waitForPageToLoadForJSElement(WebDriver driver) 
{
	driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
}
/**
 * used to wait for element to be clickable in GUI & check for specfic element for every 500 miliseconds
 * @param driver
 * @param element
 */
public void waitForElementToBeClickAble(WebDriver driver,WebElement element) 
{
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * used  to switch to anywindow based on window title
 * @param driver
 * @param partialWindowTitle
 */
public void switchToWindow(WebDriver driver,String partialWindowTitle) 
{
	Set<String> set=driver.getWindowHandles();
	Iterator<String>it=set.iterator();
	
	while (it.hasNext()) 
	{
	String wID=it.next();	
	
	driver.switchTo().window(wID);
	String currentWindowTitle = driver.getTitle();
	if(currentWindowTitle.contains(partialWindowTitle)) {
		break;
	}
	}
}
/**
 * used to switch to Alert window and click on Ok button
 * @param driver
 */
public void switchToAlertWindowAndAccept(WebDriver driver) 
{
	driver.switchTo().alert().accept();
}



public void waitForElementwithCustomTimeout(WebDriver driver) {
FluentWait wait= new FluentWait(driver);
wait.pollingEvery(Duration.ofSeconds(10));
}
/**
 * used to switch to frame window based on index
 * @param driver
 */
public void switchtoAlertWindowAndCancel(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * used to switch to frame window based on index
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver,int index)
{
	
	driver.switchTo().frame(index);
}
/**
 * used to switch to frame window based on id or name attribute
 * @param driver
 * @param id_name_attribute
 */
public void switchToFrame(WebDriver driver,String id_name_attribute) 
{
driver.switchTo().frame(id_name_attribute);	
}
/**
 * used to select the value from the dropdown based on index
 * @param element
 * @param index
 */
public void select(WebElement element,int index)
{
	Select sel=new Select(element);
	sel.selectByIndex(index);
}
/**
 * used to select the value from the dropdown based on value/option available in GUI
 * @param element
 * @param text
 */
public void select(WebElement element,String text)
{
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
}
/**
 * used to place mouse cursor on specified element
 * @param driver
 * @param element
 */
public void mouseOverOnElement(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}

public void takeScreenShot(WebDriver driver,String screenShotName) throws Throwable
{
TakesScreenshot ts=(TakesScreenshot)driver;
File src = ts.getScreenshotAs(OutputType.FILE);
File dst=new File("./screenshot/"+screenShotName+".PNG");
	Files.copy(src, dst);
}
}
