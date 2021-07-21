package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Expense;
import com.revature.models.Users;
import com.revature.utils.ConnectionUtil;

public class UsersDAO implements UsersInterface {
	
	@Override
	public List<Users> getAllUsers(){
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM \"ERS\".users;"; //write your sql statement to send to the DB	
			Statement s = conn.createStatement(); //create a statement object to execute our query	
			ResultSet rs = s.executeQuery(sql); //put the result of the query into the ResultSet 
												//(Execute the query into it!)
			
			List<Users> usersList = new ArrayList<>(); //create a new ArrayList to hold all the Avengers
				
			while(rs.next()) {
				 
				Users a = new Users (
					rs.getInt("ers_users_id"),
					rs.getString("ers_username"),
					rs.getString("ers_password"),
					rs.getString("user_first_name"),
					rs.getString("user_last_name"),
					rs.getString("user_email"), 
					rs.getInt("user_role_id"));
				 
				usersList.add(a);
			}
			
			 
			return usersList;
			
			
		} catch (SQLException e) {
			System.out.println("Get all users failed!");
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	

 
	 
	
	@Override
	public Users getUserById(int id) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM \"ERS\".users WHERE ers_users_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id); 	
			ResultSet rs = ps.executeQuery();  
			
			if(rs.next()) { 
				 	
				Users h = new Users(); 
				 
				h.setErs_users_id(id); //this can just be the name object getting sent in from the parameters
				h.setErs_username(rs.getString("ers_username"));
				h.setErs_password(rs.getString("ers_password"));
				h.setUser_first_name(rs.getString("user_first_name"));
				h.setUser_last_name(rs.getString("user_last_name"));
				h.setUser_email(rs.getString("user_email"));
				h.setUser_role_id(rs.getInt("user_role_id"));
			
				return h; 
			}
		
			
		} catch (SQLException e) {
			System.out.println("Couldn't get user by id");
			e.printStackTrace();
		}	
		
		return null;
	}

	@Override
	public Users getUserByUsername(String uname) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM \"ERS\".users WHERE ers_username = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setString(1, uname); 	
			ResultSet rs = ps.executeQuery(); 
			
			if(rs.next()) { 
				 	
				Users h = new Users(); 
			 
				h.setErs_users_id(rs.getInt("ers_users_id"));  
				h.setErs_username(uname);
				h.setErs_password(rs.getString("ers_password"));
				h.setUser_first_name(rs.getString("user_first_name"));
				h.setUser_last_name(rs.getString("user_last_name"));
				h.setUser_email(rs.getString("user_email"));
				h.setUser_role_id(rs.getInt("user_role_id"));
			
				return h; 
			}
		
			
		} catch (SQLException e) {
			System.out.println("Couldn't get user by id");
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	 
	
	@Override 
	public boolean addUser(Users users) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override 
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
