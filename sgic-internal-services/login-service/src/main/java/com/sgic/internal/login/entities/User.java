package com.sgic.internal.login.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(schema="login", name="user")
public class User {

	 @Id                                               //Generate primary key as user email
	 @Column(name = "email", nullable = false)         //User email address
	 private String email;
	 @Column(name = "password", nullable = false)      //User password for login
	 private String password;
	 @Column(name = "role", nullable = false)          //User role 
	 private String role;
	
	//Generate getters and setters email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Generate getters and setters password
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Generate getters and setters user role
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	 
	
}
