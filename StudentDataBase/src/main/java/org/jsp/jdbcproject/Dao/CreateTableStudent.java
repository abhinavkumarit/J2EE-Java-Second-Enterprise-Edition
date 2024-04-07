package org.jsp.jdbcproject.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableStudent {
	public static void main(String[] args) {
		String qry="CREATE TABLE student ("
                + "id INT PRIMARY KEY, "
                + "name VARCHAR(10) NOT NULL, "
                + "phone BIGINT(10) NOT NULL UNIQUE, "
                + "st_class VARCHAR(50) NOT NULL, "
                + "marks DECIMAL"
                + ")";
		Statement st;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "admin");
			st=con.createStatement();
			boolean res=st.execute(qry);
			if(res==false) {
				System.out.println("Table is created!");
			}
			else {
				System.out.println("Failed to create!");
			}
		}
		catch(ClassNotFoundException | SQLException e) {
//			System.out.println("error!");
//			System.out.println();
			e.printStackTrace();
		}
	}
}
