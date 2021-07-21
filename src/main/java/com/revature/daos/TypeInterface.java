package com.revature.daos;

import java.util.List;
import com.revature.models.Type;


public interface TypeInterface {
	
	
	public List<Type> getAllTypes(); //return all the types from the database
	
	public Type getTypeById(int id); //take in an int, find the type with that id
	
	public boolean addType(Type type); //take in an type object, put it in the database
	
	public boolean deleteType(int id); //take in an int, delete the type with that id

}


 