package com.davinder.app.ws.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author davindersingh
 * 
 *         @Entity(name="users") - I am telling JPA, that users will be the name
 *         of the table that gets created in the database when ORM happens.
 * 
 *         Also notice that my entity class implements Serializable interface.
 *         As long as, I use only HQL (Hibernate Query Language), there is no
 *         need for my entity class to implement Serializable interface. But if
 *         we start to use (native SQL queries)SQL also, then our Spring Boot
 *         Application will start to complain. This knowledge is gained from thi
 *         stackoverflow link:
 * 
 *         https://stackoverflow.com/questions/2020904/when-and-why-jpa-entities-should-implement-serializable-interface
 * 
 */
@Entity(name = "users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -5016754765083536923L;

	/*
	 * @Id annotation tells Spring Framework that id variable is a primary key.
	 * 
	 * @GeneratedValue annotation tells Spring Framework that this id will be auto
	 * incremented every time a new record is inserted.
	 */
	@Id
	@GeneratedValue
	private long id;

	/*
	 * nullable=false annotation suggests that this column value in db cannot be
	 * null.
	 */
	@Column(nullable = false)
	private String userId;

	/*
	 * if I do not set length then this column will be created with maximum length
	 * of a varchar which is 250.
	 */
	@Column(nullable = false, length = 50)
	private String firstName;

	@Column(nullable = false, length = 50)
	private String lastName;

	@Column(nullable = false, length = 120)
	private String email;

	@Column(nullable = false)
	private String encryptedPassword;

	/*
	 * not setting any condition on column emailVerificationToken.
	 */
	private String emailVerificationToken;

	/*
	 * Explicitly setting variable to false, tells JPA to set false as the default
	 * value for this column. I also need to set this variable to false in the dto
	 * class.
	 */
	@Column(nullable = false)
	private boolean emailVerificationStatus = false;
	
	/*
	 * Start of getter and setters.
	 */
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
