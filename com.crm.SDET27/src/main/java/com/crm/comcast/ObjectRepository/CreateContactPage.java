package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgNameLookImg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//img[@alt='Import Contacts']")
	private WebElement imptImg;
	
	@FindBy(name = "search_text")
	private WebElement searchTextFiled;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//tr[@class='lvtColData']//a[1]")
	private WebElement orgNameLnk; 
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	
	public WebElement getOrgNameLookImg() {
		return orgNameLookImg;
	}

	public WebElement getImptImg() {
		return imptImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void clickonCreateOrgImg()
	{
		orgNameLookImg.click();
	}
	
	public void importImg()
	{
		imptImg.click();
	}
	
	public WebElement getSearchTextFiled() {
		return searchTextFiled;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getOrgNameLnk() {
		return orgNameLnk;
	}
	
	public void clickOnimptImg()
	{
		imptImg.click();
	}
	
	public void createOnlyCnt(String contactName,WebDriver driver)
	{
		lastNameEdt.sendKeys(contactName);
		saveBtn.click();
	}
	public void createCnt(String contactName,String orgName,WebDriver driver)
	{
		lastNameEdt.sendKeys(contactName);
		orgNameLookImg.click();
		switchToWindow(driver,"Accounts");
		searchTextFiled.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.linkText(orgName)).click();
		switchToWindow(driver,"Contacts");
		saveBtn.click();
	}

	}