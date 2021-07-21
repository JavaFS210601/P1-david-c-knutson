package com.revature.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Expense;
import com.revature.models.Roles;
import com.revature.services.RolesService;

public class RolesController {
	private RolesService as = new RolesService();
	private ObjectMapper om = new ObjectMapper();  
	
	public void getAllRoles(HttpServletResponse res) throws IOException {
		
		List<Roles> roleList = as.getAllRoles(); //get the List of Roles from the service layer 
		String json = om.writeValueAsString(roleList);
		res.getWriter().print(json);
		res.setStatus(200);
		
	}
	
	public void addRoles(HttpServletResponse res) throws IOException {
		
	}

}
