package com.revature.project0.ui;

import java.util.Scanner;

import com.revature.project0.models.User;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;

public interface Screen {
	
	User render(Scanner conInput, UserService uDao, AccountService aDao, User currentUser);
	
	Screen determineNext();
}
