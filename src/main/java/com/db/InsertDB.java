package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDB {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/JDBC01";
	private static final String dbUser = "root";
	private static final String dbPassword = "Vedant 16";
	
	public static void insertData(String empName, String empPassword, int empSalary) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			pStatement = connection.prepareStatement("INSERT INTO employee(emp_name, password, emp_salary) VALUES (?,?,?);");
			
			pStatement.setString(1, empName);
			pStatement.setString(2, empPassword);
			pStatement.setInt(3, empSalary);
			
			pStatement.executeUpdate();
			
			System.out.println("Data added successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
}
