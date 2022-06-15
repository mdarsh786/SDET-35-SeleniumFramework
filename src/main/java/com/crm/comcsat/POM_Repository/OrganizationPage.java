package com.crm.comcsat.POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	WebDriver driver;
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	 @FindBy(xpath = "//img[@alt='Create Organization...']")
	 private WebElement createorganization;

	public WebElement getCreateorganization()
	{
		return createorganization;
	}

	public void clickOnCreateOrg()
	{
		createorganization.click();
	}
	 

}
