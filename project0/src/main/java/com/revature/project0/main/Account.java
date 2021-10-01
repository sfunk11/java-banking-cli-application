package com.revature.project0.main;

public class Account {

	private double balance;
	private String owner;
	private boolean isApproved = false;
	private final String accountName;
	
	
	public Account(String owner) {
		this.balance = 0;
		this.owner = owner;
		this.accountName = owner.replaceAll(" ", "");
	}

	public Account(double balance, String owner) {
		this.balance = balance;
		this.owner = owner.replaceAll(" ", "");
		this.accountName = owner.replaceAll(" ", "");
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	

	public String getAccountName() {
		return this.accountName;
	}

	public void deposit(double amount) {
		try {
			if (isApproved) {
				double newBalance = this.getBalance() + amount;
				this.setBalance(newBalance);
				System.out.println("Thank you for your deposit. Your new balance is $"+ this.getBalance() + ".");
				LogDriver.log.info("Deposit: "+ amount);
			} else {
				throw new RuntimeException("This account has not yet been approved by the bank.  Please try again later.");
			}	
		}
		catch (Exception e) {
			//Add in present main menu screen
			LogDriver.log.error("Attempted transaction on unapproved account.");
		}
	}
	
	public void withdraw(double amount) {
		try {
			if (isApproved) {
				double newBalance = this.getBalance() - amount;
				this.setBalance(newBalance);
				System.out.println("Thank you for your withdrawal. Your new balance is $"+ this.getBalance() + ".");
				LogDriver.log.info("Withdrawal: " + amount);
			} else {
				throw new RuntimeException("This account has not yet been approved by the bank.  Please try again later.");
			}
		}
		catch (Exception e) {
			// add in present main menu screen
			LogDriver.log.error("Attempted transaction on unapproved account.");
		}
	
	}
}
