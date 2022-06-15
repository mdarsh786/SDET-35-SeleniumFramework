package com.bluebird.comcast.campaignTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProductTest2 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./data/arsh.property");
		Properties p=new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("usename"); 
		String pw = p.getProperty("password");
		
		Random ran = new Random();
		int ranNum = ran.nextInt(100);
		
		FileInputStream fis1=new FileInputStream("./data/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("arshad");
		Row row = sheet.getRow(2);
		String org = row.getCell(2).getStringCellValue()+ranNum;
		wb.close();
		System.out.println(org);
		
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
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(org);
		driver.findElement(By.name("button")).click();
		
        WebElement more = driver.findElement(By.xpath("//a[@href='javascript:;']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(more).perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> itr1 = wh.iterator();//loop
		
		while(itr1.hasNext())
		{
			String cid = itr1.next();
			driver.switchTo().window(cid);
			String title1 = driver.getTitle();
			
			if(title1.contains("Products&action"))
			{
				break;
			}
		}
		
		driver.findElement(By.name("campaignname")).sendKeys(org);
		driver.findElement(By.name("button")).click();

	}

}
