package com.revature.models;

import java.util.List;
import java.util.Scanner;
 
public class Menu {
 
	
	public void display() {
		
		boolean displayMenu = true; //this toggles whether the menu continues after user input
		Scanner scan = new Scanner(System.in); //Scanner object to parse user input		
		 
		System.out.println("*====================================================*");
		System.out.println("Expense Reimbursement Menu");
		System.out.println("*====================================================*");
		
		
		//display the menu options as long as displayMenu is true
		
		while(displayMenu) {
			
			System.out.println("----------------");
			System.out.println("CHOOSE AN OPTION");
			System.out.println("----------------");
			
			
			System.out.println("  ");
			System.out.println(" ");
			System.out.println("  ");
			System.out.println("1. Submit a new expense reimbursement ticket");
			System.out.println("2. View an old expense reimbursement ticket ");
			System.out.println("3. Approve/Disapprove expense reimbursement ticket (FINANCE MANAGER ONLY)");
			System.out.println("4. Exit system");
			System.out.println("  ");
			System.out.print("Input the number of your selection ---> ");
		
			 
		
			String input = scan.nextLine().toLowerCase();
			
			switch(input) {
			
			case "1":{  // submit a new expense ticket
				int roleId = scan.nextInt();
				scan.nextLine();
				System.out.println("  ");
				 
				System.out.println("  ");
				System.out.print("Enter Reimbursement Amount --> ");
				double reimb_amount = scan.nextDouble();
				scan.nextLine();
				 
				System.out.println("  ");
				System.out.println("What is expense for");
				System.out.println("  ");
				System.out.println("1. Technical support");
				System.out.println("2. Software installation");
				System.out.println("3. Relocation");
				System.out.println("4. Sales expense");
				System.out.println("  ");
				System.out.print("Input the number --> ");
				int descrId = scan.nextInt();
				scan.nextLine();  
				String descriptionId = " ";
				if(descrId == 1) {
					descriptionId = "Technical support";
				}else if(descrId == 2) {
					descriptionId = "Software installation";
				}else if(descrId == 3) {
					descriptionId = "Relocation";
				}else {
					descriptionId = "Sales Expense";
				}
				System.out.println("  ");
				System.out.println("  ");
				System.out.println("Type of Expense");
				System.out.println("  ");
				System.out.println("1. Food");
				System.out.println("2. Airfare");
				System.out.println("3. Lodging");
				System.out.println("4. Transportation");
				System.out.println("5. Other");
				System.out.println("  ");
				System.out.print("Input the number --> ");
				int typeId = scan.nextInt();
				scan.nextLine(); 
				System.out.println("  ");
				int reimb_author = 1; // need to get id in future
				int reimb_resolver = 1; // finance manager is hard coded to 1.
				int status_id = 1;
				//Given all this information, we'll create a new Expense object to send to a DAO method
				//This is using the all-args minus reimb_id constructor
				Expense newExpense = new Expense(reimb_amount,"placeholder","placeholder",descriptionId,reimb_author,reimb_resolver,status_id,typeId); 
				 	
				break;
				
				
			}
			case "2":{ // review an old expense ticket
				
				System.out.println("  ");
				System.out.println("  ");
				System.out.println("Which reimbursement ticket would you like to view? ");
				System.out.println("  ");
				System.out.print("Input the number --> ");
				int rticketInput = scan.nextInt();
				scan.nextLine();
				
				System.out.println("  ");				 
				System.out.println("--------------------------------------------------------");
				System.out.println("  ");
				break;
				
				
			}
			
			case "3":{ // approve/disapprove  old expense ticket
				//  must check to see if you are the finance manager
				
				
				System.out.println("  ");
				System.out.println("  ");
				System.out.println("Collecting Expense Tickets");
				System.out.println("  ");
				System.out.println("------------------------------------");			
				System.out.println("  ");
				System.out.println("  ");
				System.out.println("Which reimbursement ticket would you like to view? ");
				System.out.println("  ");
				System.out.print("Input the number --> ");
				int rticketInput = scan.nextInt();
				scan.nextLine();				
				System.out.println("  ");
				System.out.println("  ");
				break;
				
				
			}
			
			
			
			}
			
			
		}
		
		
		
		
	}
	

}
