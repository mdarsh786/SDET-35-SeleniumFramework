package Practice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Genric_Utility.File_Utility;


public class GenericLib {

	public static void main(String[] args) throws Throwable {
		
	/*	FileInputStream fis=new FileInputStream("./data/arsh.properties");
		Properties p=new Properties();
		p.load(fis); */
		
		File_Utility plib=new File_Utility();
		
		String browser = plib.getPropertyFile("browser1");
		String url = plib.getPropertyFile("url1");
		String un = plib.getPropertyFile("username1");
		String pw = plib.getPropertyFile("password1");
		
		System.out.println(browser);
		System.out.println(url);
		System.out.println(un);
		System.out.println(pw);
		
		
	/*	Excel_Utility ex=new Excel_Utility();
		String data = ex.getDataFromExcel("Book1", 1, 1);
		System.out.println(data); */
		
		

	}

}
