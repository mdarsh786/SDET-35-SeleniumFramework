package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;
import com.mysql.cj.xdevapi.Collection;
import com.mysql.jdbc.Driver;

public class SelectQuery2 {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		//register the database
		try
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//get the connection
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/arsh","root","root");
			
			//write the query
			Statement stat = conn.createStatement();
			String query = "select * from customer";
			
			//execute the query-Result
			ResultSet resultSet = stat.executeQuery(query);
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1));
			}
		}
		catch (Exception e) {
			
		}
		//close the connection
		finally {
			conn.close();
		}

	}

}
