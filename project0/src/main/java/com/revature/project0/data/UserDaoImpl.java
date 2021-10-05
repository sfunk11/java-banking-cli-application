package com.revature.project0.data;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.revature.project0.main.LogDriver;
import com.revature.project0.models.User;

public class UserDaoImpl implements UserDao {

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
				 rs.getString(8)));
		 }
		 	 	 
	 } catch (SQLException e) {
		
		 LogDriver.log.error(e);
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
				 rs.getString(8));
		 }
		 return user;
		 
		 	 	 
	 } catch (SQLException e) {
		
		 LogDriver.log.error(e);
	}
	
	return null;
}

@Override
public void update(User t) {
	try(Connection con = bankCon.getDBConnection()){
		 
		
		 String sql = "{? = call update_user(?,?,?,?,?,?,?,?)}";
		CallableStatement ps = con.prepareCall(sql);
		 ps.registerOutParameter(1,  Types.VARCHAR);
		 ps.setString(2, t.getFirstName());
		 ps.setString(3, t.getLastName());
		 ps.setString(4, t.getUsername());
		 ps.setString(5, t.getPassword());
		 ps.setBoolean(6, t.isAdmin());
		 ps.setBoolean(7, t.isEmployee());
		 ps.setString(8, t.getEmail());
		 ps.setInt(9, t.getUserid());
		 ps.execute();
		 
		 	 	 
	 } catch (SQLException e) {
		
		 LogDriver.log.error(e);
	}
	
}

@Override
public void insert(User t) {
	try(Connection con = bankCon.getDBConnection()){
		 
		
		 String sql = "{? = call insert_BasicUser(?,?,?,?,?)}";
		 CallableStatement cs = con.prepareCall(sql);
		 cs.registerOutParameter(1, Types.VARCHAR);
		 cs.setString(2, t.getFirstName());
		 cs.setString(3, t.getLastName());
		 cs.setString(4,  t.getUsername());
		 cs.setString(5,  t.getPassword());
		 cs.setString(6, t.getEmail());
		 cs.execute();
		 
		 	 	 
	 } catch (SQLException e) {
		
		 LogDriver.log.error(e);
	}
	
}

@Override
public void delete(User t) {
	try(Connection con = bankCon.getDBConnection()){
		 
		
		 String sql = "delete from users where username = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		 
		 ps.setString(1, t.getUsername());
		 ps.execute();
		 
		 	 	 
	 } catch (SQLException e) {
		
		 LogDriver.log.error(e);
	}
	
	
}

}
