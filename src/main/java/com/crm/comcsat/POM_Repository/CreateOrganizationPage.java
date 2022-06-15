package com.crm.comcsat.POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	
	WebDriver driver;
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgName;
	@FindBy(name = "button")
	private WebElement savebtn;
	
	public WebElement getOrgName() {
		return orgName;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void clickOnSave(String orgname)
	{
		orgName.sendKeys(orgname);
		savebtn.click();
	}
}
