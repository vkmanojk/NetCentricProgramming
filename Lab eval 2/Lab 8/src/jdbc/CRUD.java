package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CRUD {

	public static void main(String[] args) {
		int no_of_rows = 0;
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		String sql ="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			}
			catch(ClassNotFoundException ex) {
				System.out.println("Error: unable to load driver class!");
				ex.printStackTrace();
			}
		try {
			//Connecting to Database
			myConn = DriverManager.getConnection
					("jdbc:mysql://127.0.0.1:3306/web_student_tracker?user=root&autoReconnect=true&useSSL=false",
							"root","manojkumar");
			myStmt = myConn.createStatement();

//			sql = "DROP TABLE Registration"; 
//			myStmt.executeUpdate(sql);
			
			//Creating table
			sql = "CREATE TABLE Registration " +
	                   "(id INTEGER not NULL, " +
	                   " first VARCHAR(255), " + 
	                   " last VARCHAR(255), " + 
	                   " age INTEGER, " + 
	                   " PRIMARY KEY ( id ))"; 
			myStmt.executeUpdate(sql);
			System.out.println("Created the table");
			
			//Altering table structure
			sql = "ALTER TABLE Registration ADD address VARCHAR(100) ";
			myStmt.executeUpdate(sql);
			System.out.println("Altered the table");
			sql = "SELECT * FROM Registration";
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()) {
				no_of_rows++;
			}
			System.out.println("There are "+ no_of_rows + " record in the table");
			
			//Inserting records
			no_of_rows = 0;
			sql = "INSERT INTO Registration VALUES (100, 'Zara', 'Jina', 18,'Cbe')";
			myStmt.executeUpdate(sql);
			sql = "INSERT INTO Registration VALUES (101, 'Mana', 'Khan', 25,'Cbe')";
			myStmt.executeUpdate(sql);
			sql = "INSERT INTO Registration VALUES (102, 'Zaid', 'Khan', 30,'Cbe')";
			myStmt.executeUpdate(sql);
			sql = "INSERT INTO Registration VALUES(103, 'Sumi', 'Mtal', 28,'Cbe')";
			myStmt.executeUpdate(sql);
			System.out.println("\nInserted records into the table");
			sql = "SELECT * FROM Registration";
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()) {
				no_of_rows++;
				int id  = myRs.getInt("id");
		        int age = myRs.getInt("age");
		        String first = myRs.getString("first");
		        String last = myRs.getString("last");
		        System.out.println("ID: " + id +"| Age: " + age + "| First: " + first +"| Last: " + last);
			}
			System.out.println("There are "+ no_of_rows + " record in the table\n");
			
			//Updating table contents
			no_of_rows = 0;
			sql = "UPDATE Registration SET age = 30 WHERE id in (100, 101)";
			myStmt.executeUpdate(sql);
			sql = "SELECT * FROM Registration";
			myRs = myStmt.executeQuery(sql);
			System.out.println("\nUpdated value in the table");
			while(myRs.next()) {
				no_of_rows++;
				int id  = myRs.getInt("id");
		        int age = myRs.getInt("age");
		        String first = myRs.getString("first");
		        String last = myRs.getString("last");
		        System.out.println("ID: " + id +"| Age: " + age + "| First: " + first +"| Last: " + last);
			}
			System.out.println("There are "+ no_of_rows + " record in the table\n");
			
			//Deleting table
			no_of_rows = 0;
			sql = "DELETE FROM Registration WHERE id = 101";
			myStmt.executeUpdate(sql);
			sql = "SELECT * FROM Registration";
			myRs = myStmt.executeQuery(sql);
			System.out.println("\nDeleted record with id 101");
			while(myRs.next()) {
				no_of_rows++;
				int id  = myRs.getInt("id");
		        int age = myRs.getInt("age");
		        String first = myRs.getString("first");
		        String last = myRs.getString("last");
		        System.out.println("ID: " + id +"| Age: " + age + "| First: " + first +"| Last: " + last);
			}
			System.out.println("There are "+ no_of_rows + " record in the table\n");
			
			//Dropping the table from the database
			sql = "DROP TABLE Registration "; 
			myStmt.executeUpdate(sql);
			System.out.println("Table  droped from database");
			System.out.println("\n\n-Manojkumar V K (CSE17040)");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
