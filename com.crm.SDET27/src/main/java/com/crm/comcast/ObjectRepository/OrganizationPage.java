package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgLookUpImg;
	
	@FindBy(xpath = "//input[@class='searchBox']")
	private WebElement searchTextEdt;
	
	@FindBy(xpath = "//input[@class='searchBtn']")
	private  WebElement searchNowBtn;
	
	
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}


	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}


	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	
	
	public void clickonCreateOrg()
	{
		createOrgLookUpImg.click();
	}
}
