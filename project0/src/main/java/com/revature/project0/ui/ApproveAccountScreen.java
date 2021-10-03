package com.revature.project0.ui;

import java.util.List;
import java.util.Scanner;

import com.revature.project0.models.Account;
import com.revature.project0.models.User;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;

public class ApproveAccountScreen implements Screen {
	
	private List<Account> pending;
	private String another;
	
	
	@Override
	public User render(Scanner conInput, UserService uDao, AccountService aDao, User currentUser) {
		currentUser = null;
		System.out.println(ConsoleColors.YELLOW + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@        Please Select an Account to Approve:       @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		pending = aDao.listPendingAccounts();
		int choice = conInput.nextInt();
		conInput.nextLine();
		aDao.approveAccount(choice);
		
		System.out.println("Would you like to approve another account?");
		another = conInput.nextLine();
		if(another.toLowerCase().charAt(0)== 'y') {
			render(conInput, uDao, aDao, currentUser);
		}
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
