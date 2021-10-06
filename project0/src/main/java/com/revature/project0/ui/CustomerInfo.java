package com.revature.project0.ui;

import java.util.Scanner;

import com.revature.project0.models.User;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;

public class CustomerInfo implements Screen {

	private User user;
	private int choice;
	private String choice2;
	
	@Override
	public User render(Scanner conInput, UserService uDao, AccountService aDao, User currentUser) {
		user = currentUser;
		System.out.println(ConsoleColors.PURPLE + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@             What would you like to Change?        @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               1. Email Address                    @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               2. Password                         @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               3. No Changes / Go Back             @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		uDao.displayInfo(currentUser);
		choice = conInput.nextInt();
		conInput.nextLine();
		user = currentUser;
		switch (choice) {
		case 1:
			System.out.println("Please enter the email address you would like to use:");
			String newEmail = conInput.nextLine();
			user = uDao.updateEmail(user,  newEmail);
			break;
		case 2:
			System.out.println("Please enter your new password: ");
			String newPassword = conInput.nextLine();
			user.setPassword(newPassword);
			user = uDao.updateUser(user);
			break;
		case 3:
			break;
		default:
			System.out.println("Other fields can only be changed by a bank adminstrator.");
			break;
		}
		uDao.displayInfo(user);
		System.out.println("Would you like to do anything else?");
		choice2 = conInput.nextLine();
		return user;
	}

	@Override
	public Screen determineNext() {

		Screen nextScreen = null;
		if(choice2.toLowerCase().charAt(0) == 'y' || choice == 3 ) {
			nextScreen = new MainMenu();
		}

		return nextScreen;
	}
	
	
}
