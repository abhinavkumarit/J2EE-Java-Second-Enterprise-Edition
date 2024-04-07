package org.jsp.jdbcproject.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertStudentRecordes {
	public static void main(String[] args) {
		String qry="insert into student values (?,?,?,?,?)";
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","admin");
			PreparedStatement pst=con.prepareStatement(qry);
			System.out.println("Enter id of student");
			pst.setInt(1, sc.nextInt());
			System.out.println("Enter name of student");
			pst.setString(2, sc.next());
			System.out.println("Enter phone of student:");
			pst.setLong(3, sc.nextLong());
			System.out.println("Enter class of student:");
			pst.setString(4, sc.next());
			System.out.println("Enter marks of student:");
			pst.setDouble(5, sc.nextDouble());
			int n=pst.executeUpdate();
			if(n>0) {
				System.out.println("student record added successfully!");
			}
			else {
				System.out.println("Failed to add!");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
