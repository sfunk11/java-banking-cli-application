package com.revature.project0.gui;

import java.util.Scanner;

public interface Screen {
	
	void render(Scanner conInput);
	
	public default void determineNext(Scanner conInput, int choice) {
	}
}
