package com.bluebird.comcast.campaignTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Genric_Utility.Excel_Utility;
import Genric_Utility.File_Utility;
import Genric_Utility.Java_Utility;
import Genric_Utility.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test(invocationCount = 2)
public class CreateCampaignTest {

	public static void main(String[] args) throws Throwable {
		

		File_Utility plib = new File_Utility();
		Java_Utility ran1 = new Java_Utility();
		Excel_Utility exc = new Excel_Utility();
		WebDriver_Utility web = new WebDriver_Utility();
		
		String browser = plib.getPropertyFile("browser");
		String url = plib.getPropertyFile("url");
		String un = plib.getPropertyFile("usename"); 
		String pw = plib.getPropertyFile("password");
		
		int ran2 = ran1.getRandom();
		
		String data = exc.getDataFromExcel("arshad", 1, 4)+ran2;
		System.out.println(data);
		
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
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		WebElement more = driver.findElement(By.xpath("//a[@href='javascript:;']"));
		
		//Actions ac=new Actions(driver);

		web.mouseOverOnElement(driver, more);
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(data);
		driver.findElement(By.name("button")).click();
		
		
		 WebElement logOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 web.mouseOverOnElement(driver, logOut);
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		driver.close();
	}

}
