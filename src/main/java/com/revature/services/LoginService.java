package com.revature.services;

import java.util.List;
import java.util.Scanner;
import com.revature.daos.UsersDAO;
import com.revature.daos.RolesDAO;
import com.revature.models.Roles;
import com.revature.models.Users;
 
public class LoginService {
	
	public static void main(String[] args) {
		
		 
		System.out.println("input username  ");
		Scanner scan = new Scanner(System.in);
		String username = scan.nextLine();
		System.out.println("input password  ");
		Scanner scan2 = new Scanner(System.in);
		String password = scan2.nextLine();
		
		UsersDAO rd = new UsersDAO();
		String jd ="janedoe";
		String nm = "janedoe";
		System.out.println(" I'm in the p1");
		Users returnedRole = rd.getUserByUsername(jd);
		String nam = returnedRole.getErs_username();
		String pssd = returnedRole.getErs_password();
		System.out.println("--------------------------------------------------------");
		if (nam.equals(username) && pssd.equals(password)) {
			System.out.print("login successful for ");
			System.out.println(nm);
			 
		}else {
			
		System.out.println("username or password failed");
		}
		
	}

	public boolean login( String username, String password) {
		
		 
		
		if(username.equals("davidknutson") && password.equals("password1")) {
			return true;
		}
		
		return false;
	}

}
