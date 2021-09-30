package com.revature.project0.main;

public class User {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean isEmployee = false;
	private boolean isAdmin = false;
	private boolean hasAccounts = false;
	
	
	public User(String name) {
		
		String[] fullName = name.split(" ");
		this.firstName = fullName[0];
		this.lastName = fullName[fullName.length -1];
	}


	public User(String name, String email) {
		super();
		String[] fullName = name.split(" ");
		this.firstName = fullName[0];
		this.lastName = fullName[fullName.length -1];
		this.email = email;
	}

	
	public User(String name, String email, String password) {
		super();
		String[] fullName = name.split(" ");
		this.firstName = fullName[0];
		this.lastName = fullName[fullName.length -1];
		this.email = email;
		this.password = password;
	}


	public String getName() {
		return firstName.concat(" " + lastName);
	}


	public void setName(String name) {
		String[] fullName = name.split(" ");
		this.firstName = fullName[0];
		this.lastName = fullName[fullName.length -1];
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isEmployee() {
		return isEmployee;
	}


	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}


	public boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public boolean isHasAccount() {
		return hasAccounts;
	}


	public void setHasAccount(boolean hasAccount) {
		this.hasAccounts = hasAccount;
	}
	
//	public void createAccount(double amount) {
//		
//		String accountName = this.name.replace(" ","").toLowerCase();
//		Account accountName = new Account(amount, this.name);
//		this.hasAccount = true;
//		
//		
		
//	}
	public void approveAccount(String name) {
		if (this.isEmployee() || this.isAdmin()) {
			
		}
	}

}
