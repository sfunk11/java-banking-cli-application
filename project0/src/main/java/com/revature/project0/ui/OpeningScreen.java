package com.revature.project0.ui;

import java.util.Scanner;

public class OpeningScreen implements Screen {

	static int inputChoice;
	
	@Override
	public void render(Scanner conInput) {
		System.out.println(ConsoleColors.BLUE_BRIGHT + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@                 WELCOME TO SAM'S BANK             @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@                                                   @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@             Please Selet an Option Below          @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@                  1. Existing User                 @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@                  2. Create New User               @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		inputChoice = conInput.nextInt();
		determineNext(conInput, inputChoice);
	}
	
	@Override
	public void determineNext(Scanner conInput, int choice) {
		if (choice == 1) {
			//go to LoginScreen
		} else if (choice == 2) {
			//go to User Creation Screen
		} else {
			//throw exception and ask to re-enter selection
		}
	}

}
