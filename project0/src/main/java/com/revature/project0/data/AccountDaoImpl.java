package com.revature.project0.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project0.models.Account;


public class AccountDaoImpl implements AccountDao{

	private BankDBConnection bankCon;
	
	
	public AccountDaoImpl() {
	
	}
	
	public AccountDaoImpl(BankDBConnection bankCon) {
		this.bankCon = bankCon;
	}
	
	
	@Override
	public List<Account> getAll() {
		List<Account> accountList = new ArrayList<>();
		 
		 try(Connection con = bankCon.getDBConnection()){
			 
			 String sql = "select * from accounts";
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();
			 
			 while (rs.next()) {
				 accountList.add(new Account(rs.getInt(1), rs.getInt(3), 
					 rs.getDouble(4), rs.getBoolean(5)));
			 }
			 	 	 
		 } catch (SQLException e) {
			
			e.printStackTrace();
		}

		return accountList;
	}

	@Override
	public List<Account> getByUsername(String username) {	
		List<Account> accountList = new ArrayList<>();
		 
		 try(Connection con = bankCon.getDBConnection()){
			 
			 String sql = "select * from accounts a inner join users u on a.ownerid = u.userid where u.username = ?";
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setString(1, username);
			 ResultSet rs = ps.executeQuery();
			 
			 while (rs.next()) {
				 accountList.add(new Account(rs.getInt(1), rs.getInt(3), 
					 rs.getDouble(4), rs.getBoolean(5)));
			 }
			 	 	 
		 } catch (SQLException e) {
			
			e.printStackTrace();
		}

		return accountList;
	}
	
	
	@Override
	public Account getAccountbyID(int accountid) {
		Account account = new Account();
		
		try(Connection con = bankCon.getDBConnection()){
						
			 String sql = "select * from accounts a inner join users u on a.ownerid = u.userid where u.userid= ?";
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setInt(1, accountid);
			 ResultSet rs = ps.executeQuery();
			 
			 
			 while (rs.next()) {
				 account = new Account(rs.getInt(1), rs.getInt(3), 
					 rs.getDouble(4), rs.getBoolean(5));
			 }
			 	 	 
		 } catch (SQLException e) {
			
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public void update(Account t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Account t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Account t) {
		// TODO Auto-generated method stub
		
	}

}
