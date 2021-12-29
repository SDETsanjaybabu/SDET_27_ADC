package com.crm.comcast.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.LoginPage;

public class BaseClass {
	
	public static WebDriver sdriver;
	public WebDriver driver;
	public DataBaseUtility dLib=new DataBaseUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtitlity eLib=new ExcelUtitlity();
	
	
	@BeforeSuite(groups="smokeSuite")
	public void dbConnection()
	{
		dLib.connectToDB();
		System.out.println("DB connection successful");
	}
	
	@BeforeClass(groups = "smokeSuite")
	public void launchBrowser() throws IOException
		{
		String BROWSER = fLib.getPropertyKeyValue("browser");	
		String URL = fLib.getPropertyKeyValue("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		driver=new ChromeDriver();	
		}else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
		driver=new FirefoxDriver();	
		}else {
			System.out.println("invalid browser");
		}
		sdriver=driver;
		wLib.waitForPageToLoad(driver);
		sdriver.get(URL);
		}
		
	@BeforeMethod(groups="smokeSuite")
	public void loginToApp() throws IOException
	{
		//read the data
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}
	
	@AfterMethod
	public void logoutOfApp()
	{
		HomePage hp = new HomePage(driver);
		hp.logout(driver);
		System.out.println("logout successful");
	}
	
	@AfterClass(groups="smokeSuite")
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("browser closed");
	}
	
	@AfterSuite(groups="smokeSuite")
	public void closeDbConnection()
	{
		dLib.closeOfDB();
		System.out.println("db connection closed");
	}
	}