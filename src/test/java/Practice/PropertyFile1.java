package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile1 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./data/arsh.property");
		Properties p=new Properties();
		p.load(fis);
		
		String url = p.getProperty("url1");
		String un = p.getProperty("username");
		String pw = p.getProperty("pswd");
		
		System.out.println(url);
		System.out.println(un);
		System.out.println(pw);
		

	}

	

}
