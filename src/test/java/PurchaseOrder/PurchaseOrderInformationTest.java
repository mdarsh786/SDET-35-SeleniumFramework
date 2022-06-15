package PurchaseOrder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PurchaseOrderInformationTest {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./data/arsh.properties");
		Properties p=new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("usename"); 
		String pw = p.getProperty("password");
		
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
		Actions ac=new Actions(driver);
		ac.moveToElement(more).perform();
		driver.findElement(By.xpath("//a[@href='index.php?module=PurchaseOrder&action=index']")).click();
		WebElement list = driver.findElement(By.id("bas_searchfield"));
		Select s=new Select(list);
		List<WebElement> options = s.getOptions();
		int count=options.size();
		for(int i=0; i<count; i++);
		{
			s.selectByIndex(1);
		}
		driver.findElement(By.xpath("//a[@title='Purchase Order']")).click();
		
		WebElement info = driver.findElement(By.xpath("//a[text()='More Information']"));
		Actions ac1=new Actions(driver);
		ac.moveToElement(info).perform();
		driver.findElement(By.xpath("//a[text()='Activities']")).click();
		driver.findElement(By.id("show_PurchaseOrder_Activities")).click();
		driver.findElement(By.name("button")).click();
	
		//logout
		ac.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		
		
	}

}
