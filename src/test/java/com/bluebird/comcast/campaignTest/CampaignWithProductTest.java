package com.bluebird.comcast.campaignTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcsat.POM_Repository.CampaignInfoPage;
import com.crm.comcsat.POM_Repository.CampaignPage;
import com.crm.comcsat.POM_Repository.CreateCampaignPage;
import com.crm.comcsat.POM_Repository.CreateCampaignWithProtPage;
import com.crm.comcsat.POM_Repository.HomePage;
import com.crm.comcsat.POM_Repository.LoginPage;

import Genric_Utility.Excel_Utility;
import Genric_Utility.File_Utility;
import Genric_Utility.Java_Utility;
import Genric_Utility.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CampaignWithProductTest {

	public static void main(String[] args) throws Throwable {
		// creating object
		File_Utility plib = new File_Utility();
		Java_Utility ran1 = new Java_Utility();
		Excel_Utility exc = new Excel_Utility();
		WebDriver_Utility web = new WebDriver_Utility();
		
	//fetching the data from property file
		String browser = plib.getPropertyFile("browser");
		String url = plib.getPropertyFile("url");
		String un = plib.getPropertyFile("usename");
		String pw = plib.getPropertyFile("password");
	//we can get the random number
		int ran2 = ran1.getRandom();
	//fetching the data from Excel File
		String data = exc.getDataFromExcel("arsh", 1, 4)+ran2;
	//lounching the Browser
		WebDriver driver;
		if(browser.equals("chrome"))
				{
			WebDriverManager.chromiumdriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
				}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		// login an application
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.LoginToapp(un, pw);
		//navigate to module on hompage
		HomePage hp=new HomePage(driver);
		hp.navigatToCampaignPage();
		
		CampaignPage cp= new CampaignPage(driver);
		cp.getCreateCampaign().click();
		
		CreateCampaignWithProtPage ccp=new CreateCampaignWithProtPage(driver);
		ccp.clickOnSelect(data);
		ccp.switchWindow(driver, "Products&action");
		
		CampaignInfoPage cip=new CampaignInfoPage(driver);
		web.wiatForElement(driver,cip.getTextInfo());
		String actinfo = cip.getTextInfo().getText();
		if(actinfo.contains(data))
		{
			System.out.println("Campaign is created and pass");
		}
		else
		{
			System.out.println("Campaign is not created and pass");
		}
		//navigate to loguot
		hp.navigateToLogout();
	}

}
