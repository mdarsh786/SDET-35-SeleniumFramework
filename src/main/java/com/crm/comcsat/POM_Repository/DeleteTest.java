package com.crm.comcsat.POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Genric_Utility.Excel_Utility;
import Genric_Utility.File_Utility;
import Genric_Utility.Java_Utility;
import Genric_Utility.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteTest {

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
		//int ran2 = ran1.getRandom();
	//fetching the data from Excel File
		String data = exc.getDataFromExcel("arsh", 2, 4);
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
		
		DeleteContactPage dcp=new DeleteContactPage(driver);
		dcp.select(data);
		//web.wiatForElement(driver,"deletlebtn");
		dcp.delete();
		

	}

}
