package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsExportPage {
	
@FindBy(xpath = "//a[.='Contacts']")
private WebElement mouseOverOncontactsLink;
	
@FindBy(xpath = "//img[@title='Create Contact...']")
private WebElement createConElementLookUpImg; 
	
@FindBy(xpath = "//img[@alt='Export Contacts']")
private WebElement exportImg;

@FindBy(name = "lastname")
private WebElement lastNameEdt;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

@FindBy(name = "search_type")
private WebElement exportSearchRecordsRadioBtn;

@FindBy(name = "export_data")
private WebElement exportAllDataRadioBtn;

@FindBy(name = "Export")
private WebElement exportLinkBtn;

public ContactsExportPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public WebElement getExportImg() {
	return exportImg;
}

public void ClickonExportImg()
{
	exportImg.click();
}
public void createCnt(String contactName,WebDriver driver)
{
	
	createConElementLookUpImg.click();
	lastNameEdt.sendKeys(contactName);
	saveBtn.click();
	//switchToWindow(driver,"CDwindow");
	exportImg.click();
	exportSearchRecordsRadioBtn.click();
	exportAllDataRadioBtn.click();
	exportLinkBtn.click();
}
}
