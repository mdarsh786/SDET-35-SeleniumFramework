package Genric_Utility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.command.PullImageCmd;
import com.mysql.jdbc.Driver;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class WebDriver_Utility {
	
	/**
	 * it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
	 * @param driver
	 */
	public void wiatForElementLoadInDOM(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(IConstant.Imlicitly_TimeOut,TimeUnit.SECONDS);
		
	}
	
	/**
	 * it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partialPage
	 */
	public void waitForPage(WebDriver driver, String partialPage)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,IConstant.Explicitly_Timeout);
		wait.until(ExpectedConditions.urlContains(partialPage));
	}
	
	/**
	 * it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param element
	 */
	public void wiatForElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,IConstant.Explicitly_Timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 *   used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		 Set<String> wh = driver.getWindowHandles();
		 Iterator<String> it = wh.iterator();
		 while(it.hasNext())
		 {
			 String wid = it.next();
			 driver.switchTo().window(wid);
			 String curWindow = driver.getTitle();
			 
			 if(curWindow.contains(partialWindowTitle))
			 {
				 break;
			 }
		  }
		 
	}
		 
		 /**
		  * used to Switch to Alert Window & click on OK button
		  * @param driver
		  * @param expectedMsg
		  */
		 public void switchToAlertWindowAccept(WebDriver driver, String expectedMsg)
	{
		Alert alt = driver.switchTo().alert();
		if(alt.getText().trim().equals(expectedMsg.trim()))
		{
			System.out.println("Alert msg is verified");
		}
		else
		{
			System.out.println("Alert msg is not verified");
		}
		alt.accept();
	}
	 
	 /**
	  * used to Switch to Alert Window & click on Cancel button
	  * @param driver
	  * @param expectedMesg
	  */
	 public void switchToAlertWindowCancel(WebDriver driver,String expectedMesg)
	 {
		 Alert alt1 = driver.switchTo().alert();
			if(alt1.getText().equals(expectedMesg))
			{
				System.out.println("Alert msg is verified");
			}
			else
			{
				System.out.println("Alert msg is not verified");
			}
			alt1.dismiss(); 
	 }
	 
	 /**
	  * used to Switch to Frame Window based on index
	  * @param driver
	  * @param index
	  */
	 public void switchToFrame(WebDriver driver,int index)
	 {
		 driver.switchTo().frame(index);
	 }
	 
	 /**
	  * used to Switch to Frame Window based on id or name attribute
	  * @param driver
	  * @param idNameAttribute
	  */
	public void switchToFrame(WebDriver driver,String idNameAttribute)	
	{
		driver.switchTo().frame(idNameAttribute);
	}
	
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * used to select the value from the dropDwon  based on value / option avlaible in GUI
	 * @param element
	 * @param text
	 */
	public void select(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(element).perform();
	}
	
	/**
	 * used to right click  on specified element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions ac=new Actions(driver);
		ac.contextClick(element).perform();
	}
	
	/**
	 * pass enter Key appertain in to Browser
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver)
	{
		Actions ac=new Actions(driver);
		ac.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver, String javaScript)
	{
		JavascriptExecutor jsp=(JavascriptExecutor)driver;
		jsp.executeAsyncScript(javaScript, null);
	}
	
	public void waitAndClick(WebElement element) throws InterruptedException 
	{
		int count=0;
		while(count<20)
		{
			try {
				element.click();
				break;
			}
			catch (Throwable e)
			{
				Thread.sleep(10000);
				count++;
			}
		}
	}

}
