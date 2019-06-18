package com.sgic.internal.login.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.login.entities.User;


@Service
public interface UserService {
	public User createUsers(User user); 
	public List<User> getAllUsers ();
	public void deleteUser(String email);
	public boolean isUserAlreadyExist(String email);
	public User findByEmail(String email);
//	public User updateUser(User user);
}
