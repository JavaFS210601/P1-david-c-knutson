package com.revature.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Expense;
import com.revature.models.Type;
import com.revature.services.TypeService;

public class TypeController {
	
	private TypeService as = new TypeService();
	private ObjectMapper om = new ObjectMapper();  
	
	public void getAllTypes(HttpServletResponse res) throws IOException {
		
		List<Type> typeList = as.getAllTypes(); //get the List of Types from the service layer
		String json = om.writeValueAsString(typeList);
		res.getWriter().print(json);
		res.setStatus(200);
		
	}
	
	public void addExpense(HttpServletResponse res) throws IOException {
	
	}

}
