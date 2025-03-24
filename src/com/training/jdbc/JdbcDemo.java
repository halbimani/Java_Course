package com.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class JdbcDemo {
	
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/testdb";
		String username = "postgres";
		String password = "pass123";
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			
			
			PreparedStatement pstmt = connection.prepareStatement("Select * from employees where emp_name=?");
			pstmt.setString(1,  "Said Al-Hinai");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print("ID: " + rs.getString(1) + ", Name: " + rs.getString(2) + ", Age: " + rs.getString(3) + ", Salary: " + rs.getString(4) + "\n");
			}
			
//			Statement stmt = connection.createStatement();
//			ResultSet rs = stmt.executeQuery("Select * from employees");
			

		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
