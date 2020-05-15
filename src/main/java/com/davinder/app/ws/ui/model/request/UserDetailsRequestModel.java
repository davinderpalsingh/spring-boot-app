package com.davinder.app.ws.ui.model.request;

/*
 * This is a regular java bean or pojo which needs to have class fields that matches the json payload.  
 * 
 * To generate getters and setters, do this right click -> Source -> Generate getters and setters.
 */
public class UserDetailsRequestModel {

	private String firstName;
	private String lastName;
	private String email;
	private String password;

	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
