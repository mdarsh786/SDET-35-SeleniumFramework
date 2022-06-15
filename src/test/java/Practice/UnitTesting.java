package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Collection;
import com.mysql.jdbc.Driver;

public class UnitTesting {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		String name="product";
		try
		{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/arsh", "root", "root");
		System.out.println("connection is done");
		Statement stst = conn.createStatement();
		String query = "select * from product";
		ResultSet resultSet = stst.executeQuery(query);
		while(resultSet.next())
		{
			String actname = resultSet.getString(1);
			if(actname.equals(name))
			{
				System.out.println("show the product");
			}
		}
		
	}
		catch (Exception e) {
		}
		finally {
			conn.close();
		}
		}

}
