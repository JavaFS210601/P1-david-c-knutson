package com.revature.services;

import java.util.List;
import com.revature.daos.RolesDAO;
import com.revature.daos.RolesInterface;
import com.revature.models.Roles;

public class RolesService {
	
	 
			private RolesInterface rDAO = new RolesDAO();
			public List<Roles> getAllRoles() {
				return rDAO.getAllRoles();
			}
 
			public void addRoles(Roles Roles) {}
				 

}
