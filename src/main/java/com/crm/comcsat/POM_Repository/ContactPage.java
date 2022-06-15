package com.crm.comcsat.POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	WebDriver driver;
	public  ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement contact;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getContact() {
		return contact;
	}

	public void clickOnCreateContact()
	{
	contact.click();
	}
}
