package com.crm.VtigerContacts;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepository.ContactsPage;
import com.crm.comcast.ObjectRepository.CreateContactPage;
import com.crm.comcast.ObjectRepository.CreateImportContactsPage;
import com.crm.comcast.ObjectRepository.CreateImportContactsResultPage;
import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.LoginPage;
import com.crm.comcast.genericUtility.BaseClass;
import com.crm.comcast.genericUtility.ExcelUtitlity;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;

@Listeners(com.crm.comcast.genericUtility.ListnerImplementation.class)
public class VtigerImportContactsTest extends BaseClass {
	
	@Test
	public void importContacts() throws Throwable
	{
		int randomNum = jLib.getRanDomNumber();
		String contactName = eLib.getDataFromExcel("Sheet1",0,0)+randomNum;
				
		
		wLib.mouseOverOnElement(driver,driver.findElement(By.xpath("//a[.='Contacts']")));
		
		HomePage hp=new HomePage(driver);
		hp.clickonContactlnk();
		
		ContactsPage ctt=new ContactsPage(driver);
		ctt.clickOnCreateContactImg();
		
		CreateImportContactsPage cg=new CreateImportContactsPage(driver);
		cg.createCnt(contactName, contactName, driver);
		
		CreateContactPage ct1=new CreateContactPage(driver);
		ct1.importImg();
		
		WebElement ele1 = driver.findElement(By.xpath("//input[@name='import_file']"));
        ele1.sendKeys("C:\\Users\\SanjayBabu\\Desktop\\t1.csv");
        
        CreateImportContactsPage ct2=new CreateImportContactsPage(driver);
        ct2.clickOnNextBtn();
        
        //wLib.switchToWindow(driver,"Contacts");
       
        WebElement el = driver.findElement(By.xpath("//span[@name='header_name']"));
        String text = el.getText();
        System.out.println(text);
        Assert.assertTrue(text.contains("taaj singh"));
        System.out.println("contact name is imported");
        
      /*  if(text.contains("taaj singh"))
        {
        	System.out.println("pass");
        }else {
        	System.out.println("fail");
        }*/
	}
}