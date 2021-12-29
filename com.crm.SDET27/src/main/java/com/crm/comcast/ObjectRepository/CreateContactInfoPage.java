package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactInfoPage {
@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement cnctHeaderInfo;


public CreateContactInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}


public WebElement getCnctHeaderInfo() {
	return cnctHeaderInfo;
}


public String getContactInfo()
{
	return(cnctHeaderInfo.getText());
}
}
