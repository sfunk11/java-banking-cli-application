package com.revature.project0.ui;

import java.util.Scanner;

import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;

public class EmployeeMenu implements Screen {
	static int inputChoice;

	@Override
	public void render(Scanner conInput, UserService uDao, AccountService aDao) {
		System.out.println(ConsoleColors.CYAN + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@                Employee Menu Options:             @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        1. View Customer Account Information       @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        2. View Customer Personal Information      @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        3. Approve New Account                     @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		inputChoice = conInput.nextInt();
		
	}

	@Override
	public Screen determineNext() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
