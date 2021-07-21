package com.revature.daos;

import java.util.List;
import com.revature.models.Status;

public interface StatusInterface {
	
	public List<Status> getAllStatus(); //return all the status from the database

	public Status getStatusById(int id); //take in an int, find the status with that id

	public boolean addStatus(Status status); //take in an Status object, put it in the database

	public boolean deleteStatus(int id); //take in an int, delete the status with that id

}


 