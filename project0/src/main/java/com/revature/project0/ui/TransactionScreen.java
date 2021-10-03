package com.revature.project0.ui;

import java.util.List;
import java.util.Scanner;

import com.revature.project0.models.Account;
import com.revature.project0.models.User;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;

public class TransactionScreen implements Screen {
	private User user;
	private int choice;
	private String choice2;
	private int accountID;
	private List<Account> accountList;
	private Account currentAccount;
	private double amount;
	
	@Override
	public User render(Scanner conInput, UserService uDao, AccountService aDao, User currentUser) {
		user = currentUser;
		System.out.println(ConsoleColors.GREEN + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@            Please Select an Option Below          @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               1. Deposit                          @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               2. Withdrawal                       @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               3. Transfer Between My Accounts     @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		choice = conInput.nextInt();
		conInput.nextLine();
		accountList = aDao.displayListAccountsByOwner(currentUser.getUsername());

		switch (choice) {
		case 1:
			if(accountList.size() >= 1) {
				System.out.println( "Which account would you like to deposit to? Please enter the number:");
				accountID = conInput.nextInt();
				conInput.nextLine();
				for (int i = 0; i < accountList.size(); i++) {
					if (accountList.get(i).getAccountID() == accountID) {
						currentAccount = accountList.get(i);
						break;
					}
				}
			} else {
				currentAccount = accountList.get(0);
			}
			System.out.println( "How much would you like to deposit? (ie 500.00):");
			amount = conInput.nextDouble();
			conInput.nextLine();
			aDao.deposit(currentAccount, amount);
			break;
		case 2: 
			if(accountList.size() == 1) {
				System.out.println( "Which account would you like to withdraw from? Please enter the number:");
				accountID = conInput.nextInt();
				conInput.nextLine();
				for (int i = 0; i < accountList.size(); i++) {
					if (accountList.get(i).getAccountID() == accountID) {
						currentAccount = accountList.get(i);
						break;
					}
				}
			} else {
				currentAccount = accountList.get(0);
			}
			System.out.println( "How much would you like to withdraw? (ie 500.00):");
			amount = conInput.nextDouble();
			conInput.nextLine();
			aDao.withdraw(currentAccount, amount);
			break;
		case 3:
			
			System.out.println( "Which account would you like to transfer from? Please enter the number:");
			accountID = conInput.nextInt();
			conInput.nextLine();
			Account from = null;
			Account to = null;
			for (int i = 0; i < accountList.size(); i++) {
				if (accountList.get(i).getAccountID() == accountID) {
					from = accountList.get(i);
					break;
				}
			}
			System.out.println("Which account would you like to transfer to?");
			accountID = conInput.nextInt();
			conInput.nextLine();
			for (int i = 0; i < accountList.size(); i++) {
				if (accountList.get(i).getAccountID() == accountID) {
					to = accountList.get(i);
					break;
				}
			}
			System.out.println( "How much would you like to transfer? (ie 500.00):");
			double amount = conInput.nextDouble();
			conInput.nextLine();
			aDao.transfer(from, to, amount);
			System.out.println("Thank you for your transfer. Here are your account balances:" );
			aDao.displayListAccountsByOwner(user.getUsername());
			break;
		default:
			System.out.println("That is not an available option. Please choose from the list.");
			render(conInput,uDao,aDao,currentUser);
		}
		
		System.out.println("Would you like to do anything else?");
		choice2 = conInput.nextLine();
		return user;
	}

	@Override
	public Screen determineNext() {

		Screen nextScreen = null;
		
		if(choice2.toLowerCase().charAt(0) == 'y' ) {
			nextScreen = new MainMenu();
		}

		return nextScreen;
	}
	
	
		
			
	
		
}
	
	
	


