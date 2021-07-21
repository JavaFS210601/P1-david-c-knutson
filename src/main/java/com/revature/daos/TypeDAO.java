package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Status;
import com.revature.models.Type;
import com.revature.utils.ConnectionUtil;

public class TypeDAO implements TypeInterface {
	

	 
	@Override
	public List<Type> getAllTypes(){
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM \"ERS\".type;"; //write your sql statement to send to the DB	
			Statement s = conn.createStatement(); //create a statement object to execute our query	
			ResultSet rs = s.executeQuery(sql); //put the result of the query into the ResultSet 
												//(Execute the query into it!)
			
			List<Type> typeList = new ArrayList<>(); //create a new ArrayList to hold all the Avengers
				
			while(rs.next()) {  
				 
				Type a = new Type (
					rs.getInt("reimb_type_id"), 
					rs.getString("reimb_type"));
				  
				typeList.add(a);
			}
			 
			return typeList;
			
			
		} catch (SQLException e) {
			System.out.println("Get all types failed!");
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
 
	@Override
	public Type getTypeById(int id) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM \"ERS\".status WHERE reimb_type_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);		
			ps.setInt(1, id); //set our wildcard to the parameter given in the method
			ResultSet rs = ps.executeQuery(); //the results of our query will be put into the ResultSet object
			
			if(rs.next()) {  
				 	
				Type h = new Type(); 
	
				h.setReimb_type_id(id); //this can just be the name object getting sent in from the parameters
				h.setReimb_type(rs.getString("reimb_type"));
			
				return h; 
			}
		
			
		} catch (SQLException e) {
			System.out.println("Couldn't get type by id");
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	

	@Override 
	public boolean addType(Type type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override 
	public boolean deleteType(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
  
