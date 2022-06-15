package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NoSelectQuery1 {

	public static void main(String[] args) throws SQLException {
		  Connection conn = null;
			int result=0;
			//register the database
			try
			{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			//get the connection
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arsh", "root", "root");
			//write the query
			Statement stat = conn.createStatement();
			String query = "insert into product (regno, pname, pmiddlename, plastname) values('1', 'ram','gowda', 'h')";
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


