package com.revature.project0.data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project0.models.User;

public class UserDaoImpl implements GenericDao<User> {

	private BankDBConnection bankCon;

@Override
public List<User> getAll() {
	 List<User> userList = new ArrayList<>();
	 
	 try(Connection con = bankCon.getDBConnection()){
		 
		 String sql = "select * from creature_card";
		 PreparedStatement ps = con.prepareStatement(sql);
		 ResultSet rs = ps.executeQuery();
		 
		 while (rs.next()) {
			 userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), 
				 rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getBoolean(7), 
				 rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13), 
				 rs.getString(14)));
		 }
		 	 	 
	 } catch (SQLException e) {
		
		e.printStackTrace();
	}

	return userList;
}

@Override
public User getByName(String name) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void update(User t) {
	// TODO Auto-generated method stub
	
}

@Override
public void insert(User t) {
	// TODO Auto-generated method stub
	
}

@Override
public void delete(User t) {
	// TODO Auto-generated method stub
	
}

}
