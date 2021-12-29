package practice;
import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepository.CreateOrganizationPage;
import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.OrganizationInfoPage;
import com.crm.comcast.ObjectRepository.OrganizationPage;
import com.crm.comcast.genericUtility.BaseClass;


public class createOrganizationTest extends BaseClass{
	
	@Test
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
		
		OrganizationInfoPage org1=new OrganizationInfoPage(driver);
		String actualorgname = org1.getOrgInfo();
		if(actualorgname.contains(orgName))
		{
			System.out.println("org name is created");
		}else {
			System.out.println("failed to create org name");
		}
	hp.logout(driver);
	}
}