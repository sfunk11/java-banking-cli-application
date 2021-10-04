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
	}
	
	
	public void transfer(Account from, Account to, double amount) {
		try {
			if (from.isApproved() && to.isApproved()) {
				double newBalance = from.getBalance() - amount;
				from.setBalance(newBalance);
				aDao.update(from);
				newBalance = to.getBalance()+ amount;
				to.setBalance(newBalance);
				aDao.update(to);
			} else {
				throw new RuntimeException("One of these accounts has not yet been approved by the bank.  Please try again later.");
			}
		}
		catch (Exception e) {
			LogDriver.log.error("Attempted transaction on unapproved account.");
		}	
	
	}
	
	
	public Account displaySingleAccount(int accountID) {
		try {	
			Account account = aDao.getAccountbyID(accountID);
			
			if (Integer.valueOf(account.getAccountID())==null) {
				throw new RuntimeException("There is no account with that account number.");
			}
			
			System.out.println("Account Number: " + account.getAccountID());
			System.out.println("Account Balance: " + account.getBalance());
			
			if (account.isApproved()) {
				System.out.println("Status: Active");
			}else {
				System.out.println("Status: Pending");
			}
			
			return account;
			
		} catch(Exception e) {
			LogDriver.log.error("No accounts with number: " + accountID);
		}
		return null;
	}
	
	
	public List<Account> displayListAccountsByOwner(String username) {
		try {	
			List<Account> accountList = aDao.getByUsername(username);
			
			if (accountList.get(0)==null) {
				throw new RuntimeException("There are no accounts for that user.");
			}
			for(Account a : accountList) {
				
				System.out.println("----------------------------");
				System.out.println("Account Number: " + a.getAccountID());
				System.out.println("Account Balance: " + a.getBalance());
				if (a.isApproved()) {
					System.out.println("Status: Active");
				}else {
					System.out.println("Status: Pending");
				}
				System.out.println("----------------------------");
			}
			return accountList;
		} catch(Exception e) {
			LogDriver.log.error("No accounts for user: " + username);
			return null;
		}

	}
	
	
	public List<Account> createIndividualAccount(Account account, User user) {
		
		account.setOwnerid(user.getUserid());
		aDao.insert(account);
		List<Account> accountList = displayListAccountsByOwner(user.getUsername());
		return accountList;
	}
	
	
	public List<Account> listPendingAccounts(){
		
		try {
			List<Account> accountList = aDao.getPendingByUser();
			if (accountList.get(0)==null) {
				throw new RuntimeException("There are no pending accounts at this time.");
			}
			for(Account a : accountList) {
			
				System.out.println(a.getAccountID() + "   " + a.getOwnerUsername() + "  "+ a.getBalance());
			}
			return accountList;
			
		}catch(RuntimeException e) {
			LogDriver.log.error(e);
		}
		
		return null;
	}
	
	public void approveAccount(int accountId) {
		
		Account account = aDao.getAccountbyID(accountId);
		account.setApproved(true);
		aDao.update(account);
		
	}
	
	
	public void closeAccount(int accountId) {
		
		aDao.delete(accountId);
		
	}
	
	
	
}
