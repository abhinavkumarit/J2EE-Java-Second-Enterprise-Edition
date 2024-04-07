package org.jsp.jdbcproject.TestConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connected Successfully");
		}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println("Failed to make Connection!");
		}

	}

}
