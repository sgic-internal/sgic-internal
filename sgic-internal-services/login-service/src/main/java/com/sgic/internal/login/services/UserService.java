package com.sgic.internal.login.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.login.entities.User;


@Service
public interface UserService {
	public User createUsers(User user);                //Creating new users 
	public List<User> getAllUsers ();                  //List all the users
	public void deleteUser(String email);              //Delete user using his email address
	public boolean isUserAlreadyExist(String email);   //check the user email address is already exists or not
	public User findByEmail(String email);             //Get the user detail using the mail address
	public List <User> findByRole(String role);        //Get the user detail using the role
	public User updateUser(String email,User user);    //Update user details
	
}

