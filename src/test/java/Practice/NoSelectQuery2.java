package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;
import com.mysql.jdbc.Driver;

public class NoSelectQuery2 {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		int resultSet = 0;
		try
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arsh","root","root");
			Statement stat = conn.createStatement();
			String query = "insert into students_info (regno, firstname, middlename, lastname) values('1', 'ram','gowda', 'h')";
			resultSet = stat.executeUpdate(query);
			}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			if(resultSet==1)
			{
				System.out.println("row is added");
			}
			else
			{
				System.out.println("row is not added");
			}
			conn.close();
		}
			

	}

}
