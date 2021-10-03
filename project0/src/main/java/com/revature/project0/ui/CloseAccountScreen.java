package com.revature.project0.ui;

import java.util.List;
import java.util.Scanner;

import com.revature.project0.models.Account;
import com.revature.project0.models.User;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;

public class CloseAccountScreen implements Screen {

	private List<Account> accountList;
	private String another;
	
	@Override
	public User render(Scanner conInput, UserService uDao, AccountService aDao, User currentUser) {
		
		System.out.println(ConsoleColors.YELLOW + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@         Please Select the Account to Close:       @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		accountList = aDao.displayListAccountsByOwner(currentUser.getUsername());
		int choice = conInput.nextInt();
		conInput.nextLine();
		aDao.closeAccount(choice);
		System.out.println("Would you like to do anything else?");
		another = conInput.nextLine();
		return currentUser;
	}

	@Override
	public Screen determineNext() {

		Screen nextScreen = null;
		if(another.toLowerCase().charAt(0) == 'y' ) {
			nextScreen = new AdminMenu();
		}

		return nextScreen;
	}
		
}		
	
