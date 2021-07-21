package com.revature.daos;
// daves expense interface
import java.util.List;

import com.revature.models.Expense;


public interface ExpenseInterface {
	
	public List<Expense> getAllExpenses(); //return all the expenses from the database

	public Expense getExpenseById(int id); //take in an int, find the expense with that id

	public void addExpense(Expense expense); //take in an Expense object, put it in the database

	public boolean deleteExpense(int id); //take in an int, delete the expense with that id
	
	public void updateExpense(Expense expense); //take in an Expense object, put it in the database

}


 