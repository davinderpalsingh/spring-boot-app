package com.davinder.app.ws.shared.dto;

import java.io.Serializable;

/**
 * 
 * @author davindersingh
 *
 *         Dto stands for data transfer object ad it is a design pattern and to
 *         confirm to that design pattern we need to implement Serializable
 *         interface.
 *
 *         Why do data transfer objects need to implement Serialization? data
 *         transfer objects need to implement Serialization because of session
 *         replication between load-balanced servers. courtesy:
 *         https://stackoverflow.com/questions/2451542/why-do-transfer-objects-need-to-implement-serializable
 *
 *
 */

public class UserDto implements Serializable {
	/*
	 * The JVM associates a version (long) number with each serializable class. It
	 * is used to verify that the saved and loaded objects have the same attributes
	 * and thus are compatible on serialization.
	 * 
	 * This number can be generated automatically by most IDEs and is based on the
	 * class name, its attributes and associated access modifiers. Any changes
	 * result in a different number and can cause an InvalidClassException.
	 * 
	 * If a serializable class doesn't declare a serialVersionUID, the JVM will
	 * generate one automatically at run-time. However, it is highly recommended
	 * that each class declares its serialVersionUID as the generated one is
	 * compiler dependent and thus may result in unexpected InvalidClassExceptions.
	 */
	private static final long serialVersionUID = 2809832730114888931L;

	private long id;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String encryptedPassword;
	private String emailVerificationToken;
	private boolean emailVerificationStatus = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}

	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}

	public boolean isEmailVerificationStatus() {
		return emailVerificationStatus;
	}

	public void setEmailVerificationStatus(boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}
}
