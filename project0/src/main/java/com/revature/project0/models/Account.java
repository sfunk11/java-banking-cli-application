package com.revature.project0.models;

import java.util.List;

public class Account {

	private int accountID;
	private double balance;
	private boolean isApproved;
	private List<String> ownerUsernames;
	private List<Integer> ownerIds;


	public Account() {
		
	}

	
	public Account(int accountID, double balance, boolean isApproved, List<Integer> ownerIds) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.isApproved = isApproved;
		this.ownerIds = ownerIds;
	}


	public Account(int accountID, double balance, boolean isApproved, List<String> ownerUsernames, List<Integer> ownerIds) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.isApproved = isApproved;
		this.ownerUsernames = ownerUsernames;
		this.ownerIds = ownerIds;
	}

	public Account( double balance, List<Integer> ownerIds) {
		super();
		this.ownerIds = ownerIds;
		this.balance = balance;
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
	
	
	
	public List<String> getOwnerUsernames() {
		return ownerUsernames;
	}


	public void setOwnerUsernames(List<String> ownerUsernames) {
		this.ownerUsernames = ownerUsernames;
	}


	public List<Integer> getOwnerIds() {
		return ownerIds;
	}


	public void setOwnerIds(List<Integer> ownerIds) {
		this.ownerIds = ownerIds;
	}


	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", balance=" + balance + ", isApproved=" + isApproved
				+ ", ownerUsernames=" + ownerUsernames + ", ownerIds=" + ownerIds + "]";
	}

	
}
