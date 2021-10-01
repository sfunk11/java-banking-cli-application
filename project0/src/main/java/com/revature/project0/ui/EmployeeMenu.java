package com.revature.project0.ui;

import java.util.Scanner;

public class EmployeeMenu implements Screen {
	static int inputChoice;

	@Override
	public void render(Scanner conInput) {
		System.out.println(ConsoleColors.CYAN + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@                Employee Menu Options:             @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        1. View Customer Account Information       @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        2. View Customer Personal Information      @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        3. Approve New Account                     @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		inputChoice = conInput.nextInt();
		determineNext(conInput, inputChoice);
	}
	
	@Override
	public void determineNext(Scanner conInput, int choice) {
		if (choice == 1) {
			//go to view account options
		} else if (choice == 2) {
			//go to view customer info options
		} else if (choice ==3) {
			//go to account approval
		} else {
			//throw exception and ask to re-enter selection
		}
	}

}
