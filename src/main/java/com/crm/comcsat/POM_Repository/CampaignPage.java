package com.crm.comcsat.POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	WebDriver driver;
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createCampaign;
	 
	public void createNewCam()
	{
		createCampaign.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateCampaign() {
		return createCampaign;
	}
}
