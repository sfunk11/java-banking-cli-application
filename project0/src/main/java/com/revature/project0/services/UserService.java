package com.revature.project0.services;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.project0.data.UserDaoImpl;
import com.revature.project0.main.LogDriver;
import com.revature.project0.models.User;

public class UserService {

	private UserDaoImpl uDao;
	private Scanner conInput = new Scanner(System.in);
	
	public UserService() {
	}
	
	
	
	public UserService(UserDaoImpl uDao) {
		super();
		this.uDao = uDao;
	}



	public User logIn(String username, String password) {
		try {
			User user = uDao.getByUsername(username);
			
			if (user.getPassword().equals(password.trim())) {
				return user;
			} else {
				throw new IllegalArgumentException("There is no user with that username.");
			}
			
			
		} catch (Exception e) {
			LogDriver.log.error(e);
		}
		
		
		return null;
	}
	
	public User createUser(User user) {
		
		try {
			uDao.insert(user);
			User newUser = uDao.getByUsername(user.getUsername());
			if (newUser.getFirstName() != null) {
				return newUser;
			} else {
				throw new RuntimeException("Something went wrong.");
			}
		}catch (Exception e) {
			LogDriver.log.error(e);
		}
		return null;
	}
	
	public void displayUserInfo(User user) {
		
	}
	
	public User updateEmail(User user, String email) {
		try {
			String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
			Pattern p = Pattern.compile(regex);
			Matcher matcher = p.matcher(email);
			if (matcher.matches()) {
				user.setEmail(email);
				uDao.update(user);
			} else {
				throw new RuntimeException("That is not a properly formatted email.");
			}
		}catch(Exception e) {
			LogDriver.log.error(e);
			System.out.println("Please enter the email address you would like to use:");
			String newEmail = conInput.nextLine();
			updateEmail(user,newEmail);
		}
		return user;
	}
	
	public User updatePassword(User user, String password) {
	
		user.setPassword(password);
		uDao.update(user);
		return user;
	}
	
	
}
