package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.controllers.ExpenseController;
import com.revature.controllers.LoginController;
import com.revature.controllers.RolesController;
import com.revature.controllers.StatusController;
import com.revature.controllers.TypeController;
import com.revature.controllers.UsersController;
 
//This is our front controller - ALL requests that come in will have to hit this first.
public class MasterServlet extends HttpServlet {

	private ExpenseController ac = new ExpenseController();
	private StatusController sc = new StatusController();
	private RolesController rc = new RolesController();
	private TypeController tc = new TypeController();
	private UsersController uc = new UsersController();
	private LoginController lc = new LoginController();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("application/json"); //set the content of our response object to be JSON
		
		//by default, Tomcat will send back a successful status code (200) if a request gets handled.
		//since we have a master servlet that takes all requests, this means all requests will get hendled.
		//this can lead to problems - we don't want a 200 if the request isn't handled correctly
		//thus, by default, we'll set the status code to 404, and change it in our code upon success.
		res.setStatus(404);
		
		 
		
		String URI = req.getRequestURI().replace("/P1-david-c-knutson/", "");
		 
		
		switch(URI) {
		
		case "expenses": 
		
			ac.getAllExpenses(res); 
			break;
						
		case "addExpense": 
			
			ac.addExpense(res,req); 
			break;	
			
		case "updateExpense": 
			
			ac.addExpense(res,req); 
			break;
			
		case "status": 
			
			sc.getAllStatus(res); 
			break;
			
		case "roles": 
			
			rc.getAllRoles(res); 
			break;
			
		case "users": 
	
			uc.getAllUsers(res); 
			break;
			
		case "types": 
			
			tc.getAllTypes(res); 
			break;
			
			
		case "login": 
			
			lc.login(req, res);
			break;
		
		}
		
	}
	
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
		 
		 
		
	}
	
}
