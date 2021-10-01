package com.revature.project0.data;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BankDBConnection {

	
	ClassLoader cl = getClass().getClassLoader();
	InputStream is;
	Properties p = new Properties();
		
	public BankDBConnection () {
		is = cl.getResourceAsStream("connection.properties");
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		public Connection getDBConnection() throws SQLException {
			final String URL = p.getProperty("url");
			final String USERNAME = p.getProperty("username");
			final String PASSWORD = p.getProperty("password");
			
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
	}

