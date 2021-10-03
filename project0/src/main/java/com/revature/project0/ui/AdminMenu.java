package com.revature.project0.ui;

import java.util.List;
import java.util.Scanner;

import com.revature.project0.models.User;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;

public class AdminMenu implements Screen {

	private int menuChoice;
	private User user;
	private User customer;
	private List<User> customerList;
	private UserService uServ;
	private Scanner cs;
	

	@Override
	public User render(Scanner conInput, UserService uDao, AccountService aDao, User currentUser) {
		
		user = currentUser;
		uServ = uDao;
		cs = conInput;
		
		System.out.println(ConsoleColors.RED + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@            Administrator Menu Options:            @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        1. View/Edit Customer Information          @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        2. Transactions on Customer Account        @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        3. Approve New Customer Account            @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        4. Close Customer Account                  @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        5. Logout                                  @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		menuChoice = cs.nextInt();
		cs.nextLine();
		if (menuChoice == 1 || menuChoice == 2 || menuChoice == 4) {
			chooseCustomer();
			return customer;
		}
		return user;
	}
	
	@Override
	public Screen determineNext() {
		
		Screen nextScreen = new AdminMenu();
		switch (menuChoice) {
			case 1:
				nextScreen = new AdminEditInfo();
				break;
			case 2: 
				nextScreen = new TransactionScreen();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				nextScreen = new LoginScreen();
				break;
			default:
				System.out.println("That is not an available choice. Please choose from the list");
				nextScreen = new AdminMenu();
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


