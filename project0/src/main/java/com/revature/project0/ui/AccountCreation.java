package com.revature.project0.ui;

import java.util.List;
import java.util.Scanner;

import com.revature.project0.models.Account;
import com.revature.project0.models.User;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;

public class AccountCreation implements Screen {
	
	private String accountType;
	private String jointOwner;
	private double newBalance;
	private List<Account> accountList;
	private User user;
	private String choice;
	
	@Override
	public User render(Scanner conInput, UserService uDao, AccountService aDao, User currentUser) {
		user = currentUser;
		System.out.println(ConsoleColors.CYAN + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@                  Account Creation                 @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		System.out.println("Is this going to be a joint account? ");
		accountType = conInput.nextLine();
		if (accountType.toLowerCase().charAt(0) == 'y') {
			// Add Logic here for joint account creation
		}
		System.out.println("How much would you like to deposit to start your new account?");
		newBalance = conInput.nextDouble();
		conInput.nextLine();
		Account newAccount = new Account();
		newAccount.setBalance(newBalance);
		accountList = aDao.createIndividualAccount(newAccount, user);
		System.out.println(ConsoleColors.RED_BRIGHT + "All new accounts are pending until approved by a bank administrator." + ConsoleColors.RESET);
		System.out.println("Would you like to do anything else?");
		choice = conInput.nextLine();
		return user;
	}

	@Override
	public Screen determineNext() {
		
		Screen nextScreen = null;
		
		if(choice.toLowerCase().charAt(0) == 'y' ) {
			nextScreen = new MainMenu();
		}

		return nextScreen;
	}

}
