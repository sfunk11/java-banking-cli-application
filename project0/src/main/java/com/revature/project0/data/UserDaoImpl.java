package com.revature.project0.data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Food;
import com.revature.project0.models.User;

public class UserDaoImpl implements UserDao {

private List<User> users = new ArrayList<>();
private static final String URL = "jdbc:postgresql://revature-2109-java.cmeofp2uiqe0.us-east-2.rds.amazonaws.com:5432/bankdb";
private static final String username = "bankuser";
private static final String password = "P4ssw0rd";

@Override
public List<User> getAllUsers() {
	try(Connection con = DriverManager.getConnection(URL, username, password)){
		
		String sql = "select * from users";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return foodList;
}
	return null;
}

@Override
public User getUser() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void insertUser() {
	// TODO Auto-generated method stub
	
}

@Override
public void updateUser() {
	// TODO Auto-generated method stub
	
}

@Override
public void deleteUser() {
	// TODO Auto-generated method stub
	
}
    
} 
