package com.revature.project0.ui;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginScreen implements Screen {
	
	static String inputEmail;
	static String inputPassword;
	static boolean loogedIn = false;
	boolean isEmployee;
	boolean isAdmin;

	@Override
	public void render(Scanner conInput) {
		System.out.println(ConsoleColors.BLUE + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@                   Please Log In                   @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		System.out.println( "Enter your email:");
		inputEmail = conInput.nextLine();
		if (validateEmail(inputEmail)) {
			System.out.println("Enter your password:");
			inputPassword = conInput.nextLine();
		} else {
			// throws exception "Not a valid email"
		}
		
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

	public boolean validateEmail(String inputEmail) {
		
	String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	
	Pattern pattern = Pattern.compile(regex);
	Matcher matcher = pattern.matcher(inputEmail);
		
		return matcher.matches();
	}
	

}



