package com.crm.comcsat.POM_Repository;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Genric_Utility.WebDriver_Utility;

public class DeleteContactPage extends WebDriver_Utility{
	
	WebDriver driver;
	public DeleteContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "search_text")
	private WebElement searchtext;
	@FindBy(id = "bas_searchfield")
	private WebElement selectlastname;
	@FindBy(xpath = "//input[@type='button']")
	private WebElement searchnow;
	@FindBy(name = "selected_id")
	private WebElement checkbox;
	@FindBy(className = "crmbutton small delete")
	private WebElement deletlebtn;
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getSearchtext() {
		return searchtext;
	}
	public WebElement getDeletlebtn() {
		return deletlebtn;
	}
	public WebElement getSelectlastname() {
		return selectlastname;
	}
	public WebElement getSearchnow() {
		return searchnow;
	}
	public WebElement getCheckbox() {
		return checkbox;
	}
	
	public void select(String name) {
		searchtext.sendKeys(name);
		select(selectlastname, 2);
		searchnow.click();
		checkbox.click();
	}
	public void delete()
	{
		deletlebtn.click();
	}

}
