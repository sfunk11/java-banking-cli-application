package com.revature.project0.models;

public class User {
	private int userid;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private boolean isAdmin = false;
	private boolean isEmployee = false;
	private String email;
	
	public User() {	
	}
	
	
	public User(int userid, String firstName, String lastName, String username, String password, boolean isAdmin,
			boolean isEmployee, String email) {
		super();
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isEmployee = isEmployee;
		this.email = email;
	}


	public User(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public boolean isEmployee() {
		return isEmployee;
	}


	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}


	public int getUserid() {
		return userid;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", isAdmin=" + isAdmin + ", isEmployee=" + isEmployee
				+ ", email=" + email + "]";
	}
	
	

	
	
	
	
}
