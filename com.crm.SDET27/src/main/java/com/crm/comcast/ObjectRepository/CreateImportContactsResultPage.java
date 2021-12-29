package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateImportContactsResultPage {

	@FindBy(name = "cancel")
	private WebElement finishBtn;
	
	
	public CreateImportContactsResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getFinishBtn() {
		return finishBtn;
	}
	
	public void clickOnFinishBtn()
	{
		finishBtn.click();
	}
	
}
