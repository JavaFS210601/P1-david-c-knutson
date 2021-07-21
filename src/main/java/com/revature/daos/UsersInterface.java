package com.revature.daos;

import java.util.List;
import com.revature.models.Users;

public interface UsersInterface {
	
	
	public List<Users> getAllUsers(); //return all the users from the database
	
	public Users getUserById(int id); //take in an int, find the user with that id
	
	public Users getUserByUsername(String uname); //take in an int, find the user with that id
	
	public boolean addUser(Users user); //take in an user object, put it in the database
	
	public boolean deleteUser(int id); //take in an int, delete the user with that id
	

}

 