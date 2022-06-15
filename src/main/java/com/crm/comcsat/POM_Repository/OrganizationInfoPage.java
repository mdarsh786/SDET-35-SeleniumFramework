package com.crm.comcsat.POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement textInfo;

	public WebElement getTextInfo() {
		return textInfo;
	}
}
