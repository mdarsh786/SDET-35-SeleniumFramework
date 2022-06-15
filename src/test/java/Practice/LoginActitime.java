package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginActitime {

	

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "E:\\Eclipes workspaces\\Selenium Worksapces\\Worspaces1\\Actitime");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();

	}

}
