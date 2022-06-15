package com.crm.comcsat.POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	WebDriver driver;
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "productname")
	private WebElement productText;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement savebtn;
	
	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getProductText() {
		return productText;
	}

	public void clickOnSave(String pText)

	{
		productText.sendKeys(pText);
		savebtn.click();
	}
}
