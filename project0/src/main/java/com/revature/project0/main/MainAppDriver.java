package com.revature.project0.main;

import com.revature.project0.data.BankDBConnection;
import com.revature.project0.data.UserDaoImpl;


public class MainAppDriver {

	public static boolean isRunning = true;
	
	public static void main(String[] args) {
		
//		Scanner conInput = new Scanner(System.in);
//		
//		Screen presentScreen = new OpeningScreen();
//		
//		presentScreen.render(conInput);
//		presentScreen = new LoginScreen();
//		presentScreen.render(conInput);
//		presentScreen = new EmployeeMenu();
//		presentScreen.render(conInput);	
	
	BankDBConnection dbcon = new BankDBConnection();
	UserDaoImpl uDao = new UserDaoImpl(dbcon);
	System.out.println(uDao.getAll());
	System.out.println(uDao.getByUsername("sfunk"));
	
	
	}
	

}
