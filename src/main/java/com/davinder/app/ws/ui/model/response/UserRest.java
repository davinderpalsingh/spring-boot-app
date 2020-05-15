package com.davinder.app.ws.ui.model.response;

/**
 * @author davindersingh
 *
 *         This is the response class. It will contain all the class fields that
 *         we want to return to the client in the response json.
 * 
 *         The field "userId" is not the actual userId that we assign to a new
 *         user for unique identification. This will ensure that no malicious
 *         user can get to know the real user-id stored in the database.
 * 
 */
public class UserRest {

	private String userId;
	private String firstName;
	private String lastName;
	private String email;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
