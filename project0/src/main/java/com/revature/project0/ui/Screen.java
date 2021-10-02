package com.revature.project0.ui;

import java.util.Scanner;

import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;

public interface Screen {
	
	void render(Scanner conInput, UserService uDao, AccountService aDao);
	
	Screen determineNext();
}
