package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;

public class SelectQuery {
	


	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		//Register to the database
		try {
			Driver driver=new Driver();
		
		DriverManager.registerDriver(driver);
		//Get the connection
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/arshad", "root", "root");
		//Write the query
		Statement stat=connection.createStatement();
		String query = "select * from students_info";
		//Execute the queries- Result 
		ResultSet resultSet = stat.executeQuery(query);
		while(resultSet.next())
		{
			System.out.println( resultSet.getInt(1)+"\t"+resultSet.getString(2));
		}
		}
		catch (Exception e) {
			
		}
		//Close the connection
		finally {
			connection.close(); 
		}
		
		
	}

}
