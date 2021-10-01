package com.revature.project0.data;

import java.util.List;

import com.revature.project0.models.User;


public interface UserDao {
	
	List<User> getAllUsers();
	
	User getUser();
	
	void insertUser();
	
	void updateUser();
	
	void deleteUser();
}
