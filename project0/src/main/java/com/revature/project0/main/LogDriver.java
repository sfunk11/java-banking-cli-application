package com.revature.project0.main;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogDriver {

	public static final Logger log = Logger.getLogger(LogDriver.class);

	public static void main(String[] args) {
		log.setLevel(Level.INFO);
		
	}

}
