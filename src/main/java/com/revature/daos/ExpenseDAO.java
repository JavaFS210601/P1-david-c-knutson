package com.revature.daos;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.revature.models.Expense;
import com.revature.utils.ConnectionUtil;

public class ExpenseDAO implements ExpenseInterface{
	
	@Override
	public List<Expense> getAllExpenses(){
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM \"ERS\".expense;"; //sql statement to send to the DB
			Statement s = conn.createStatement(); //create a statement object to execute our query
			ResultSet rs = s.executeQuery(sql); //put the result of the query into the ResultSet 
			List<Expense> expenseList = new ArrayList<>(); //create a new ArrayList  
				
			while(rs.next()) { //while there are still rows in our ResultSet
				 
				Expense a = new Expense (
					rs.getInt("reimb_id"),
					rs.getDouble("reimb_amount"),
					rs.getString("reimb_submitted"),
					rs.getString("reimb_resolved"),
					rs.getString("reimb_description"),
					rs.getInt("reimb_author"),
					rs.getInt("reimb_resolver"),
					rs.getInt("reimb_status_id"), 
					rs.getInt("reimb_type_id"));
				 
				expenseList.add(a);
			}
			 
			return expenseList;
				
		} catch (SQLException e) {
			System.out.println("Get all expenses failed!");
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	 
	@Override
	public Expense getExpenseById(int id) {  // get individual Expense Ticket 
		
			try(Connection conn = ConnectionUtil.getConnection()) {
			
				String sql = "SELECT * FROM \"ERS\".users WHERE reimb_id = ?;";
				PreparedStatement ps = conn.prepareStatement(sql);	
				ps.setInt(1, id);  
				ResultSet rs = ps.executeQuery();  
				
				if(rs.next()) {  
				 	
					Expense h = new Expense(); //instantiate an empty expense object
 
					h.setReimb_id(id);  
					h.setReimb_amount(rs.getDouble("reimb_amount"));
					h.setReimb_submitted(rs.getString("reimb_submitted"));
					h.setReimb_resolved(rs.getString("reimb_resolved"));
					h.setReimb_author(rs.getInt("reimb_author"));
					h.setReimb_resolver(rs.getInt("reimb_resolver"));
					h.setReimb_status_id(rs.getInt("reimb_status_id"));
					h.setReimb_type_id(rs.getInt("reimb_type_id"));

				return h;  
			}
			
		} catch (SQLException e) {
			System.out.println("Couldn't get user by id");
			e.printStackTrace();
		}
		
 	
		return null;
	}

 
	@Override
	public void addExpense(Expense expense) { //This is INSERT functionality
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //date formatter formats dates 	
			Date date = new Date(); //new date from java.util package
			Date date2 = new Date();
			String submitDate = dateFormat.format(date);
			String resolvedDate = dateFormat.format(date2);
			 
			String sql = "INSERT INTO \"ERS\".expense (reimb_amount, reimb_submitted,reimb_resolved,reimb_description,reimb_author,reimb_resolver "
					+ ",reimb_status_id ,reimb_type_id) "  
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";  
			
			PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with parameters
			 
			ps.setDouble(1, expense.getReimb_amount());
			ps.setDate(2, java.sql.Date.valueOf(submitDate)); //this takes our Java Date, and turns it into a SQL Date.
			ps.setDate(3, java.sql.Date.valueOf(resolvedDate)); //this takes our Java Date, and turns it into a SQL Date.
			ps.setString(4, expense.getReimb_description());
			ps.setInt(5, expense.getReimb_author());
			ps.setInt(6, expense.getReimb_resolver());
			ps.setInt(7, expense.getReimb_status_id());
			ps.setInt(8, expense.getReimb_type_id());

			ps.executeUpdate(); //we use executeUpdate for inserts, updates, and deletes. 
			
			System.out.println("----------------------------------------------------------------------------------------------------"); 
			System.out.println("Expense " + expense.getReimb_description() + " created. Sending in for approval");
			System.out.println("----------------------------------------------------------------------------------------------------");
		} catch(SQLException e) {
			System.out.println("Add Expense failed");
			e.printStackTrace();
		}
		
	}//  to add expense
 
	
	
	@Override
	public boolean deleteExpense(int id) {
		// TODO Auto-generated method stub
		return false;
	}
		 


	@Override
	public void updateExpense(Expense expense) { //This is INSERT functionality (with complicated date functionality if you dare...)
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			 
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //date formatter formats dates 
			Date date = new Date(); //new date from java.util package
			Date date2 = new Date();
			String resolvedDate = dateFormat.format(date2);
			
			String sql = "INSERT INTO \"ERS\".expense (reimb_id,reimb_amount, reimb_submitted,reimb_resolved,reimb_description,reimb_author,reimb_resolver "
					+ ",reimb_status_id ,reimb_type_id) " //creating a line break for readability
					+ "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?);"; //these are parameters!!! We have to now specify the value of each "?"
			
			PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with parameters
			
			ps.setInt(1, expense.getReimb_id());
			ps.setDouble(2, expense.getReimb_amount());
			ps.setString(3, expense.getReimb_submitted()); 
			ps.setDate(4, java.sql.Date.valueOf(resolvedDate));  
			ps.setString(5, expense.getReimb_description());
			ps.setInt(6, expense.getReimb_author());
			ps.setInt(7, expense.getReimb_resolver());
			ps.setInt(8, expense.getReimb_status_id());
			ps.setInt(9, expense.getReimb_type_id());
 
			ps.executeUpdate(); //we use executeUpdate for inserts, updates, and deletes. 
			//send confirmation to the console if successful
			System.out.println("----------------------------------------------------------------------------------------------------");	 
			System.out.println("Expense " + expense.getReimb_description() + " created. Sending in for approval");
			System.out.println("----------------------------------------------------------------------------------------------------");
		} catch(SQLException e) {
			System.out.println("Add Expense failed");
			e.printStackTrace();
		}
		
	}//  to add expense
 

}// end of class
