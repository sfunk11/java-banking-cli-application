package com.revature.project0.services;

import java.util.List;
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
				LogDriver.log.info(username + " logged in");
				return user;
			} else {
				throw new IllegalArgumentException("That username and password do not match any users.");
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
				LogDriver.log.info(newUser.getUsername() + " has been added");
				return newUser;
			} else {
				throw new RuntimeException("Something went wrong.");
			}
		}catch (Exception e) {
			LogDriver.log.error(e);
		}
		return null;
	}
	
	
	public User updateEmail(User user, String email) {
		try {
			String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
			Pattern p = Pattern.compile(regex);
			Matcher matcher = p.matcher(email);
			if (matcher.matches()) {
				user.setEmail(email);
				uDao.update(user);
				LogDriver.log.info(user.getUsername() + " has been updated");
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
	
	public void displayInfo(User user) {
		System.out.println("First Name: "+ user.getFirstName());
		System.out.println("Last Name: "+ user.getLastName());
		System.out.println("Email Address: "+ user.getEmail());
		System.out.println("Username: "+ user.getUsername());
		System.out.println("Password: "+ user.getPassword());
	}
	
	public User updateUser(User user) {
	
		uDao.update(user);
		LogDriver.log.info(user.getUsername() + " has been updated");
		return user;
	}
	
	public void removeUser(User user) {
		LogDriver.log.info(user.getUsername() + " has been deleted");	
		uDao.delete(user);	
	
	}
	
	public List<User> listAllCustomers() {
		List<User> userList = uDao.getAll();
		for (User u : userList) {
			System.out.println(u.getUserid() + " " + u.getFirstName() + " " + u.getLastName());
		}
		return userList;
	}
}
