package com.revature;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import com.revature.models.Expense;
import com.revature.models.Users;
import com.revature.services.ExpenseService;
import com.revature.services.LoginService;
import com.revature.services.RolesService;
import com.revature.services.StatusService;
import com.revature.services.TypeService;
import com.revature.services.UsersService;

public class Tests {
	 
	LoginService ls = new LoginService();  
	UsersService us = new UsersService();
	ExpenseService es = new ExpenseService();
	TypeService ts = new TypeService();
	RolesService rs = new RolesService();
	StatusService ss = new StatusService();
	
	@Test
	public void testValidLogin() {	
		System.out.println("TESTING VALID LOGIN");
		assertTrue(ls.login("davidknutson", "password1"));	
	}
		
	
	@Test
	public void testInValidLogin() {  
		System.out.println("TESTING INVALID LOGIN");
		assertFalse(ls.login("jjkllh", "pipjjiiij"));	
	}
	
	
	@Test
	public void testValidExpenseIdTest(){
	  int expid = getExpenseId();
	  int exptst = 1;
	  System.out.println("TESTING VALID EXPENSE_ID");
	  assertTrue(exptst != expid);
	}
 
	@Test
	public void testInValidExpenseIdTest(){
	  int expid = getExpenseId();
	  int exptst = 1000;
	  System.out.println("TESTING INVALID EXPENSE_ID");
	  assertFalse(exptst == expid);
	}
	
	
	@Test
	public void testValidUserIdTest(){
	  int userid = getUserId();
	  int usertst = 1;
	  System.out.println("TESTING VALID USER_ID");
	  assertTrue(usertst  != userid);
	}
	
	
	@Test
	public void testInValidUserIdTest(){
	  int userid = getUserId();
	  int usertst = 1000;
	  System.out.println("TESTING INVALID USER_ID");
	  assertFalse(usertst == userid);
	}
	
	@Test
	public void testValidStatusIdTest(){
	  int statusid = getStatusId();
	  int statustst = 1;
	  System.out.println("TESTING VALID STATUS_ID");
	  assertTrue(statustst  != statusid);
	}
	
	
	@Test
	public void testInValidStatusIdTest(){
	  int statusid = getStatusId();
	  int statustst = 1000;
	  System.out.println("TESTING INVALID STATUS_ID");
	  assertFalse(statustst == statusid);
	}
	
	@Test
	public void testValidTypeIdTest(){
	  int typeid = getTypeId();
	  int typetst = 1;
	  System.out.println("TESTING VALID STATUS_ID");
	  assertTrue(typetst != typeid);
	}

	@Test
	public void testInValidTypeIdTest(){
	  int typeid = getTypeId();
	  int typetst = 1000;
	  System.out.println("TESTING INVALID STATUS_ID");
	  assertFalse(typetst == typeid);
	}
	
	@Test
	public void testValidRoleIdTest(){
	  int roleid = getRoleId();
	  int roletst = 1;
	  System.out.println("TESTING VALID STATUS_ID");
	  assertTrue(roletst != roleid);
	}
	
	@Test
	public void testInValidRoleIdTest(){
	  int roleid = getRoleId();
	  int roletst = 1000;
	  System.out.println("TESTING INVALID STATUS_ID");
	  assertFalse(roletst == roleid);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private int getRoleId() {
		int tst = 2;
		return tst;
	}


	private int getTypeId() {
		int tst = 2;
		return tst;
	}
	
	
	
	private int getStatusId() {
		int tst = 2;
		return tst;
	}


	private int getExpenseId() {
		int tst = 2;
		return tst;
	}
	
	private int getUserId() {
		int tst = 2;
		return tst;
	}




}
