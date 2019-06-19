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

	@Override
	@Transactional(readOnly=false)
	public User createUsers(User user) {
		User responseUser= userRepository.save(user);
		return responseUser;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll() ;
	}

	@Override
	public boolean isUserAlreadyExist(String email) {
		return userRepository.existsById(email) ;
	}

	@Override
	public User findByEmail(String email) {
		
		return userRepository.getByEmail(email);
	}

	@Override
	public void deleteUser(String email) {
		userRepository.deleteById(email);
	}

	@Override
	public User updateUser(String email, User user) {
		
			if (userRepository.getOne(email) != null) {
				user.setEmail(email);
				userRepository.save(user);
			}
		
		return user;
	}

	@Override
	public User findByRole(String role) {
		return userRepository.getByRole(role);
	}

	

}
