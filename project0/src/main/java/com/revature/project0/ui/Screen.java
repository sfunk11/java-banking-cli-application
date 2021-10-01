package com.revature.project0.ui;

import java.util.Scanner;

public interface Screen {
	
	void render(Scanner conInput);
	
	public default void determineNext(Scanner conInput, int choice) {
	}
}
