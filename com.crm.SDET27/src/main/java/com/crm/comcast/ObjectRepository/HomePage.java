package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
@FindBy(linkText = "Organizations")
private  WebElement organizationLnk;

@FindBy(linkText = "Contacts")
private WebElement contactsLnk;

@FindBy(linkText = "Opportunities")
private WebElement oppertuniitesLnk;

@FindBy(linkText = "Products")
private WebElement products;

@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement adminstratorImg;

@FindBy(linkText = "Sign Out")
private WebElement signOutLnk;



public HomePage(WebDriver driver) 
{
PageFactory.initElements(driver,this);	
}



public WebElement getOrganizationLnk() {
	return organizationLnk;
}

public WebElement getContactsLnk() {
	return contactsLnk;
}

public WebElement getOppertuniitesLnk() {
	return oppertuniitesLnk;
}

public WebElement getProducts() {
	return products;
}

public WebElement getAdminstratorImg() {
	return adminstratorImg;
}

public WebElement getSignOutLnk() {
	return signOutLnk;
}


//business library
public void clickOrganizationLnk()
{
	organizationLnk.click();
}
public void clickonContactlnk()
{
	contactsLnk.click();
}

public void logout(WebDriver driver)
{
	mouseOverOnElement(driver, adminstratorImg);
	signOutLnk.click();
}
}
