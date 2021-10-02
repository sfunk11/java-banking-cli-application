package com.revature.project0.ui;

import java.util.Scanner;

import com.revature.project0.models.User;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;

public class LoginScreen implements Screen {
	
	static String inputUsername;
	static String inputPassword;
	static boolean loogedIn = false;
	private User user;
	

	@Override
	public void render(Scanner conInput, UserService uDao, AccountService aDao) {
		System.out.println(ConsoleColors.BLUE + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@                   Please Log In                   @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		System.out.println( "Enter your username:");
		inputUsername = conInput.nextLine();
		System.out.println("Enter your password:");
		inputPassword = conInput.nextLine();
		user = uDao.logIn(inputUsername, inputPassword);
		if(user != null) {
			System.out.println("Welcome back, "+ user.getFirstName() + "!");
		} else {
			System.out.println("There was an error logging you in.");
		}
		
	}

	@Override
	public Screen determineNext() {
		Screen nextScreen = new LoginScreen();
		
		if (user == null) {
			return nextScreen;
		}
		if (user.isAdmin()) {
			nextScreen = new AdminMenu();
		} else if (user.isEmployee()) {
			nextScreen = new EmployeeMenu();
		} else {
			nextScreen = new MainMenu();
		}
		return nextScreen;
	}

	
	
 
}



