package com.revature.project0.models;


public class Account {

	private int accountID;
	private int ownerid;
	private double balance;
	private boolean isApproved;
	private String ownerUsername;


	public Account() {
		
	}

	
	public Account(int accountID, int ownerid, double balance, boolean isApproved) {
		super();
		this.accountID = accountID;
		this.ownerid = ownerid;
		this.balance = balance;
		this.isApproved = isApproved;
	}


	public Account(int accountID, int ownerid, double balance, boolean isApproved, String ownerUsername) {
		super();
		this.accountID = accountID;
		
		this.ownerid = ownerid;
		this.balance = balance;
		this.isApproved = isApproved;
		this.ownerUsername = ownerUsername;
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
	
	
	public String getOwnerUsername() {
		return ownerUsername;
	}

	public void setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
	}

}
