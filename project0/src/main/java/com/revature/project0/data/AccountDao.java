package com.revature.project0.data;

import java.util.List;

import com.revature.project0.models.Account;

public interface AccountDao {

	List<Account> getAll();
	
	List<Account> getPendingByUser();
	
	List<Account> getByUsername(String username);
	
	Account getAccountbyID(int accountid);
	
	void update(Account t);
	
	void insert (Account t);
	
	void delete (Account t);
}
