package com.revature.project0.ui;

import java.util.Scanner;

import com.revature.project0.main.LogDriver;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;

public class OpeningScreen implements Screen {

	static int inputChoice;
	
	@Override
	public void render(Scanner conInput, UserService uDao, AccountService aDao) {
		System.out.println(ConsoleColors.BLUE_BRIGHT + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@                 WELCOME TO SAM'S BANK             @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@                                                   @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@             Please Selet an Option Below          @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@                  1. Existing User                 @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@                  2. Create New User               @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		inputChoice = conInput.nextInt();
		conInput.nextLine();
	}
	
	@Override
	public Screen determineNext() {
		Screen nextScreen;
		
		try {
			if (inputChoice == 1) {
				nextScreen = new LoginScreen();
			} else if (inputChoice == 2) {
				nextScreen = new CreationScreen();
			} else {
				throw new IllegalArgumentException("That is not an available option."); 
			}
		}catch (RuntimeException e) {
			LogDriver.log.error(e);
			nextScreen = new OpeningScreen();
		}
		return nextScreen;
	}
	
}
