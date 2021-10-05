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
import com.revature.project0.models.JunctionObject;


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
				 accountList.add(new Account(rs.getInt(1),rs.getDouble(4), rs.getBoolean(5), null, null));
			 }
			 	 	 
		 } catch (SQLException e) {
			 LogDriver.log.error(e);
			
		}

		return accountList;
	}

	@Override
	public List<Account> getByUsername(String username) {	
		List<Account> accountList = new ArrayList<>();
		 
		 try(Connection con = bankCon.getDBConnection()){
			 
			 String sql = "select * from accounts a inner join user_junction_account uja on a.accountid = uja.accountid\n"
			 		+ "inner join users u on uja.userid = u.userid where u.username = ?";
			 PreparedStatement ps = con.prepareStatement(sql);
			 ps.setString(1, username);
			 ResultSet rs = ps.executeQuery();
			 
			 
			 while (rs.next()) {
				 accountList.add(new Account(rs.getInt(1),rs.getDouble(4), rs.getBoolean(5), null, null));
			 }
			 	 	 
		 } catch (SQLException e) {
			 LogDriver.log.error(e);
			
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
				 account = new Account(rs.getInt(1),rs.getDouble(4), rs.getBoolean(5), null, null);
			 }
			 	 	 
		 } catch (SQLException e) {
			 LogDriver.log.error(e);
		
		}
		return account;
	}

	@Override
	public void update(Account t) {
		try(Connection con = bankCon.getDBConnection()){
			
			String sql = "{? = call update_account(?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, t.getAccountID());
			cs.setDouble(3, t.getBalance());
			cs.setBoolean (4, t.isApproved());
			cs.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			LogDriver.log.error(e);
			
		}
		
	}

	@Override
	public void insert(Account t) {
		try(Connection con = bankCon.getDBConnection()){
			int accountId = 0;
			
			String sql = "{? = call insert_account (?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2,t.getOwnerIds().get(0));
			cs.setDouble(3, t.getBalance());
			cs.execute();
			
			String sql3 = "select * from accounts where accountid = (select MAX(accountid) from accounts)";
			PreparedStatement ps = con.prepareStatement(sql3);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				accountId = rs.getInt(1);
			}
			
			for (int id: t.getOwnerIds()) {
				String sql2 = "{? = call insert_junction(?,?)}";
				CallableStatement cs2 = con.prepareCall(sql2);
				cs2.registerOutParameter(1, Types.VARCHAR);
				cs2.setInt(2, accountId);
				cs2.setInt(3, id);
				cs2.execute();
			}
		} catch (SQLException e) {
			LogDriver.log.error(e);
		
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
			LogDriver.log.error(e);
			
		}
		
	}

	@Override
	public List<JunctionObject> getPendingByUser() {
		List<JunctionObject> listOfWonder = new ArrayList<>();
		 
		 try(Connection con = bankCon.getDBConnection()){
			 
			 String sql = "select a.accountid, a.balance, a.isApproved, u.userid, u.username from accounts a inner join user_junction_account uja on a.accountid = uja.accountid\n"
				 		+ "inner join users u on uja.userid = u.userid where a.isApproved = false";
			 PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 ResultSet rs = ps.executeQuery();
			
			 
			 
			
			 while (rs.next()) {
				 listOfWonder.add(new JunctionObject(rs.getInt(1), rs.getDouble(2), rs.getBoolean(3), rs.getInt(4), rs.getString(5)));
				
				
			 }
			 
			 	 	 
		 } catch (SQLException e) {
			 LogDriver.log.error(e);
			
		}
		return listOfWonder;
	}


}
