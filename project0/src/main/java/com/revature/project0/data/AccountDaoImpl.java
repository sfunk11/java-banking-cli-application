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
			 LogDriver.log.error("Database error");
			
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
			 LogDriver.log.error("Database error");
			
		}

		return accountList;
	}
	
	
	@Override
	public Account getAccountbyID(int accountid) {
		Account account = new Account();
		
		try(Connection con = bankCon.getDBConnection()){
						
			 String sql = "select * from accounts a inner join users u on a.ownerid = u.userid where a.accountid= ?";
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setInt(1, accountid);
			 ResultSet rs = ps.executeQuery();
			 
			 
			 while (rs.next()) {
				 account = new Account(rs.getInt(1), rs.getInt(3), 
					 rs.getDouble(4), rs.getBoolean(5));
			 }
			 	 	 
		 } catch (SQLException e) {
			 LogDriver.log.error("Database error");
		
		}
		return account;
	}

	@Override
	public void update(Account t) {
		try(Connection con = bankCon.getDBConnection()){
			
			String sql = "{? = call update_account(?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, t.getAccountID());
			cs.setInt(3,t.getOwnerid());
			cs.setDouble(4, t.getBalance());
			cs.setBoolean (5, t.isApproved());
			cs.execute();
			
		} catch (SQLException e) {
			LogDriver.log.error("Database error");
			
		}
		
	}

	@Override
	public void insert(Account t) {
		try(Connection con = bankCon.getDBConnection()){
			
			String sql = "{? = call insert_account (?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2,t.getOwnerid());
			cs.setDouble(3, t.getBalance());
			cs.execute();
			
		} catch (SQLException e) {
			LogDriver.log.error("Database error");
		
		}
		
	}

	@Override
	public void delete(int accountId) {
		try(Connection con = bankCon.getDBConnection()){
			
			String sql = "delete from accounts where accountid = ?";
			PreparedStatement cs = con.prepareStatement(sql);
			cs.setInt(1,accountId);
			cs.execute();
			
		} catch (SQLException e) {
			LogDriver.log.error("Database error");
			
		}
		
	}

	@Override
	public List<Account> getPendingByUser() {
		List<Account> accountList = new ArrayList<>();
		 
		 try(Connection con = bankCon.getDBConnection()){
			 
			 String sql = "select * from accounts a inner join users u on a.ownerid = u.userid where a.isApproved = false";
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();
			 
			 while (rs.next()) {
				 accountList.add(new Account(rs.getInt(1), rs.getInt(3), 
					 rs.getDouble(4), rs.getBoolean(5), rs.getString(9)));
			 }
			 	 	 
		 } catch (SQLException e) {
			 LogDriver.log.error("Database error");
			
		}

		return accountList;
	}


}
