package org.jsp.jdbcproject.TestConnection;

public class LoadAndRegisterDriverClass {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load and registered driver class");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Failed to make connections!");
		}
	}
}
