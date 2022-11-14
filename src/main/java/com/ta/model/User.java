package com.ta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUSEENDHIRAN_MATRIMONY_USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userID;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	public User(int userID, String email, String password) {
		super();
		this.userID = userID;
		this.email = email;
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	@Override
	public String toString() {
		return "Tutorial [userID = " + userID + ", email = " + email + ", password = " + password + "]";
	}
}