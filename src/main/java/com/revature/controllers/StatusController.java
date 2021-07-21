package com.revature.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Expense;
import com.revature.models.Status;
import com.revature.services.StatusService;
public class StatusController {
		
	private StatusService as = new StatusService();
	private ObjectMapper om = new ObjectMapper();  
	public void getAllStatus(HttpServletResponse res) throws IOException {
		
		List<Status> statusList = as.getAllStatus(); //get the List of Status from the service layer
		String json = om.writeValueAsString(statusList);
		res.getWriter().print(json);
		res.setStatus(200);
		
	}
		 
}
