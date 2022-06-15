package com.crm.comcsat.POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	 
	
	@FindBy(name = "user_name")
	private WebElement usernametxt;
	@FindBy(name = "user_password")
	private WebElement passwordtxt;
	@FindBy(id = "submitButton")
	private WebElement loginbtn;
	
	public WebElement getUsername() {
		return usernametxt;
	}
	public WebElement getPassword() {
		return passwordtxt;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	public WebDriver getDriver() {
		return driver;
	}
	

	public void LoginToapp(String username,String password)
	{
		 usernametxt.sendKeys(username);
		 passwordtxt.sendKeys(password);
		 loginbtn.click();
	}

}
