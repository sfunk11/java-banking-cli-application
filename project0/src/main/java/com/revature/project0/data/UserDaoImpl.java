package com.revature.project0.data;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.revature.project0.models.User;

public class UserDaoImpl implements GenericDao<User> {

	private BankDBConnection bankCon;
	
	public UserDaoImpl() {
		
	}
	

public UserDaoImpl(BankDBConnection bankCon) {
		super();
		this.bankCon = bankCon;
	}



@Override
public List<User> getAll() {
	 List<User> userList = new ArrayList<>();
	 
	 try(Connection con = bankCon.getDBConnection()){
		 
		 String sql = "select * from users";
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
public User getByUsername(String username) {
	
	
	try(Connection con = bankCon.getDBConnection()){
		 
		
		 String sql = "select * from users where username = ?";
		 PreparedStatement ps = con.prepareStatement(sql);
		 ps.setString(1, username);
		 
		 ResultSet rs = ps.executeQuery();
		 User user = new User();;
		
		 while (rs.next()) {
		 user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), 
				 rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getBoolean(7), 
				 rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13), 
				 rs.getString(14));
		 }
		 return user;
		 
		 	 	 
	 } catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return null;
}

@Override
public void update(User t) {
	// TODO Auto-generated method stub
	
}

@Override
public void insert(User t) {
	try(Connection con = bankCon.getDBConnection()){
		 
		
		 String sql = "{ ? = insert_BasicUser(?,?,?,?,?)";
		 CallableStatement cs = con.prepareCall(sql);
		 cs.registerOutParameter(1, Types.VARCHAR);
		 cs.setString(2, t.getFirstName());
		 cs.setString(3, t.getLastName());
		 cs.setString(4,  t.getUsername());
		 cs.setString(5,  t.getPassword());
		 cs.setString(6, t.getEmail());
		 cs.execute();
		 
		 	 	 
	 } catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}

@Override
public void delete(User t) {
	try(Connection con = bankCon.getDBConnection()){
		 
		
		 String sql = "delete from users where firstname = ? and lastname = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		 
		 ps.setString(1, t.getFirstName());
		 ps.setString(2, t.getLastName());
		 ps.execute();
		 
		 	 	 
	 } catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
}

}
