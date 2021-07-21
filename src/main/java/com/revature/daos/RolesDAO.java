package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Roles;
import com.revature.models.Type;
import com.revature.models.Users;
import com.revature.utils.ConnectionUtil;

public class RolesDAO implements RolesInterface{
	
	
	@Override
	public List<Roles> getAllRoles(){
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM \"ERS\".roles;"; //write your sql statement to send to the DB
			Statement s = conn.createStatement(); //create a statement object to execute our query	
			ResultSet rs = s.executeQuery(sql); //put the result of the query into the ResultSet 
												//(Execute the query into it!)
			List<Roles> roleList = new ArrayList<>();  
				
			while(rs.next()) { //while there are still rows in our ResultSet
				 
				Roles a = new Roles (
					rs.getInt("ers_user_role_id"), 
					rs.getString("user_role"));
 			 
				roleList.add(a);
			}
		 
			return roleList;
			
			
		} catch (SQLException e) {
			System.out.println("Get all roles failed!");
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	

		
		
		
		 
		
		@Override
		public Roles getRoleById(int id) {

			try(Connection conn = ConnectionUtil.getConnection()) {
				 
				String sql = "SELECT * FROM \"ERS\".users WHERE ers_user_role_id = ?;";
				PreparedStatement ps = conn.prepareStatement(sql);	
				ps.setInt(1, id); //set our wildcard to the parameter given in the method	
				ResultSet rs = ps.executeQuery(); //the results of our query will be put into the ResultSet object
		
				if(rs.next()) { //we won't need a while loop, we're only expecting one result
					 	
					Roles h = new Roles();  
					 
					h.setErs_user_role_id(id); //this can just be the name object getting sent in from the parameters
					h.setUser_role(rs.getString("user_role"));
				
					return h;  
				}
			
				
			} catch (SQLException e) {
				System.out.println("Couldn't get user by id");
				e.printStackTrace();
			}
			
			
			
			return null;
		}
 
		@Override 
		public boolean addRole(Roles role) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override 
		public boolean deleteRole(int id) {
			// TODO Auto-generated method stub
			return false;
		}

	}
