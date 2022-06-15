package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class UnitTesting2 {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		String name = "list1";
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arsh", "root", "root");
			System.out.println("connection is done");
			Statement stat = conn.createStatement();
			String query = "select * from list1";
			ResultSet resultSet = stat.executeQuery(query);
			while(resultSet.next())
			{
				String actname = resultSet.getString(1);
				System.out.println("show the list");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			conn.close();
		}

	}

}
