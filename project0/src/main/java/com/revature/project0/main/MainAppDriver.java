package com.revature.project0.main;

import java.util.Scanner;

import com.revature.project0.ui.*;


public class MainAppDriver {

	public static boolean isRunning = true;
	
	public static void main(String[] args) {
		
		Scanner conInput = new Scanner(System.in);
		
		Screen presentScreen = new OpeningScreen();
		
		presentScreen.render(conInput);
		presentScreen = new LoginScreen();
		presentScreen.render(conInput);
//		presentScreen = new EmployeeMenu();
//		presentScreen.render(conInput);	
	}
	

}
