package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactsExportPage {
	

	@FindBy(name = "search_type")
	private WebElement expSearchBtn1;
	
	@FindBy(name = "export_data")
	private WebElement expSearchBtn2;

	@FindBy(name = "Export")
	private WebElement exportBtn;
	
	public CreateContactsExportPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getExpSearchBtn() {
		return expSearchBtn1;
	}
	
	public WebElement getExpSearchBtn2() {
		return expSearchBtn2;
	}
	

	public WebElement getExportBtn() {
		return exportBtn;
	}

	public void ClickonSearchBtn()
	{
		expSearchBtn1.click();
	}
	public void ClickOnSearchBtn2()
	{
		expSearchBtn2.click();
	}
	public void ClickOnExportBtn()
	{
		exportBtn.click();
	}
}