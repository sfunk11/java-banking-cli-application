package com.revature.project0.gui;

import java.util.Scanner;

public class OpeningScreen implements Screen {

	@Override
	public void render(Scanner conInput) {
		System.out.println(ConsoleColors.PURPLE + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@                 WELCOME TO SAM'S BANK             @@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ConsoleColors.RESET);
	}

}
