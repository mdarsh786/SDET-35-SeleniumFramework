package Genric_Utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImp implements ITestListener{
	
	public void onTestFailure(ITestResult result)
	{
		String tname = result.getMethod().getMethodName();
		System.out.println("Executed");
		EventFiringWebDriver driver=new EventFiringWebDriver(BaseClass.sDriver);
		File srcfile = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File("./ScreenShot/"+tname+".png"));
			
		} catch (Exception e) {
			
		}
	}

}
