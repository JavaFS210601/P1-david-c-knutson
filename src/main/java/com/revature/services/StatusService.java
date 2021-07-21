package com.revature.services;

import java.util.List;
import com.revature.daos.StatusDAO;
import com.revature.daos.StatusInterface;
import com.revature.models.Status;
 

public class StatusService {
	
	 
	private StatusInterface sDAO = new StatusDAO();
	 
	public List<Status> getAllStatus() {
		return sDAO.getAllStatus();
	}
 
	public void addStatus(Status Status) {}
		 

}
