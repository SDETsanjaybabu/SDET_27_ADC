package com.crm.VtigerContacts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepository.ContactsPage;
import com.crm.comcast.ObjectRepository.CreateContactInfoPage;
import com.crm.comcast.ObjectRepository.CreateContactPage;
import com.crm.comcast.ObjectRepository.CreateOrganizationPage;
import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.LoginPage;
import com.crm.comcast.ObjectRepository.OrganizationPage;
import com.crm.comcast.genericUtility.BaseClass;
import com.crm.comcast.genericUtility.ExcelUtitlity;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;

@Listeners(com.crm.comcast.genericUtility.ListnerImplementation.class)
public class vTigerCreateOrgWithcontactTest extends BaseClass{
	
	@Test
	public void vTigerOrgWithcontact() throws Throwable 
	{	
		
		int contactname = jLib.getRanDomNumber();
		int org = jLib.getRanDomNumber();
		
		String contactName = eLib.getDataFromExcel("Sheet1",0,0)+contactname;
		String orgName = eLib.getDataFromExcel("Sheet1",1, 0)+org;
		
		//click on Organisation link
		
		HomePage hp=new HomePage(driver);
		hp.clickOrganizationLnk();
		
		OrganizationPage o1=new OrganizationPage(driver);
		o1.clickonCreateOrg();
		
	    CreateOrganizationPage org1=new CreateOrganizationPage(driver);
		org1.createOrg(orgName);
		
		wLib.waitForElementToBeClickAble(driver,driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")));
		//click on contact link
        hp.clickonContactlnk();
		
        //click on create contact image
		ContactsPage ctt=new ContactsPage(driver);
		ctt.clickOnCreateContactImg();
	
		//enter lastname
		CreateContactPage ct=new CreateContactPage(driver);
		ct.createCnt(contactName, orgName, driver);
		
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
	hp.logout(driver);
}
}