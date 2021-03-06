package com.revature.project0.data;

import java.util.List;

import com.revature.project0.models.Account;
import com.revature.project0.models.JunctionObject;

public interface AccountDao {

	List<Account> getAll();
	
	List<JunctionObject> getPendingByUser();
	
	List<Account> getByUsername(String username);
	
	Account getAccountbyID(int accountid);
	
	void update(Account t);
	
	void insert (Account t);
	
	void delete (int accountId);
}
