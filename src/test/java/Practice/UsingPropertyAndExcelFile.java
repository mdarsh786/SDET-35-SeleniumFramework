package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingPropertyAndExcelFile {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream("./data/arsh.property");
		Properties p=new Properties();
		p.load(fis);
		
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("usename"); 
		String pw = p.getProperty("password");
		
		System.out.println(url);
		System.out.println(un);
		System.out.println(pw);
		
		Random ran = new Random();
		int ranNum = ran.nextInt(100);
		
		FileInputStream fis1=new FileInputStream("./data/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("Sheet2");
		Row row = sheet.getRow(0);
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
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(org);
		driver.findElement(By.name("button")).click();
		Thread.sleep(5000);
		String actorg = driver.findElement(By.className("dvHeaderText")).getText();
		if (actorg.contains(org)) {
			System.out.println("print the text");
		}
		else
		{
			System.out.println("dont print the text");
		}
		
	}

}
