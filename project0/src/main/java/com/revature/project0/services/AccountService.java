package com.revature.project0.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.project0.data.AccountDaoImpl;
import com.revature.project0.data.UserDaoImpl;
import com.revature.project0.main.LogDriver;
import com.revature.project0.models.Account;
import com.revature.project0.models.JunctionObject;
import com.revature.project0.models.User;
import com.revature.project0.ui.ConsoleColors;


public class AccountService {
	
	private AccountDaoImpl aDao;
	private UserDaoImpl uDao;
	
	public AccountService() {	
	
	}
	
	
	public AccountService(AccountDaoImpl aDao, UserDaoImpl uDao) {
		this.aDao = aDao;
		this.uDao = uDao;
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
				throw new RuntimeException();
			}	
		}
		catch (Exception e) {
			System.out.println("This account has not yet been approved by the bank.  Please try again later.");
			LogDriver.log.error(e);
		}
		
	}
	
	
	public void withdraw(Account a, double amount) {
		try {
			
			if (a.isApproved()) {
				double newBalance = a.getBalance() - amount;
				if (newBalance < 0) {
					System.out.println("There is not enough money in your account for this transaction.");
					throw new RuntimeException();
				}
				a.setBalance(newBalance);
				aDao.update(a);
				System.out.println("Thank you for your withdrawal. Your new balance is $"+ a.getBalance() + ".");
				LogDriver.log.info("Account: " + a.getAccountID()+ "    Withdrawal: " + amount);
			} else {
				System.out.println("This account has not yet been approved by the bank.  Please try again later.");
				throw new RuntimeException();
			}
		}
		catch (Exception e) {
			
			LogDriver.log.error(e);
			return;
		}
	}
	
	
	public void transfer(Account from, Account to, double amount, User user) {
		try {
			if (from.isApproved() && to.isApproved()) {
				double newBalance = from.getBalance() - amount;
				if (newBalance < 0) {
					System.out.println("There is not enough money in your account for this transaction.");
					throw new RuntimeException();
				}
				from.setBalance(newBalance);
				aDao.update(from);
				newBalance = to.getBalance()+ amount;
				to.setBalance(newBalance);
				aDao.update(to);
				System.out.println("Thank you for your transfer. Here are your account balances:" );
				displayListAccountsByOwner(user.getUsername());
				LogDriver.log.info("Transfer of $" + amount + " from account "+ from.getAccountID()+ " to account " + to.getAccountID());
			} else {
				System.out.println("One of these accounts has not yet been approved by the bank.  Please try again later.");
				throw new RuntimeException();
			}
		}
		catch (Exception e) {
			LogDriver.log.error(e);
		}	
	
	}
	
	
	public Account displaySingleAccount(int accountID) {
		try {	
			Account account = aDao.getAccountbyID(accountID);
			
			if (Integer.valueOf(account.getAccountID())==null) {
				System.out.println("There is no account with that account number.");
				throw new RuntimeException();
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
			LogDriver.log.error(e);
		}
		return null;
	}
	
	
	public List<Account> displayListAccountsByOwner(String username) {
		try {	
			List<Account> accountList = aDao.getByUsername(username);
			
			if (accountList.get(0)==null) {
				System.out.println("There are no accounts for that user.");
				throw new RuntimeException();
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
			LogDriver.log.error(e);
			return null;
		}

	}
	
	
	public List<Account> createIndividualAccount(Account account, User user) {
		List<Integer> ownerIdList = new ArrayList<>();
		ownerIdList.add(user.getUserid());
		account.setOwnerIds(ownerIdList);
		
		aDao.insert(account);
		List<Account> accountList = displayListAccountsByOwner(user.getUsername());
		return accountList;
	}
	
	public List<Account> createJointAccount(Account account, User user, String jointUserName) {
		
		User jointUser = uDao.getByUsername(jointUserName);
		
		
		List<Integer> ownerIdList = new ArrayList<>();
		ownerIdList.add(user.getUserid());
		ownerIdList.add(jointUser.getUserid());
		account.setOwnerIds(ownerIdList);
		
		
		aDao.insert(account);
		List<Account> accountList = displayListAccountsByOwner(user.getUsername());
		return accountList;
	}
	
	
	public List<Account> listPendingAccounts(){
		
		try {
			List<JunctionObject> listofWonder = aDao.getPendingByUser();
			
			if (listofWonder.get(0)==null) {
				System.out.println("There are no pending accounts at this time.");
				throw new RuntimeException();
			}
			List<Account> accountList = new ArrayList<>();
			List<String> userList = new ArrayList<>();
			List<Integer> idList = new ArrayList<>();
			accountList.add(new Account(listofWonder.get(0).getAccountId(), listofWonder.get(0).getBalance(), listofWonder.get(0).isApproved(), null, null));
			userList.add(listofWonder.get(0).getUsername());
			idList.add(listofWonder.get(0).getUserId());
			for(int i =1; i<listofWonder.size();i++) {
				if (listofWonder.get(i).getAccountId() == accountList.get(i-1).getAccountID()){
					userList.add(listofWonder.get(i).getUsername());
					idList.add(listofWonder.get(i).getUserId());
				}else {
					accountList.get(i-1).setOwnerUsernames(userList);
					accountList.get(i-1).setOwnerIds(idList);
					accountList.add(new Account(listofWonder.get(i).getAccountId(), listofWonder.get(i).getBalance(), listofWonder.get(i).isApproved(), null, null));
					userList = new ArrayList<>();
					idList = new ArrayList<>();
					userList.add(listofWonder.get(i).getUsername());
					idList.add(listofWonder.get(i).getUserId());
				}
			}
			accountList.get(accountList.size()-1).setOwnerUsernames(userList);
			accountList.get(accountList.size()-1).setOwnerIds(idList);
			
			System.out.println("------------------------------------");
			for (Account a : accountList) {
				System.out.println(ConsoleColors.YELLOW+ a.getAccountID() + "   " + a.getOwnerUsernames().toString() + "  "+ a.getBalance());
			}
			System.out.println("------------------------------------");
			
			return accountList;
			
		}catch(RuntimeException e) {
			LogDriver.log.error(e);
		}
		return null;
	}
	
	public void approveAccount(int accountId) {
		
		Account account = aDao.getAccountbyID(accountId);
		System.out.println(account.toString());
		account.setApproved(true);
		aDao.update(account);
		LogDriver.log.info("Account #" + accountId + " approved.");
	}
	
	
	public void closeAccount(int accountId) {
		
		aDao.delete(accountId);
		LogDriver.log.info("Account #" + accountId + " has been deleted");
		
	}
	
	
	
}
