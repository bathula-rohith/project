package insp.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDao {
	private static String jdbcUrl ="jdbc:mysql://localhost:3306/servlet";
	private static String userName="root";
	private static String userPwd="root";
	
	public static Connection getConnection()
	{
		Connection connection =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection  = DriverManager.getConnection(jdbcUrl, userName,userPwd);
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		
		{
			e.printStackTrace();
		}
		return connection;
		
	}
	

}

