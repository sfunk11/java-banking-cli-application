package com.revature.project0.models;

public class User {
	private int userid;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private boolean isAdmin = false;
	private boolean isEmployee = false;
	private int phoneNumber;
	private int streetNumber;
	private String streetName;
	private String city;
	private String state;
	private int zipCode;
	private String email;
	
	public User() {	
	}
	
	
	public User(int userid, String firstName, String lastName, String username, String password, boolean isAdmin,
			boolean isEmployee, int phoneNumber, int streetNumber, String streetName, String city, String state,
			int zipCode, String email) {
		super();
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isEmployee = isEmployee;
		this.phoneNumber = phoneNumber;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
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


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getStreetNumber() {
		return streetNumber;
	}


	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}


	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getZipCode() {
		return zipCode;
	}


	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}


	public int getUserid() {
		return userid;
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", isAdmin=" + isAdmin + ", isEmployee=" + isEmployee
				+ ", phoneNumber=" + phoneNumber + ", streetNumber=" + streetNumber + ", streetName=" + streetName
				+ ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}
	
	
	
	
}
