/**
 * @ JdbcConnectTest.java 
 */
package database;

import java.sql.*;

/**
 * <pre>
 * database
 * JdbcConnectTest.java 
 * </pre>
 *
 * @brief	: 
 * @author	: 문재웅(mjw8585@gmail.com)
 * @Date	: 2017. 2. 1.
 */
public class JdbcConnectTest {

	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL2 = "jdbc:mysql://joasm-db-test.cvcopzgadhgc.ap-northeast-1.rds.amazonaws.com/kenpro_general?characterEncoding=UTF-8&amp;zeroDateTimeBehavior=convertToNull";
	   static final String DB_URL ="jdbc:mysql://joasm-db-test.cvcopzgadhgc.ap-northeast-1.rds.amazonaws.com/auth_web?characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
	   //  Database credentials
	   static final String USER = "joasmuser";
	   static final String PASS = "mashFeiWa2";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      if (conn == null){
	    	  System.out.println("Null");
	      }
	      //STEP 4: Execute a query
	      /*
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT id, first, last, age FROM Employees";
	      ResultSet rs = stmt.executeQuery(sql);

	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("id");
	         int age = rs.getInt("age");
	         String first = rs.getString("first");
	         String last = rs.getString("last");

	         //Display values
	         System.out.print("ID: " + id);
	         System.out.print(", Age: " + age);
	         System.out.print(", First: " + first);
	         System.out.println(", Last: " + last);
	      }
	      */
	      //STEP 6: Clean-up environment
	      /*
	      rs.close();
	      stmt.close();
	      conn.close();
	      */
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main
}
