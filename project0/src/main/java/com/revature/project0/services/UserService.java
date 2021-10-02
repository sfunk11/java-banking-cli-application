package com.revature.project0.services;

import com.revature.project0.data.UserDaoImpl;
import com.revature.project0.main.LogDriver;
import com.revature.project0.models.User;

public class UserService {

	private UserDaoImpl uDao;
	
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
}
