package org.jsp.jdbcproject.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

public class FetchingAllRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String qry="select * from student";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","admin");
			Statement st=con.createStatement();
			ResultSet rst=st.executeQuery(qry);
			while(rst.next()) {
				System.out.println("student_id"+rst.getInt(1)+", "+"student_name:"+rst.getString(2)+", "+"phone:"+rst.getLong(3)+", "+"class:"+rst.getString(4)+", "+"marks:"+rst.getDouble(5));
//				System.out.println();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
