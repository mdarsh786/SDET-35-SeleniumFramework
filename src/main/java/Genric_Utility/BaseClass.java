package Genric_Utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.comcsat.POM_Repository.HomePage;
import com.crm.comcsat.POM_Repository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public Java_Utility ran1=new Java_Utility();
	public File_Utility plib=new File_Utility();
	public Excel_Utility exc=new Excel_Utility();
	public WebDriver_Utility web=new WebDriver_Utility();
	
	public WebDriver driver;
	public static WebDriver sDriver=null;
	@BeforeSuite(groups = { "smokeTest","regressionTest"})
	public void beforesuite()
	{
		System.out.println("database connection");
	}
	
	@BeforeTest(groups = { "smokeTest","regressionTest"})
	public void beforetest()
	{
		System.out.println("execute script in parallel mode");
	}
	
	@BeforeClass(groups = { "smokeTest","regressionTest"})
	public void beforeclass() throws Throwable
	
	{
		String browser=plib.getPropertyFile("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
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
	
		driver.manage().window().maximize();
		String url = plib.getPropertyFile("url");
		driver.get(url);
		sDriver=driver;
		
	}	
	@BeforeMethod(groups = { "smokeTest","regressionTest"})
	public void beforemethod() throws Throwable
	{
		String usn = plib.getPropertyFile("usename");
		String psw = plib.getPropertyFile("password");
		LoginPage logPage=new LoginPage(driver);
		logPage.LoginToapp(usn, psw);
	}
	
	@AfterMethod(groups = { "smokeTest","regressionTest"})
	public void aftermethod()
	{
		HomePage hm=new HomePage(driver);
		hm.navigateToLogout();
	}
	
	@AfterClass(groups = { "smokeTest","regressionTest"})
	public void afterclass()
	{
		driver.quit();
	}
	
	@AfterTest(groups = { "smokeTest","regressionTest"})
	public void aftertest()
	{
		System.out.println("parallel execution is completed");
	}
	
	@AfterSuite(groups = { "smokeTest","regressionTest"})
	public void aftersuite()
	{
		System.out.println("Database connection removed");
	}
}
