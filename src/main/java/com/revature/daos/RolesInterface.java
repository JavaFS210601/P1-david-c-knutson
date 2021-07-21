package com.revature.daos;
 
import java.util.List;
import com.revature.models.Roles;

public interface RolesInterface {

	public List<Roles> getAllRoles(); //return all the roles from the database

	public Roles getRoleById(int id); //take in an int, find the role with that id

	public boolean addRole(Roles role); //take in an role object, put it in the database

	public boolean deleteRole(int id); //take in an int, delete the role with that id
	

}


 