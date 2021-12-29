package com.crm.VtigerContacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepository.ContactsPage;
import com.crm.comcast.ObjectRepository.CreateContactInfoPage;
import com.crm.comcast.ObjectRepository.CreateContactPage;
import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.LoginPage;
import com.crm.comcast.genericUtility.BaseClass;
import com.crm.comcast.genericUtility.ExcelUtitlity;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;

@Listeners(com.crm.comcast.genericUtility.ListnerImplementation.class)
public class VtigerCreateContactsTest extends BaseClass{
	
	@Test(groups="smokeSuite")
	public void VtigerCreateContacts() throws Throwable
	{
		//get randomdata
		int randomNum = jLib.getRanDomNumber();
		
		//read testdata from excel file
		String contactName = eLib.getDataFromExcel("Sheet1",0,0)+randomNum;
	
		HomePage hp=new HomePage(driver);
		hp.clickonContactlnk();
		
		ContactsPage ctt=new ContactsPage(driver);
		ctt.clickOnCreateContactImg();
		
		CreateContactPage ct=new CreateContactPage(driver);
		ct.createOnlyCnt(contactName, driver);
		//ct.createCnt(contactName, contactName, driver);
		
		
		CreateContactInfoPage cnt=new CreateContactInfoPage(driver);
		String actualcntname = cnt.getContactInfo();
		Assert.assertTrue(actualcntname.contains(contactName));
		System.out.println("contact is created");
		/*if(actualcntname.contains(contactName))
		{
			System.out.println("name is created");
		}else {
			System.out.println("name is not created");
		}*/
	
	}
}