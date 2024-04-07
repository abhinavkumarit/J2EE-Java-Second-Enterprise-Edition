package org.jsp.jdbcproject.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class FilterRecordsBasedOnMarks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String qry = "select * from student where marks between ? and ?";
        System.out.println("Enter min_marks of student and max_marks:");
        double min_marks = sc.nextDouble();
        double max_marks = sc.nextDouble();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "admin");

            PreparedStatement pst = con.prepareStatement(qry);
            pst.setDouble(1, min_marks);
            pst.setDouble(2, max_marks);

            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
            	System.out.print("---------------------------------------------------------------------------------------------------------------------------------------");
            	System.out.println();
                System.out.println("student id: " + rst.getInt(1) + ", student name: " + rst.getString(2)+", student phone: " + rst.getLong(3) + ", student class: " + rst.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
