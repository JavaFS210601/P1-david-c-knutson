package com.revature.services;

import java.util.List;
import com.revature.daos.UsersDAO;
import com.revature.daos.UsersInterface;
import com.revature.models.Users;

public class UsersService {
	
	 
		private UsersInterface uDAO = new UsersDAO();
		
		public List<Users> getAllUsers() {
			return uDAO.getAllUsers();
		}
 
		public void addUsers(Users Users) {}
			 
	

}
