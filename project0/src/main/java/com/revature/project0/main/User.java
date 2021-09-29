package com.revature.project0.main;

public class User {

	private String name;
	private String email;
	private String password;
	private boolean isEmployee = false;
	private boolean isAdmin = false;
	private boolean hasAccount = false;
	
	
	public User(String name) {
		
	}


	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
		return hasAccount;
	}


	public void setHasAccount(boolean hasAccount) {
		this.hasAccount = hasAccount;
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
