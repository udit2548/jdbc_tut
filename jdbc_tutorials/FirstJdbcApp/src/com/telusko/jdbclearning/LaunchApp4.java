// 1.import the required packages and add the database specific jar
package com.telusko.jdbclearning;
import java.sql.*;
public class LaunchApp4 {

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
	  String sql = "delete from studentInfo where id=2";
	 // execute the query (In jdbc, you have to hard-code the sql query)
	  // for non-select operations(insertion, updation and deletion) use executeUpdate() 
	  int rowsChanged = statement.executeUpdate(sql);
	  if(rowsChanged==0) {
		  System.out.println("No data has been deleted");
	  }
	  else {
		  System.out.println("Data deleted successfully!");
	  }
	  
	 // process the result
	  
	  // close the resources and connection
	  statement.close();
	  connect.close();
	  
		
	}

}
