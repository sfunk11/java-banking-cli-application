package com.revature.project0.models;


public class Account {

	private int accountID;
	private int ownerid;
	private double balance;
	private boolean isApproved;
	
	public Account() {
		
	}

	public Account(int accountID, int ownerid, double balance, boolean isApproved) {
		super();
		this.accountID = accountID;
		
		this.ownerid = ownerid;
		this.balance = balance;
		this.isApproved = isApproved;
	}

	public Account(int ownerid, double balance) {
		super();
		this.ownerid = ownerid;
		this.balance = balance;
	}

	public int getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public int getAccountID() {
		return accountID;
	}

}
