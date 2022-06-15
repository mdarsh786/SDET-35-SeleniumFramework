package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;
import com.mysql.jdbc.Driver;

public class NoSelectQuery {

	public static void main(String[] args) throws SQLException {
		  Connection conn = null;
		int result=0;
		//register the database
		try
		{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//get the connection
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arshad", "root", "root");
		//write the query
		Statement stat = conn.createStatement();
		String query = "insert into students_info (regno, firstname, middlename, lastname) values('1', 'ram','gowda', 'h')";
		//execute the query
		 result = stat.executeUpdate(query);
		}
		catch (Exception e) {
		
		}
		finally {
			if(result==1)
			{
				System.out.println("row is added");
			}
				else
				{
				System.out.println("row is not added");
				}
			}
			conn.close();
		}
	}



