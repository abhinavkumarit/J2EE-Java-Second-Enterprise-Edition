package org.jsp.jdbcproject.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class CreateDatabaseStudent {
	public static void main(String[] args) {
		String qry="create Database student_db";
//		Connection con;
		Statement st;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			st=con.createStatement();
			boolean res=st.execute(qry);
			if(res==false) {
				System.out.println("Database Created!");
			}
			else {
				System.out.println("Its already created!");
			}
		}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println("Invalid");
		}
	}
}
