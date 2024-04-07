package org.jsp.jdbcproject.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteRecordStudentById {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String qry = "delete from student where id=?";
        System.out.println("Enter student id:");
        int id = sc.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "admin");
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, id);
            int n = pst.executeUpdate();  // No need to pass the query string here

            if (n > 0) {
                System.out.println("Student record with id "+id+" deleted!");
            } else {
                System.out.println("Failed to delete!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
