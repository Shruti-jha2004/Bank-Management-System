package bankManagementSystem;


import java.sql.*;

//import com.mysql.cj.xdevapi.Statement;

public class ConnectingDatabase {
	
	Connection connection;
	
	Statement statement;
	
	public ConnectingDatabase() {
		
		try {
			connection = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/bankManagementSystem",
	                "root",
	                "Shruti#2004"
	            );
			statement = connection.createStatement();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
