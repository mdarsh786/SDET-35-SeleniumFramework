package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class WithoutInt {

	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		//Register to the database
	
			Driver driver=new Driver();
		
		DriverManager.registerDriver(driver);
		//Get the connection
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/students_info", "root", "root");
		//Write the query
		Statement stat=connection.createStatement();
		String query = "select * from students_info";
		//Execute the queries- Result 
		ResultSet resultSet = stat.executeQuery(query);
		while(resultSet.next())
		{
			System.out.println( resultSet.getString(1));
		}

		//Close the connection
	 {
			connection.close(); 
		}
		
		
	}

	}


