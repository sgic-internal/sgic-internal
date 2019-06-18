package com.sgic.internal.login.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.sgic.internal.login.controller.dto.UserData;
import com.sgic.internal.login.controller.dto.mapper.UserDataMapper;


@RestController
public class UserController {
	
	@Autowired
	private UserDataMapper userDataMapper ;
	
	private static Logger logger = LogManager.getLogger(UserDataMapper.class);

	 @RequestMapping(value="/user",method=RequestMethod.POST)  
	 public HttpStatus createUser(@Valid @RequestBody UserData userData) {
		userDataMapper.createUser(userData); 
		return HttpStatus.CREATED;
		}
	 
	 @GetMapping(value = "/users")
	  public List<UserData> getAllDetails(){
		 logger.info("Success");
		  return  userDataMapper.getAllUser();
	  }
	 
	 @DeleteMapping("/user/{email}")
	   public ResponseEntity<?>deleteUser(@PathVariable("email")String email ){ 
		 userDataMapper.deleteUser(email);
		return new ResponseEntity<String>("User detail is Deleted",HttpStatus.OK);
		   
	   }
	 
}
