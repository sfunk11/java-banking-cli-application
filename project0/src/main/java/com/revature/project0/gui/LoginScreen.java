package com.revature.project0.gui;

import java.util.Scanner;

public class LoginScreen implements Screen {
	
	static String inputEmail;
	static String inputPassword;
	static boolean loogedIn = false;
	boolean isEmployee;
	boolean isAdmin;

	@Override
	public void render(Scanner conInput) {
		System.out.println(ConsoleColors.PURPLE + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@                       Log In                      @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		System.out.println(ConsoleColors.BLUE + " Please enter your email:");
		inputEmail = conInput.nextLine();
		System.out.println(ConsoleColors.BLUE + " Please enter your password:");
		inputPassword = conInput.nextLine();
		
		//method call to validate password
		determineMenu(conInput); //if logged in only. otherwise password incorrect exception
	}

	public void determineMenu(Scanner conInput) {
		if (isAdmin) {
			//go to admin menu
		} else if (isEmployee) {
			//go to employee menu
		} else {
			//go to main menu
		}
	}
}
