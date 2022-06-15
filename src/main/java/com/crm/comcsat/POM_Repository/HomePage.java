package com.crm.comcsat.POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Genric_Utility.WebDriver_Utility;

public class HomePage extends WebDriver_Utility {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Organization
	@FindBy(linkText = "Organizations")
	private WebElement organizationlnk;
	
	//Contact
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactlnk;
	
	//Product
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productlnk;
	
	//More
	@FindBy(xpath = "//a[@href='javascript:;']")
	private WebElement more;
	
	//Campaigns
	@FindBy(name = "Campaigns")
	private WebElement campaignlnk;;
	
	//Vendors
	@FindBy(name = "Vendors")
	private WebElement vendorlnk;
	
	//Ducuments
	@FindBy(xpath = "//a[text()='Documents']")
	private WebElement documentlnk;
	
	//PurchaseOrder
	@FindBy(name = "Purchase Order")
	private WebElement porderlnk;
	
	//loguot
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminst;
	@FindBy(xpath ="//a[@href='index.php?module=Users&action=Logout']")
	private WebElement logoutbtn;

	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getOrganizationlnk() {
		return organizationlnk;
	}
	public WebElement getContactlnk() {
		return contactlnk;
	}
	public WebElement getProductlnk() {
		return productlnk;
	}
	public WebElement getMore() {
		return more;
	}
	public WebElement getCampaignlnk() {
		return campaignlnk;
	}
	public WebElement getVendorlnk() {
		return vendorlnk;
	}
	public WebElement getDocumentlnk() {
		return documentlnk;
	}
	public WebElement getPorderlnk() {
		return porderlnk;
	}
	
	public void navigatToCampaignPage()
	{
		mouseOverOnElement(driver, more);
		wiatForElement(driver, campaignlnk);
		campaignlnk.click();	
	}
	public void navigatToVendors()
	{
		mouseOverOnElement(driver, more);
		wiatForElement(driver, vendorlnk);
		vendorlnk.click();
	}
	public void naigateToPurchaseOrder()
	{
		mouseOverOnElement(driver, more);
		wiatForElement(driver,porderlnk);
		porderlnk.click();
	}
	public void navigateToLogout()
	{
		mouseOverOnElement(driver, adminst);
		wiatForElement(driver,logoutbtn);
		logoutbtn.click();
	}
	
}
