package com.crm.comcsat.POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Genric_Utility.WebDriver_Utility;

public class ContactInfoPage {
	
	WebDriver driver;
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
 
	@FindBy(id="dtlview_Last Name")
	private WebElement txtmsg;
	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement deletebtn;
	
	public WebElement getTxtmsg() {
		return txtmsg;
	}

	public WebElement getDeletebtn() {
		return deletebtn;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getContactinfo() {
		return txtmsg;
	}
	public void clickOnDeletebtn() {
		deletebtn.click();
	}
}
