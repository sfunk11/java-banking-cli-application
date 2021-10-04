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
	private String open = "no";
	private int accountID;
	private List<Account> accountList;
	private Account currentAccount;
	private double amount;
	
	@Override
	public User render(Scanner conInput, UserService uDao, AccountService aDao, User currentUser) {
		user = currentUser;
		System.out.println(ConsoleColors.PURPLE + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@            Please Select an Option Below          @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               1. Deposit                          @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               2. Withdrawal                       @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               3. Transfer Between My Accounts     @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		choice = conInput.nextInt();
		conInput.nextLine();
		accountList = aDao.displayListAccountsByOwner(currentUser.getUsername());
		if (accountList == null) {
			System.out.println("You don't currently have any accounts. Would you like to open a new one?");
			open = conInput.nextLine();
			
		}else {
		
		switch (choice) {
		case 1:
			
			if(accountList.size() >= 1) {
				System.out.println( "Which account would you like to deposit to? Please enter the number:");
				accountID = conInput.nextInt();
				conInput.nextLine();
				currentAccount = validateAccountNumber(accountList, accountID, conInput);
				if (currentAccount == null) {
					break;
				}
			} else {
				currentAccount = accountList.get(0);
			}
			System.out.println( "How much would you like to deposit? (ie 500.00):");
			amount = conInput.nextDouble();
			conInput.nextLine();
			validateAmount(amount, conInput);
			if (amount < 0.01) {
				break;
			}
			aDao.deposit(currentAccount, amount);
			break;
		case 2: 
			
			if(accountList.size() >= 1) {
				System.out.println( "Which account would you like to withdraw from? Please enter the number:");
				accountID = conInput.nextInt();
				conInput.nextLine();
				currentAccount = validateAccountNumber(accountList, accountID, conInput);
				if (currentAccount == null) {
					break;
				}
			} else {
				currentAccount = accountList.get(0);
			}
			System.out.println( "How much would you like to withdraw? (ie 500.00):");
			amount = conInput.nextDouble();
			conInput.nextLine();
			amount = validateAmount(amount, conInput);
			if (amount < 0.01) {
				break;
			}
			aDao.withdraw(currentAccount, amount);
			break;
		case 3:
			
			System.out.println( "Which account would you like to transfer from? Please enter the number:");
			accountID = conInput.nextInt();
			conInput.nextLine();
			Account from = null;
			Account to = null;
			
			from = validateAccountNumber(accountList, accountID, conInput);
			if (from == null) {
				break;
			}
			System.out.println("Which account would you like to transfer to?");
			accountID = conInput.nextInt();
			conInput.nextLine();
			to = validateAccountNumber(accountList, accountID, conInput);
			if (to == null) {
				break;
			}
			System.out.println( "How much would you like to transfer? (ie 500.00):");
			double amount = conInput.nextDouble();
			conInput.nextLine();
			validateAmount(amount, conInput);
			if (amount < 0.01) {
				break;
			}
			aDao.transfer(from, to, amount, user);
			break;
		default:
			System.out.println("That is not an available option. Please choose from the list.");
			render(conInput,uDao,aDao,currentUser);
		}
		
		System.out.println("Would you like to do anything else?");
		choice2 = conInput.nextLine();
		}
		return user;
	
	}

	@Override
	public Screen determineNext() {

		Screen nextScreen = null;
		
		if(open.toLowerCase().charAt(0) == 'y' ) {
			nextScreen = new AccountCreation();
			return nextScreen;
		}
		if(choice2.toLowerCase().charAt(0) == 'y' ) {
			nextScreen = new MainMenu();
		}

		return nextScreen;
	}
	
	
		public double validateAmount(double amount, Scanner conInput) {
			int tries = 0;
			
			while (amount < 0.01 && tries <2) {
				System.out.println("Please enter a positive number only. Let's try again:");
				amount = conInput.nextDouble();
				conInput.nextLine();
				tries ++;
			}
			return amount;
		}
			
		public Account validateAccountNumber(List<Account> a, int acctNum, Scanner conInput) {
			int tries = 0;
			Account b = null;
			
			while (b == null && tries < 2) {
				for (int i = 0; i < a.size(); i++) {
					if (a.get(i).getAccountID() == acctNum) {
						b = accountList.get(i);
					}
				}
				if (b == null) {
					System.out.println("That is not one of your account numbers.  Please try again");
					acctNum = conInput.nextInt();
					conInput.nextLine();
				}
				tries ++;
			}
		 return b;
		}
}
	
	
	


