package com.revature.project0.models;

public class JunctionObject {
	
	private int accountId;
	private double balance;
	private boolean isApproved;
	private int userId;
	private String username;

	public JunctionObject() {
		// TODO Auto-generated constructor stub
	}

	public JunctionObject(int accountId, double balance, boolean isApproved, int userId, String username) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.isApproved = isApproved;
		this.userId = userId;
		this.username = username;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "JunctionObject [accountId=" + accountId + ", balance=" + balance + ", isApproved=" + isApproved
				+ ", userId=" + userId + ", username=" + username + "]";
	}
	
	
}
