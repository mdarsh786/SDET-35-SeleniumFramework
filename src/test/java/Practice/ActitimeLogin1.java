package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActitimeLogin1 {
//Updated the code
	//reUpdate
	public static void main(String[] args) throws IOException {
	FileInputStream fis=new FileInputStream("./data/arsh.property");
	Properties p=new Properties();
	p.load(fis);
	
	String browser1 = p.getProperty("browser1");
	String url = p.getProperty("url1");
	String un = p.getProperty("username");
	String pw = p.getProperty("pswd");
	
	WebDriver driver;
	if (browser1.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if (browser1.equals("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else
	{
		driver=new ChromeDriver(); 
	}
	driver.get(url);
	driver.findElement(By.id("username")).sendKeys(un);
	driver.findElement(By.name("pwd")).sendKeys(pw);
	driver.findElement(By.xpath("//div[text()='Login ']")).click();

	}

}

