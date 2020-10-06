package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDB {

	public static void main(String[] args) {
		
		int no_of_rows = 0;
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver exists!");
			}
			catch(ClassNotFoundException ex) {
				System.out.println("Error: unable to load driver class!");
				ex.printStackTrace();
			}
		try {
			myConn = DriverManager.getConnection
					("jdbc:mysql://127.0.0.1:3306/web_student_tracker?user=root&autoReconnect=true&useSSL=false",
							"root","manojkumar");
			String sql ="SELECT * FROM student";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()) {
				no_of_rows++;
			}
			System.out.println("There are "+ no_of_rows + " record in the table");
			System.out.println("\n\n-Manojkumar V K (CSE17040)");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
}
