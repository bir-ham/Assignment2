package assignment2.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccessObject {

	protected static Connection getConnection() {
		
		try {
			 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			  Connection connection = DriverManager.getConnection(
	                    "jdbc:mysql://localhost/role", "role",
	                    "role");
			return connection;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	protected static void close(Statement statement, Connection connection) {
		
		close(null, statement, connection);
	}

	protected static void close(ResultSet rs, Statement statement,
			Connection connection) {
		
		try {
			if (rs != null)
				rs.close();
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
