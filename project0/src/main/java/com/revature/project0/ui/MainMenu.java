package com.revature.project0.ui;

import java.util.Scanner;

import com.revature.project0.models.User;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;

public class MainMenu implements Screen {

	private User user;
	private int choice;
	
	@Override
	public User render(Scanner conInput, UserService uDao, AccountService aDao, User currentUser) {
		user = currentUser;
		System.out.println(ConsoleColors.GREEN + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@             Please Select an Option Below         @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               1. Change my personal info          @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               2. Go to My Open Accounts           @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               3. Open a New Account               @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		choice = conInput.nextInt();
		conInput.nextLine();
		
		
		return user;
		
	}

	@Override
	public Screen determineNext() {
		
		Screen next = new MainMenu();
		
			switch (choice) {
				case 1:
					next = new CustomerInfo();
					break;
				case 2: 
					next = new TransactionScreen();
					break;
				case 3:
					next = new AccountCreation();
					break;
				default:
					System.out.println("That is not an available option. Please choose from the menu.");
			}
		
			return next;
		}


}
