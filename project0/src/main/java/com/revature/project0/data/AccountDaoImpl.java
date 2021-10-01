package com.revature.project0.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project0.models.Account;
import com.revature.project0.models.User;

public class AccountDaoImpl implements GenericDao<Account>{

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
	public Account getByUsername(String name) {
		// TODO Auto-generated method stub
		return null;
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
