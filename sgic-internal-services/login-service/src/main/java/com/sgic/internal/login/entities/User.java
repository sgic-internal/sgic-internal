package com.sgic.internal.login.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(schema="loginservice", name="user")
public class User {

	 @Id
	 @Column(name = "email", nullable = false)
	 private String email;
	 @Column(name = "password", nullable = false)
	 private String password;
	 @Column(name = "role", nullable = false)
	 private String role;
	 
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	 
	
}
