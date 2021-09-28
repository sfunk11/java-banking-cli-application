package com.revature.project0.main;

import org.apache.log4j.Logger;

public class LogHelper {

	
	public final Logger log2 = Logger.getLogger(LogHelper.class);
	
	private int myData;
	
	public void callStaticLogger() {
		if (myData == 0) {
			
		LogDriver.log.warn("myData variable is: " + myData);
		}
	}
	
	public void callInstanceLogger() {
		
		this.myData = 42;
		log2.debug("My data variable is: " + myData);
	}
	
	public static void main(String[] args) {
		
	}

}
