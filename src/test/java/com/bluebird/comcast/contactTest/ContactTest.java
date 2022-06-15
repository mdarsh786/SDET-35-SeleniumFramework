package com.bluebird.comcast.contactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcsat.POM_Repository.ContactInfoPage;
import com.crm.comcsat.POM_Repository.ContactPage;
import com.crm.comcsat.POM_Repository.CreateConatctPage;
import com.crm.comcsat.POM_Repository.HomePage;
import com.crm.comcsat.POM_Repository.LoginPage;

import Genric_Utility.Excel_Utility;
import Genric_Utility.File_Utility;
import Genric_Utility.Java_Utility;
import Genric_Utility.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactTest {

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
		
	//fetching the data from Excel File
		String data = exc.getDataFromExcel("arsh", 1, 4);
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
		hp.getContactlnk().click();
		//clicking on create contact
		ContactPage cp=new ContactPage(driver);
		cp.clickOnCreateContact();
		//creating the new contact
		CreateConatctPage ccp=new CreateConatctPage(driver);
		ccp.clickOnSave(data);
		//verify the created page information
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actinfo = cip.getContactinfo().getText();
		if(actinfo.contains(data))
		{
			System.out.println("Contact is created and pass");
		}
		else
		{
			System.out.println("Contact is not created and pass");
		}
		cip.clickOnDeletebtn();
		web.switchToAlertWindowAccept(driver, "Are you sure you want to delete this record?");
		
		//navigate to loguot
		hp.navigateToLogout();
		
	}

}
