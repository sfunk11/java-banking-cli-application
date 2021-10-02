package com.revature.project0.ui;

import java.util.Scanner;

import com.revature.project0.models.User;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;

public class CreationScreen implements Screen {

	private String fullName;
	private String username;
	private String password;
	private User newUser;
	private String choice;
	
	
	
	@Override
	public void render(Scanner conInput, UserService uDao, AccountService aDao) {
		System.out.println(ConsoleColors.CYAN + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@            Welcome to the User Creator            @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		System.out.println("Please enter your first and last name (ie - John Smith:");
		fullName = conInput.nextLine();
		System.out.println("Please enter a username:");
		username = conInput.nextLine();
		System.out.println("Please enter a password:");
		password = conInput.nextLine();
		newUser = uDao.createUser(prepareUser(fullName, username, password));
		System.out.println("Would you like to do anything else?");
		choice = conInput.nextLine();
	}

	@Override
	public Screen determineNext() {
		
		Screen nextScreen = null;
		
		if(choice.toLowerCase().charAt(0) == 'y' ) {
			nextScreen = new LoginScreen();
		}

		return nextScreen;
	}

	public User prepareUser(String fullName, String username, String password) {
		
		String[] name = fullName.split(" ");
		
		User user = new User (name[0].trim(), name[1].trim(), username.trim(), password.trim());
		
		return user;
	}
	
}
