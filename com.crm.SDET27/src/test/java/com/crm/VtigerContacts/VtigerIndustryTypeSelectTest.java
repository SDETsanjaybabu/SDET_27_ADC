package com.crm.VtigerContacts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepository.CreateOrganizationPage;
import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.LoginPage;
import com.crm.comcast.ObjectRepository.OrganizationInfoPage;
import com.crm.comcast.ObjectRepository.OrganizationPage;
import com.crm.comcast.genericUtility.BaseClass;
import com.crm.comcast.genericUtility.ExcelUtitlity;
import com.crm.comcast.genericUtility.FileUtility;
import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;

@Listeners(com.crm.comcast.genericUtility.ListnerImplementation.class)
public class VtigerIndustryTypeSelectTest extends BaseClass
{
	@Test
	public void vtigerInduType() throws Throwable
	{
		
		//get randomdata
		int randomNum = jLib.getRanDomNumber();
		
		//read testdata from excel file
		String orgName = eLib.getDataFromExcel("Sheet1",0,0)+randomNum;
		String industry = eLib.getDataFromExcel("Sheet1",2,2);
		String type = eLib.getDataFromExcel("Sheet1",2,3);
		
		HomePage hp=new HomePage(driver);
		hp.clickOrganizationLnk();
		
		OrganizationPage pg=new OrganizationPage(driver);
		pg.clickonCreateOrg();
		
		CreateOrganizationPage org=new CreateOrganizationPage(driver);
		org.createOrg(orgName);
		
		CreateOrganizationPage org1=new CreateOrganizationPage(driver);
		org1.clickIndsDrop(industry);
		
		CreateOrganizationPage org2=new CreateOrganizationPage(driver);
		org2.clickTypeDrop(type);
		
		OrganizationInfoPage org3=new OrganizationInfoPage(driver);
		String actualorgname = org3.getOrgInfo();
		Assert.assertTrue(actualorgname.contains(orgName));
		/*if(actualorgname.contains(orgName))
		{
			System.out.println("org name is created");
		}else {
			System.out.println("failed to create org name");
		}*/
	}
}
