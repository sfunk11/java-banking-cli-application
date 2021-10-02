package com.revature.project0.main;

import java.util.Scanner;

import com.revature.project0.data.AccountDaoImpl;
import com.revature.project0.data.BankDBConnection;
import com.revature.project0.data.UserDaoImpl;
import com.revature.project0.models.User;
import com.revature.project0.services.AccountService;
import com.revature.project0.services.UserService;
import com.revature.project0.ui.OpeningScreen;
import com.revature.project0.ui.Screen;


public class MainAppDriver {

	public static boolean isRunning = true;
	
	public static void main(String[] args) {
		
		BankDBConnection bankCon = new BankDBConnection();
		Scanner conInput = new Scanner(System.in);
		UserDaoImpl uDao = new UserDaoImpl(bankCon);
		UserService uServ = new UserService(uDao);
		AccountDaoImpl aDao = new AccountDaoImpl(bankCon);
		AccountService aServ = new AccountService(aDao);
		
		
		Screen presentScreen = new OpeningScreen();
		
		User test = new User("John", "Smith", "jsmith", "password");
		
		
		System.out.println(uDao.getAll());
		uDao.insert(test);
		
//		while(presentScreen != null) {
//		presentScreen.render(conInput, uServ, aServ);
//		presentScreen = presentScreen.determineNext();
//		}
	
	
	}
	

}
