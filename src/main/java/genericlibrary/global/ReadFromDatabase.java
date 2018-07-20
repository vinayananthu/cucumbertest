package genericlibrary.global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadFromDatabase {
	
	 public static void main(String[] args) throws ClassNotFoundException {

		    String jdbcUrl = "jdbc:postgresql://devdb-dev.xpressdocs.com:5432/v3dev54_prod";
		    String username = "qa_auto_proc";
		    String password = "EaVRyKaJTxkM";

		    Connection conn = null;
		    Statement stmt = null;
		    ResultSet rs = null;

		    try {
		      // Step 1 - Load driver
		     //Class.forName("org.postgresql.Driver"); // Class.forName() is not needed since JDBC 4.0

		      // Step 2 - Open connection
		      conn = DriverManager.getConnection(jdbcUrl, username, password);

		      // Step 3 - Execute statement
		      stmt = conn.createStatement();
		      rs = stmt.executeQuery("SELECT version()");

		      // Step 4 - Get result
		      if (rs.next()) {
		        System.out.println(rs.getString(1));
		      }

		    } catch (SQLException e) {
		      e.printStackTrace();
		    } finally {
		      try {

		        // Step 5 Close connection
		        if (stmt != null) {
		          stmt.close();
		        }
		        if (rs != null) {
		          rs.close();
		        }
		        if (conn != null) {
		          conn.close();
		        }
		      } catch (Exception e) {
		        e.printStackTrace();
		      }
		    }

		  }
}
