package com.sgic.internal.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ApiResponse;
import com.sgic.internal.login.controller.dto.UserData;
import com.sgic.internal.login.entities.User;
import com.sgic.internal.login.services.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;

	 @RequestMapping(value="/user",method=RequestMethod.POST)  
	  public ResponseEntity<Object> createUser(@RequestBody UserData userData) {
	    User user =new User();
	    user.setEmail(userData.getEmail());
	    user.setPassword(userData.getPassword());
	    user.setRole(userData.getRole());
	    userservice.createUsers(user);
	    
	    return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
	   
	  }

	 @GetMapping(value = "/viewUser")
	  public List<User> getAllDetails(){
		  return userservice.getAllUsers();
	  }
	 
	 @DeleteMapping("/deleteUser/{email}")
		public ResponseEntity<?> deleteDefectTask(@PathVariable String email){
		 userservice.deleteUser(email);
			return new ResponseEntity<String>("User detail Deleted",HttpStatus.OK);
		}
}
