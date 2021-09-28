package com.revature.project0.main;

public class Account {

	private double balance;
	private String owner;
	
	
	public Account() {
		this.balance = 0;
	}

	public Account(double balance, String owner) {
		this.balance = balance;
		this.owner = owner;
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
	
	public void deposit(double amount) {
		double newBalance = this.getBalance() + amount;
		this.setBalance(newBalance);
		System.out.println("Thank you for your deposit. Your new balance is $"+ this.getBalance() + ".");
		LogDriver.log.info("Deposit: "+ amount);
	}
	
	public void withdraw(double amount) {
		double newBalance = this.getBalance() - amount;
		this.setBalance(newBalance);
		System.out.println("Thank you for your withdrawal. Your new balance is $"+ this.getBalance() + ".");
		LogDriver.log.info("Withdrawal: " + amount);
	}
}
