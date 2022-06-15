package com.crm.comcsat.POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
		WebDriver driver;
		public CreateCampaignPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(name = "campaignname")
		private WebElement campainnametxt;
		@FindBy(xpath = "//input[@type='submit']")
		private WebElement savebtn;
		
		public WebElement getCampainnametxt() {
			return campainnametxt;
		}

		public WebElement getSavebtn() {
			return savebtn;
		}
		
		public void campaignText(String cpName)
		{
			campainnametxt.sendKeys(cpName);
			savebtn.click();
		}
	
}
