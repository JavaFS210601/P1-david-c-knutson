package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Expense;
import com.revature.models.Status;
import com.revature.utils.ConnectionUtil;

public class StatusDAO implements StatusInterface {
	

	@Override
	public List<Status> getAllStatus(){
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM \"ERS\".status;"; //write your sql statement to send to the DB
			Statement s = conn.createStatement(); //create a statement object to execute our query		
			ResultSet rs = s.executeQuery(sql); //put the result of the query into the ResultSet 
												//(Execute the query into it!)
			
			List<Status> statusList = new ArrayList<>(); 
				
			while(rs.next()) {  
				 
				Status a = new Status (
					rs.getInt("reimb_status_id"), 
					rs.getString("reimb_status"));
					 
				statusList.add(a);
			}
			
			return statusList;
			
			
		} catch (SQLException e) {
			System.out.println("Get all status failed!");
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
  
	
	@Override
	public Status getStatusById(int id) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM \"ERS\".status WHERE reimb_status_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);  			
			ResultSet rs = ps.executeQuery(); //the results of our query will be put into the ResultSet object
			
			if(rs.next()) {  
				 	
				Status h = new Status();  
				h.setReimb_status_id(id);  
				h.setReimb_status(rs.getString("reimb_status"));
			
				return h;  
			}
		
			
		} catch (SQLException e) {
			System.out.println("Couldn't get status by id");
			e.printStackTrace();
		}
		
		return null;
	}
 	

	@Override 
	public boolean addStatus(Status status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override 
	public boolean deleteStatus(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
