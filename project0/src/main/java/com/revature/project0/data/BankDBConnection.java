package com.revature.project0.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankDBConnection {

	

		// this utility class is to create connections to our db, to help eliminate repeated code. it will also make it more 
		// testable.
		
		private static final String URL = "jdbc:postgresql://revature-2109-java.cmeofp2uiqe0.us-east-2.rds.amazonaws.com:5432/bankdb";
		private static final String USERNAME = "bankuser";
		private static final String PASSWORD = "P4ssw0rd";
		
		public Connection getDBConnection() throws SQLException {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
	}

