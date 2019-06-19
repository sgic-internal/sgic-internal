package com.sgic.internal.login.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.internal.login.entities.User;
import com.sgic.internal.login.repositories.UserRepository;
import com.sgic.internal.login.services.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	//Creating new users 
	@Override
	@Transactional(readOnly=false)
	public User createUsers(User user) {
		User responseUser= userRepository.save(user);
		return responseUser;
	}

	 //List all the users
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll() ;
	}

	//check the user email address is already exists or not
	@Override
	public boolean isUserAlreadyExist(String email) {
		return userRepository.existsById(email) ;
	}

	//Get the user detail using the mail address
	@Override
	public User findByEmail(String email) {
		
		return userRepository.getByEmail(email);
	}

	 //List all the users
	@Override
	public void deleteUser(String email) {
		userRepository.deleteById(email);
	}

	 //Update user details
	@Override
	public User updateUser(String email, User user) {
		
			if (userRepository.getOne(email) != null) {
				user.setEmail(email);
				userRepository.save(user);
			}
		
		return user;
	}

	//Get the user detail using the role
	@Override
	public User findByRole(String role) {
		return userRepository.getByRole(role);
	}

	

}
