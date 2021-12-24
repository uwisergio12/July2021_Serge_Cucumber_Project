package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePage {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	
	public String getData(String ColumnName) {
		String columValue = null;
//		setting properties for MySql
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String squlUrl ="jdbc:mysql://127.0.0.1:3306/july2021";
			String sqlUserName = "root";
			String sqlPassword = "root";
			String query ="select * from users;";
			
//			create connection to local database
			connection = DriverManager.getConnection(squlUrl, sqlUserName, sqlPassword);
			
//			Empowering the connection reference variable to execute queries
			statement = connection.createStatement();
			
//			Delivering the query
			resultSet = statement.executeQuery(query);

			while(resultSet.next()) {
				columValue = resultSet.getString(ColumnName);
				return columValue;
				
			}	
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return columValue;
		
	}

}
