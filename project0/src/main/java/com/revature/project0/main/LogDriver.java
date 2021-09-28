package com.revature.project0.main;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogDriver {

	public static final Logger log = Logger.getLogger(LogDriver.class);

	public static void main(String[] args) {
		log.setLevel(Level.DEBUG);
		
		log.trace("Ray Tracing");  //This is a message being recorded at a trace level
		log.debug("Squishing bugs"); //This message is being recorded at debug level
		log.info("It is server information"); //This message is logged at the info level
		log.warn("It's dangerous to go alone. Take this");//warn level
		log.error("that's a big no no"); 
		log.fatal("Pineapple belongs on pizza");
		
		LogHelper lHelp = new LogHelper();
		lHelp.callStaticLogger();
		lHelp.callInstanceLogger();
	}

}
