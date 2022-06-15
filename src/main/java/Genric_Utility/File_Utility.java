package Genric_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
	
	public String getPropertyFile(String key) throws Throwable {
		
		/**
		 * @author Arshad
		 * this method using for fetching the data from property file
		 */
		
		//String path ="./data/comm.properties";
		
		FileInputStream fis=new FileInputStream("./data/arsh.properties");
		Properties p=new Properties();
		p.load(fis);
		 String  data= p.getProperty(key);
		return data;
	}

}
