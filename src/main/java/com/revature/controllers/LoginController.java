package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Expense;
import com.revature.models.LoginDTO;
import com.revature.services.LoginService;

public class LoginController {

	ObjectMapper om = new ObjectMapper(); //so we can work with JSON
	private LoginService ls = new LoginService();
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		if(req.getMethod().equals("POST")) { //making sure we actually got a POST request before executing. 
			
			BufferedReader reader = req.getReader(); //BufferedReader reads text from an input string (in our case JSON)
			StringBuilder sb = new StringBuilder(); //create an empty StringBuilder
			String line = reader.readLine(); //this will read the contents of the BufferedReader into a String
			
			while(line != null) { //while there is data to read from the response data (res -> reader -> line)
				
				sb.append(line); //add the contents of "line" to the StringBuilder
				line = reader.readLine(); //assign line to the next line of data in the reader

			}
			
			String body = new String(sb); //so we make a new String to hold the StringBuilder content
			Expense exp = om.readValue(body, Expense.class);
			 
		}
		
	}

}
