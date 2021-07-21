package com.revature.services;

import java.util.List;
import com.revature.daos.ExpenseDAO;
import com.revature.daos.ExpenseInterface;
import com.revature.models.Expense;
 
public class ExpenseService {

	 
	private ExpenseInterface eDAO = new ExpenseDAO();
	 
	public List<Expense> getAllExpenses() {
		return eDAO.getAllExpenses();
	}
	 
	public void addExpense(Expense expense) {
	eDAO.addExpense(expense);
		
	}
	
	public void updateExpense(Expense expense) {
		eDAO.addExpense(expense);
			
		}
	
	
	public int getExpenseId( int reimbId, int inputId) {
	   
		if(reimbId == inputId) {
			return reimbId;
		}
		
		return inputId;
	}
	
	public int randomFunction() {
		int hi = 13;
        return hi;
	
	}
 
}
 

