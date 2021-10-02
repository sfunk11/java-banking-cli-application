package com.revature.project0.data;

import java.util.List;

import com.revature.project0.models.User;

public interface UserDao {

List<User> getAll();
	
	User getByUsername(String name);
	
	void update(User t);
	
	void insert (User t);
	
	void delete (User t);
}
