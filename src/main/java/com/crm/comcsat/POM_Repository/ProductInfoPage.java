package com.crm.comcsat.POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	
	WebDriver driver;
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className = "lvtHeaderText")
	private WebElement textInfo;

	public WebElement getTextInfo() {
		return textInfo;
	}
}
