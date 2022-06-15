package com.crm.comcsat.POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateConatctPage {
	
	WebDriver driver;
	public CreateConatctPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastnametxt;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLastnametxt() {
		return lastnametxt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public void clickOnSave(String lastname)
	{
	lastnametxt.sendKeys(lastname);
	savebtn.click();
	}
}
