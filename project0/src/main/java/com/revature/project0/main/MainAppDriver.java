package com.revature.project0.main;

import java.util.Scanner;

import com.revature.project0.data.AccountDaoImpl;
import com.revature.project0.data.UserDaoImpl;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;
import com.revature.project0.ui.EmployeeMenu;
import com.revature.project0.ui.LoginScreen;
import com.revature.project0.ui.OpeningScreen;
import com.revature.project0.ui.Screen;


public class MainAppDriver {

	public static boolean isRunning = true;
	
	public static void main(String[] args) {
		
		Scanner conInput = new Scanner(System.in);
		UserDaoImpl uDao = new UserDaoImpl();
		UserService uServ = new UserService(uDao);
		AccountDaoImpl aDao = new AccountDaoImpl();
		AccountService aServ = new AccountService(aDao);
		
		
		Screen presentScreen = new OpeningScreen();
		
		presentScreen.render(conInput, uServ, aServ);
		presentScreen = new LoginScreen();
		presentScreen.render(conInput, uServ, aServ);	
		presentScreen.determineNext();
	
	
	}
	

}
