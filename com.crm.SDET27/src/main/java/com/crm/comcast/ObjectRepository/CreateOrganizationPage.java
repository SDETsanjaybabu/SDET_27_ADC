package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtility.JavaUtility;
import com.crm.comcast.genericUtility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{

	@FindBy(name = "accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	public CreateOrganizationPage(WebDriver driver)
	{
	PageFactory.initElements(driver,this);	
	}


	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}


	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}


	public WebElement getTypeDropDown() {
		return typeDropDown;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
public void clickIndsDrop(String industry)
{
	industryDropDown.sendKeys(industry);
}
	
public void clickTypeDrop(String type)
{
	typeDropDown.sendKeys(type);
}

public void  createOrg(String orgName)
{
	organizationNameEdt.sendKeys(orgName);
	saveBtn.click();
}
}
