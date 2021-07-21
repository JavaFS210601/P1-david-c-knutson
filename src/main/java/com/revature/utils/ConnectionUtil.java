package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.revature.daos.ExpenseDAO;
 
//We will need these Connection object in our DAO layer to interact with our database
public class ConnectionUtil {

	public static ExpenseDAO ad = new ExpenseDAO();
	
	public static void main(String[] args) {
			
			 
			try(Connection conn = ConnectionUtil.getConnection()) {
				System.out.println("connection successful");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println(ad.getAllExpenses());
	}
	
	
	 
	public static Connection getConnection() throws SQLException {
		 
		try {
			Class.forName("org.postgresql.Driver"); //try to find and return the postgresql Driver Class
		} catch (ClassNotFoundException e) {
			System.out.println("Class wasn't found :(");
			e.printStackTrace(); //prints the exception message to the console if we can't find the postgresql class
		}
		
 
		String url = "jdbc:postgresql://javafs210601.c9hxbolytvxu.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=ERS";	 
		String username = "postgres"; 
		String password = "password";	//this will be whatever password you set in postgres
 
		return DriverManager.getConnection(url, username, password);
	}
}