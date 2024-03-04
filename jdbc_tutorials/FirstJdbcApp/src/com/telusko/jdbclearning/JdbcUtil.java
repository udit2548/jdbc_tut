package com.telusko.jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
    static {
    	//Load and register the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    public static Connection getConnection() throws SQLException {
  	  String url="jdbc:mysql://localhost:3306/jdbclearning";
  	  String user="root";
  	  String password="makkar@123";
  	  
  	 //To establish the connection to the database
  	  return DriverManager.getConnection(url,user,password);
    }
    
    public static void closeConnection(Connection connect, Statement statement) throws SQLException {
    	statement.close();
		connect.close();
    }
	
}
