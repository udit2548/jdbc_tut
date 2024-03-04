// 1.import the required packages and add the database specific jar
package com.telusko.jdbclearning;
import java.sql.*;
public class LaunchApp3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
     // 2.Load and register the driver,meanwhile implementation we have loaded it from the 
	 // db vendor into the java application, forName()==> simply to load the class at compile time
	  Class.forName("com.mysql.cj.jdbc.Driver"); // implemented by the DB vendor 
	  // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	  String url="jdbc:mysql://localhost:3306/jdbclearning";
	  String user="root";
	  String password="makkar@123";
	  
	 //3. To establish the connection to the database
	 // will return the connection object that we will be receiving within Connection interface
	 //(polymorphism example)
	  Connection connect = DriverManager.getConnection(url,user,password);
	  
	 // 4. Creating Statement object(on the top of it, we will be executing our sql queries.)
	  Statement statement = connect.createStatement();
	  String sql = "select * from studentInfo";
	 // execute the query (In jdbc, you have to hard-code the sql query)
	  // for non-select operations(insertion, updation and deletion) use executeUpdate() 
	  // for select or retrieval operations use executeQuery()
	          ResultSet rs = statement.executeQuery(sql);
	  // ResultSet is just like table in java application }
	 // process the result
	  while(rs.next()) {
		  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
//System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getInt("sage")+" "+rs.getString("sname"));

	  }
	  
	  // close the resources and connection
	  rs.close();
	  statement.close();
	  connect.close();
	  
		
	}

}
