package com.revature.project0.services;

import java.util.List;

import com.revature.project0.data.AccountDaoImpl;
import com.revature.project0.main.LogDriver;
import com.revature.project0.models.Account;
import com.revature.project0.models.User;

public class AccountService {
	
	private AccountDaoImpl aDao;
	
	public AccountService() {
		
	}
	
	public AccountService(AccountDaoImpl aDao) {
		this.aDao = aDao;
	}
	

	public void deposit(Account a, double amount) {
		try {
			if (a.isApproved()) {
				double newBalance = a.getBalance() + amount;
				a.setBalance(newBalance);
				aDao.update(a);
				System.out.println("Thank you for your deposit. Your new balance is $"+ a.getBalance() + ".");
				LogDriver.log.info("Account: " + a.getAccountID()+ "     Deposit: "+ amount);
				
				
			} else {
				throw new RuntimeException("This account has not yet been approved by the bank.  Please try again later.");
			}	
		}
		catch (Exception e) {
			
			LogDriver.log.error("Attempted transaction on unapproved account.");
		}
		//Add in present main menu screen
	}
	
	public void withdraw(Account a, double amount) {
		try {
			if (a.isApproved()) {
				double newBalance = a.getBalance() - amount;
				a.setBalance(newBalance);
				aDao.update(a);
				System.out.println("Thank you for your withdrawal. Your new balance is $"+ a.getBalance() + ".");
				LogDriver.log.info("Account: " + a.getAccountID()+ "    Withdrawal: " + amount);
			} else {
				throw new RuntimeException("This account has not yet been approved by the bank.  Please try again later.");
			}
		}
		catch (Exception e) {
			LogDriver.log.error("Attempted transaction on unapproved account.");
		}
		
		//add in logic to present main menu screen
	
	}
	
	public void displaySingleAccount(int accountID) {
	try {	
		Account account = aDao.getAccountbyID(accountID);
		
		if (Integer.valueOf(account.getAccountID())==null) {
			throw new RuntimeException("There is no account with that account number.");
		}
		System.out.println("Account Number: " + account.getAccountID());
		System.out.println("Account Balance: " + account.getBalance());
	} catch(Exception e) {
		LogDriver.log.error("No accounts with number: " + accountID);
	}
	}
	
	public void displayListAccountsByOwner(String username) {
	try {	
		List<Account> accountList = aDao.getByUsername(username);
		
		if (accountList.get(0)==null) {
			throw new RuntimeException("There are no accounts for that user.");
		}
		for(Account a : accountList) {
			
			System.out.println("----------------------------");
			System.out.println("Account Number: " + a.getAccountID());
			System.out.println("Account Balance: " + a.getBalance());
			System.out.println("----------------------------");
		}
	} catch(Exception e) {
		LogDriver.log.error("No accounts for user: " + username);
	}
	}
}
