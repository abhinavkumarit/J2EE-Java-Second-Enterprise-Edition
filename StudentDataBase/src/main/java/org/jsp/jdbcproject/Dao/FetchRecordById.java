package org.jsp.jdbcproject.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class FetchRecordById {

    public static void main(String[] args) {
        String qry = "select * from student where id=?";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of student: ");
        int id = sc.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "admin");
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, id);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                System.out.println("student id: " + rst.getInt(1) + ", student name: " + rst.getString(2) + ", student phone: " + rst.getLong(3) + ", student class: " + rst.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
