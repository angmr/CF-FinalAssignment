 package gr.aueb.cf.doctorsapp.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection conn;
	
	/**
	 * No instances will be available
	 */
	private DBUtil() {}
	
	public static Connection openConnection() throws SQLException {
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			// create connection strings
			String url = "jdbc:mysql://localhost:3306/doctors?serverTimezone=UTC"; 
			String username = "user5";
			String password = "lp#52";
			
			// create connection
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeConnection() throws SQLException {
		conn.close();
	}
}

