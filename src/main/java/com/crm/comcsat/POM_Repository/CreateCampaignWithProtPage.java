package com.crm.comcsat.POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Genric_Utility.WebDriver_Utility;

public class CreateCampaignWithProtPage extends WebDriver_Utility {
	WebDriver driver;
	public CreateCampaignWithProtPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement campainnametxt;
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement selectimg;
	@FindBy(name = "search_text")
	private WebElement searchtxt;
	@FindBy(name = "search")
	private WebElement searchnow;
	@FindBy(xpath = "//a[@href='javascript:window.close();']")
	private WebElement selectpName;
	@FindBy(name = "button")
	private WebElement savebtn;

	public WebElement getSelect() {
		return selectimg;
	}
	
	public void clickOnSelect(String txt)
	{
		campainnametxt.sendKeys(txt);
		selectimg.click();
	}
	
	public void switchWindow(WebDriver driver, String text) 
	{
		switchToWindow(driver, "Products&action");
		searchtxt.sendKeys(text);
		searchnow.click();
		selectpName.click();
		switchToWindow(driver, "Campaigns&action");
		savebtn.click();
		
	}
}
