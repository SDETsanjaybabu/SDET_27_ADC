package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtility.WebDriverUtility;

public class CreateImportContactsPage extends WebDriverUtility {

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name = "next")
	private WebElement nextBtn;
	
	@FindBy(name = "import")
	private WebElement imrtBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	/*@FindBy(name = "header_name")
	private WebElement importedName;*/
	
	public CreateImportContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public WebElement getImrtBtn() {
		return imrtBtn;
	}
	
	/*public WebElement getImportedName() {
		return importedName;
	}*/


	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getNextBtn() {
		return nextBtn;
	}


	public void clickOnNextBtn() 
	{
		nextBtn.click();
	}
	
	/*public void importName(String)
	{
		importedName;
	}*/
	
	public void clickOnImportbtn()
	{
		imrtBtn.click();
	}
	
	public void createCnt(String contactName,String orgName,WebDriver driver)
	{
		lastNameEdt.sendKeys(contactName);
		saveBtn.click();
		switchToWindow(driver,"Contacts");
}
		
	}

