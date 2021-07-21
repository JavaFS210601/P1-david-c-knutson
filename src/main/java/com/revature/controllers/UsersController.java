package com.revature.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Expense;
import com.revature.models.Users;
import com.revature.services.UsersService;

public class UsersController {
	
	private UsersService as = new UsersService();
	private ObjectMapper om = new ObjectMapper();  
	
	public void getAllUsers(HttpServletResponse res) throws IOException {
		
		List<Users> usersList = as.getAllUsers(); //get the List of Users from the service layer
		String json = om.writeValueAsString(usersList);
		res.getWriter().print(json);
		res.setStatus(200);
		
	}
 
	public void addExpense(HttpServletResponse res) throws IOException {
		
	}

}
