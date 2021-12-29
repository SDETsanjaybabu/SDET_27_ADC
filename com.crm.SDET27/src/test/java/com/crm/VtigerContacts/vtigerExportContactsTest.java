package com.crm.VtigerContacts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepository.ContactsExportPage;
import com.crm.comcast.ObjectRepository.ContactsPage;
import com.crm.comcast.ObjectRepository.CreateContactPage;
import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.LoginPage;
import com.crm.comcast.genericUtility.BaseClass;
import com.crm.comcast.genericUtility.ExcelUtitlity;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;

@Listeners(com.crm.comcast.genericUtility.ListnerImplementation.class)
public class vtigerExportContactsTest extends BaseClass {
	
	@Test
	public void export() throws Throwable{
		
		
		int randomNum = jLib.getRanDomNumber();
		String contactName = eLib.getDataFromExcel("Sheet1",0,0)+randomNum;
							
		//read common data from properties File
		
		wLib.mouseOverOnElement(driver,driver.findElement(By.xpath("//a[.='Contacts']")));
		
		HomePage hp=new HomePage(driver);
		hp.clickonContactlnk();
		
		ContactsExportPage cnt=new ContactsExportPage(driver);
		cnt.createCnt(contactName, driver);

		
		wLib.switchToWindow(driver,"CDwindow");
	
	    wLib.switchToWindow(driver,"CDwindow");
		
	}
}
