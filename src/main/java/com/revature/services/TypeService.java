package com.revature.services;

import java.util.List;
import com.revature.daos.TypeDAO;
import com.revature.daos.TypeInterface;
import com.revature.models.Type;
 

public class TypeService {
	
	 
	private TypeInterface tDAO = new TypeDAO();
	 
	public List<Type> getAllTypes() {
		return tDAO.getAllTypes();
	}
 
	public void addTypes(Type Types) {}
		 
	

}
