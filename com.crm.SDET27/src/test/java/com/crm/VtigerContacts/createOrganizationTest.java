package com.crm.VtigerContacts;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepository.CreateOrganizationPage;
import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.OrganizationInfoPage;
import com.crm.comcast.ObjectRepository.OrganizationPage;
import com.crm.comcast.genericUtility.BaseClass;

@Listeners(com.crm.comcast.genericUtility.ListnerImplementation.class)
public class createOrganizationTest extends BaseClass{

	@Test(groups="smokeSuite")
	public void createOrgTest() throws Throwable 
	{	
		//get randomdata
		int randomNum = jLib.getRanDomNumber();
				
		//read testdata from excel file
		String orgName = eLib.getDataFromExcel("Sheet1",0,0)+randomNum;
				
				
		HomePage hp=new HomePage(driver);
		hp.clickOrganizationLnk();
		
		OrganizationPage pg=new OrganizationPage(driver);
		pg.clickonCreateOrg();
		
		CreateOrganizationPage org=new CreateOrganizationPage(driver);
		org.createOrg(orgName);
		//Assert.fail();
		
		OrganizationInfoPage org1=new OrganizationInfoPage(driver);
		String actualorgname = org1.getOrgInfo();
		
		Assert.assertTrue(actualorgname.contains(orgName));
		System.out.println("org created");
		/*if(actualorgname.contains(orgName))
		{
			System.out.println("org name is created");
		}else {
			System.out.println("failed to create org name");
		}*/
		hp.logout(driver);
}
}