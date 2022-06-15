package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SelectQuery1 {

	public static void main(String[] args) throws SQLException {
		
		Connection connection=null;
		//register the database
		try
		{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//get the connection
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arsh","root","root");
		
		//write the query
		Statement stat = connection.createStatement();
		String query = "select * from product";
		//execute the query-result
		ResultSet resultSet = stat.executeQuery(query);
		while(resultSet.next())
		{
			System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(1));
		}
	}
		catch (Exception e) 
		{
			
		}
		//close the connection
		finally {
			connection.close();
		}

	}

}
