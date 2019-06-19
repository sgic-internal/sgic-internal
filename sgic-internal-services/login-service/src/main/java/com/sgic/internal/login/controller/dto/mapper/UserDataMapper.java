package com.sgic.internal.login.controller.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.sgic.internal.login.controller.dto.UserData;
import com.sgic.internal.login.controller.dto.converter.UserDataConverter;
import com.sgic.internal.login.entities.User;
import com.sgic.internal.login.services.UserService;

@Service
public class UserDataMapper {

	@Autowired
	private UserService userService;

	@Autowired
	private UserDataConverter userDataConverter;

	private static Logger logger = LogManager.getLogger(UserDataMapper.class);

	@SuppressWarnings("static-access")
	public  User createUser(UserData userData) {
		User user = userDataConverter.UserDataToUser(userData);
		return userService.createUsers(user) ;
		
	}
	
	@SuppressWarnings("static-access")
	public List<UserData> getAllUser() {
		logger.info("List work");
		List<User> userList = userService.getAllUsers();
		return userDataConverter.userEntityToUserData(userList);
	}

	public void  deleteUser(String email) {
		userService.deleteUser(email); 	
    }
	
	@SuppressWarnings("static-access")
	public UserData findUserByMail(String email) {
		logger.info("FindByMail work");
		User user = userService.findByEmail(email);
		return userDataConverter.userEntityToUserData(user);
		
	}
	
	@SuppressWarnings("static-access")
	public List<UserData> findUserByRole(String role) {
		logger.info("FindByRole work");
		List <User> user = userService.findByRole(role);
		return userDataConverter.userEntityToUserData(user);
		
	}
	
	@SuppressWarnings("static-access")
	public User UpdateUser(String email, UserData userData) {
		logger.info("Update work");
		User user = userDataConverter.UserDataToUser(userData);
		return userService.updateUser(email, user);

	}
	
}