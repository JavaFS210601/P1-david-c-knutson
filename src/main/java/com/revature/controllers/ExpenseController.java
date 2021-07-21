package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Expense;
import com.revature.services.ExpenseService;

 

public class ExpenseController {
	
	private ExpenseService as = new ExpenseService();
	private ObjectMapper om = new ObjectMapper(); //ObjectMapper is part of Jackson api, used to 
												  //transform data from JSON -> Java or Java -> JSON
	
	//whenever you're working with HttpServletRequests/Responses, your method will need to throw an IOException
	public void getAllExpenses(HttpServletResponse res) throws IOException {
		    
		List<Expense> expenseList = as.getAllExpenses(); //get the List of Expenses 
		String json = om.writeValueAsString(expenseList); //turn that List in a JSON String	
		res.getWriter().print(json); //put the JSON into the response object (res)
		res.setStatus(200); //override the default 404 status code that we set in the MasterServlet
		
	}
	
	public void addExpense(HttpServletResponse res,HttpServletRequest req) throws IOException {
		
		if(req.getMethod().equals("POST")) {  //get the List of Expenses from the service layer (which got it from the dao layer)
		  //making sure we actually got a POST request before executing. 
			
			BufferedReader reader = req.getReader(); //BufferedReader reads text from an input string (in our case JSON)
			StringBuilder sb = new StringBuilder(); //create an empty StringBuilder
			String line = reader.readLine(); //this will read the contents of the BufferedReader into a String
			
			while(line != null) { //while there is data to read from the response data (res -> reader -> line)
				
				sb.append(line); //add the contents of "line" to the StringBuilder
				line = reader.readLine(); //assign line to the next line of data in the reader
					 
			}
											 
			String body = new String(sb); //we make a new String to hold the StringBuilder content
			Expense exp = om.readValue(body, Expense.class);
			as.addExpense(exp);
			res.setStatus(200);
			
		}		
		
	}
	
	
	
	public void updateExpense(HttpServletResponse res,HttpServletRequest req) throws IOException {
		
		if(req.getMethod().equals("POST")) {  //get the List of Expenses from the service layer (which got it from the dao layer)
			 
			BufferedReader reader = req.getReader(); //BufferedReader reads text from an input string (in our case JSON)
			StringBuilder sb = new StringBuilder(); //create an empty StringBuilder
			String line = reader.readLine(); //this will read the contents of the BufferedReader into a String
			
			while(line != null) { //while there is data to read from the response data (res -> reader -> line)
				
				sb.append(line); //add the contents of "line" to the StringBuilder
				line = reader.readLine(); //assign line to the next line of data in the reader
			
			}
			
			String body = new String(sb); //Make a new String to hold the StringBuilder content
			Expense exp = om.readValue(body, Expense.class);
			as.updateExpense(exp);
			res.setStatus(200);
			
		}		
		
	}
	
	

}// to class expense controller
