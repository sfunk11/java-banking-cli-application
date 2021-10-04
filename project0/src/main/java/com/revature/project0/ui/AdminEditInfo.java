package com.revature.project0.ui;

import java.util.Scanner;

import com.revature.project0.models.User;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;

public class AdminEditInfo implements Screen {

	private User user;
	private int choice;
	private String choice2;
	
	@Override
	public User render(Scanner conInput, UserService uDao, AccountService aDao, User currentUser) {
		user = currentUser;
		System.out.println(ConsoleColors.YELLOW + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@             What would you like to Change?        @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               1. Email Address                    @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               2. Password                         @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               3. First Name                       @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               4. Last Name                        @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               5. Username                         @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               6. Mark as Employee                 @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               7. Mark as Admin                    @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               8. Delete User                      @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@               9. Return to Admin Menu             @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
		uDao.displayInfo(currentUser);
		choice = conInput.nextInt();
		conInput.nextLine();
		user = currentUser;
		switch (choice) {
		case 1:
			System.out.println("Please enter the customer's email address:");
			String newEmail = conInput.nextLine();
			user = uDao.updateEmail(user,  newEmail);
			break;
		case 2:
			System.out.println("Please enter the customer's new password: ");
			String newPassword = conInput.nextLine();
			user.setPassword(newPassword);
			user = uDao.updateUser(user);
			break;
		case 3:
			System.out.println("Please enter the customer's new first name: ");
			String newfFirst = conInput.nextLine();
			user.setFirstName(newfFirst);
			user = uDao.updateUser(user);
			break;
		case 4:
			System.out.println("Please enter the customer's new last name: ");
			String newLast = conInput.nextLine();
			user.setLastName(newLast);
			user = uDao.updateUser(user);
			break;
		case 5:
			System.out.println("Please enter the customer's new username: ");
			String newUsername = conInput.nextLine();
			user.setUsername(newUsername);
			user = uDao.updateUser(user);
			break;
		case 6:
			user.setEmployee(true);
			user = uDao.updateUser(user);
			break;
		case 7:
			user.setAdmin(true);
			user = uDao.updateUser(user);
			break;
		case 8:
			uDao.removeUser(user);
			user = null;
			break;
		case 9: 
			break;
		default:
			System.out.println("Other fields can only be changed by a bank adminstrator.");
			break;
		}
		uDao.displayInfo(user);
		System.out.println("Would you like to do anything else?");
		choice2 = conInput.nextLine();
		return user;
	}

	@Override
	public Screen determineNext() {

		Screen nextScreen = null;
		if(choice == 9) {
			nextScreen = new AdminMenu();
			return nextScreen;
		}
		if(choice2.toLowerCase().charAt(0) == 'y' ) {
			nextScreen = new AdminMenu();
		}

		return nextScreen;
	}

}
