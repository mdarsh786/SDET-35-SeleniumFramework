package com.crm.comcsat.POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProduct;

	public WebElement getCreateProduct() {
		return createProduct;
	}

	public void clickOnCreateProdut()
	{
		createProduct.click();
	}
}
