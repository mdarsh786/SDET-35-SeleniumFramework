package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogoutVtiger {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./data/arsh.properties");
		Properties p=new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url2 = p.getProperty("url");
		String un = p.getProperty("usename"); 
		String pw = p.getProperty("password");
		System.out.println(url2);
		System.out.println(un);
		System.out.println(pw);
		
    //launch the browser
	
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
		driver.get(url2);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();
		
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
	}

}
