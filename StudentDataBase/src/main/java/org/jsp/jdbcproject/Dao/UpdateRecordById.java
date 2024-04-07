package org.jsp.jdbcproject.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateRecordById {

    public static void main(String[] args) {
        String qry = "update student set name=?, phone=?, st_class=?, marks=? where id=?";
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter id of student:");
            int id = sc.nextInt();
            System.out.println("Enter student name:");
            String name = sc.next();
            System.out.println("Enter student phone number:");
            long phone = sc.nextLong();
            System.out.println("Enter student class:");
            String st_class = sc.next();
            System.out.println("Enter marks of student:");
            double marks = sc.nextDouble();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "admin");

            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, name);
            pst.setLong(2, phone);
            pst.setString(3, st_class);
            pst.setDouble(4, marks);
            pst.setInt(5, id);

            int n = pst.executeUpdate();

            if (n > 0) {
                System.out.println("Updated Record!");
            } else {
                System.out.println("No record updated.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
