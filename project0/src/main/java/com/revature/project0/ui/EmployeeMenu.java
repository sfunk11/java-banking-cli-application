package com.revature.project0.ui;

import java.util.List;
import java.util.Scanner;

import com.revature.project0.models.User;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;

public class EmployeeMenu implements Screen {
	private String another;
	private UserService uServ;
	private List<User> customerList;
	private Scanner cs;
	private User customer;
	private int choice;

	@Override
	public User render(Scanner conInput, UserService uDao, AccountService aDao, User currentUser) {
		
		cs = conInput;
		uServ = uDao;
	
		System.out.println(ConsoleColors.CYAN + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@                Employee Menu Options:             @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        1. View Customer Account Information       @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        2. View Customer Personal Information      @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        3. Approve New Account                     @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        4. Logout                                  @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		choice  = conInput.nextInt();
		conInput.nextLine();
		
		switch (choice) {
		case 1:
			chooseCustomer();
			uServ.displayInfo(customer);
			System.out.println("Would you like to do anything else?");
			another = conInput.nextLine();
			break;
		case 2:
			chooseCustomer();
			aDao.displayListAccountsByOwner(customer.getUsername());
			System.out.println("Would you like to do anything else?");
			another = conInput.nextLine();
			break;
		case 3:
			break;
		case 4:
			break;
		default:
			System.out.println("That is not an available option. Please choose from the list.");
			render(cs, uServ, aDao, currentUser);
		}
		
		
		return customer;
	}

	@Override
	public Screen determineNext() {
		
		Screen nextScreen = null;
		
		if (choice == 3) {
			nextScreen = new ApproveAccountScreen();
		} else if (choice == 4) {
			nextScreen = new LoginScreen();
		}else if ((another.toLowerCase().charAt(0) == 'y' )) {
			nextScreen = new EmployeeMenu();
		}
			
		return nextScreen;
	}
	
	public void chooseCustomer() {
		System.out.println("Please choose a customer: ");
		customerList = uServ.listAllCustomers();
		int custChoice = cs.nextInt();
		cs.nextLine();
		customer = customerList.get(custChoice);
	}
	

}
