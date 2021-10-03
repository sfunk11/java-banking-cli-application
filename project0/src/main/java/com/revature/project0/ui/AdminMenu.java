package com.revature.project0.ui;

import java.util.Scanner;

import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;
import com.revature.project0.models.User;

public class AdminMenu implements Screen {

	private int choice;
	private User user;
	
	

	@Override
	public User render(Scanner conInput, UserService uDao, AccountService aDao, User currentUser) {
		System.out.println(ConsoleColors.RED + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@            Administrator Menu Options:            @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        1. View/Edit Customer Information          @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        2. Transactions on Customer Account        @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        3. Approve New Customer Account            @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        4. Close Customer Account                  @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		choice = conInput.nextInt();
		
		return user;
	}
	
	@Override
	public Screen determineNext() {
		
		Screen nextScreen = new AdminMenu();
		try {
		switch (choice) {
			case 1:
				//go to view / edit information window 
				break;
			case 2: 
				//go to transaction menu (collect cust account info first)
				break;
			case 3:
				//go to account approval
				break;
			case 4:
				//go to account close
				break;
			default:
				//throw input not valid exception and show menu again;
		}
		}catch (Exception e) {
			nextScreen = new AdminMenu();
		}
		return nextScreen;
	}


}


