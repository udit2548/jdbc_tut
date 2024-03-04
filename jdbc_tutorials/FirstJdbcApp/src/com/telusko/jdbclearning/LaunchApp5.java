// 1.import the required packages and add the database specific jar
package com.telusko.jdbclearning;
import java.sql.*;
public class LaunchApp5 {

	public static void main(String[] args){
		Connection connect=null;
		Statement statement=null;
	  try {
		
		  connect=JdbcUtil.getConnection();
	  
	 // 4. Creating Statement object(on the top of it, we will be executing our sql queries.)
	  statement = connect.createStatement();
	  String sql = "update studentInfo set sage=20 where id=1";
	 // execute the query (In jdbc, you have to hard-code the sql query)
	  // for non-select operations(insertion, updation and deletion) use executeUpdate() 
	 boolean status=statement.execute(sql);
	 /* execute will return true --> if query has retrieve or select operation involved
	  * execute will return false--> if query has non-select or insert,update and delete involved
	  * */
	  if(status) {
		  // Selection or retrieval logic
		  ResultSet rs = statement.getResultSet();
		  while(rs.next()) {
		    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
		  }
		  
	  }
	  else {
		 // insert, update and delete logic involved here..
		  int rows = statement.getUpdateCount();
		  if(rows==0) {
			  System.out.println("No operation has been done");
		  }
		  else {
			  System.out.println("Operation done successfully");
		  }
	  }
	  
	 // process the result
	  
	  }
	  catch (SQLException e) {
		// TODO Auto-generated catch block
		     e.printStackTrace();
	        }
	  catch(Exception e) {
		    e.printStackTrace();
	  }
	  finally {
		  // close the resources and connection
		  try {
			  JdbcUtil.closeConnection(connect, statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	  
	  }

}
