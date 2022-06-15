package Genric_Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.mysql.jdbc.Driver;

public class DataBase_Utility {
	static Driver driver;
	static Connection conn;
	static ResultSet result;
	
	public void connectWithDataBase() {
	
		try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection("\"jdbc:mysql://localhost:3306/arshad\", \"root\", \"root\"");
		}
			catch (Exception e) {
					
		}
	}	
	public void closeDataBase()
	{
		try {
			conn.close();
		}
		catch (Exception e) {
			
		}
	}
	public ResultSet executeQuery(String query) throws SQLException
	{
		result=conn.createStatement().executeQuery(query);
		return result;
	}
	
	public int executeUpdate(String query) throws SQLException
	{
	int	result=conn.createStatement().executeUpdate(query);
	return result;
	}

}
