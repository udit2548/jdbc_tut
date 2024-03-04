// 1.import the required packages and add the database specific jar
package com.telusko.jdbclearning;
import java.util.*;
import java.sql.*;
public class LaunchApp6 {
// about PreparedStatement in this lecture... (Child interface of the Statement interface)
	public static void main(String[] args){
		Connection connect=null;
		Statement statement=null;
		PreparedStatement pstmnt=null;
	  try {
		
		  connect=JdbcUtil.getConnection();
	  
	 // 4. Creating Statement object(on the top of it, we will be executing our sql queries.)
	  //statement = connect.createStatement();
	  
	  
	  // String sql = "insert into studentInfo(id,sname,sage,scity) values(3,'Ram',22,'Shimla')";
	//(we are hardcoding values in case of createStatement(), while in other we are passing 
	//	 placeholders. )
	 // execute the query (In jdbc, you have to hard-coded the sql query)
	  // for non-select operations(insertion, updation and deletion) use executeUpdate() 
	  String query ="insert into studentInfo(id,sname,sage,scity) values(?,?,?,?)";
	  pstmnt = connect.prepareStatement(query);
	  
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter id:");
	  Integer id = sc.nextInt();
	  System.out.println("Enter name:");
	  String name=sc.next();
	  System.out.println("Enter age:");
	  Integer age=sc.nextInt();
	  System.out.println("Enter city:");
	  String city=sc.next();
	  
	  // now mapping input values into place holders.
	  pstmnt.setInt(1,id);
	  pstmnt.setString(2, name);
	  pstmnt.setInt(3, age);
	  pstmnt.setString(4,city);
	  int rowsChanged = pstmnt.executeUpdate();
	  
	  if(rowsChanged==0) {
		  System.out.println("No data has been Inserted");
	  }
	  else {
		  System.out.println("Data inserted successfully!");
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
			  JdbcUtil.closeConnection(connect, pstmnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }

}
	}
