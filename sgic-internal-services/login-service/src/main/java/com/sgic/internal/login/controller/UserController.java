package com.sgic.internal.login.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.internal.login.controller.dto.UserData;
import com.sgic.internal.login.controller.dto.mapper.UserDataMapper;
import com.sgic.internal.login.entities.User;
import com.sgic.internal.login.repositories.UserRepository;


@RestController
public class UserController {
	
	@Autowired
	private UserDataMapper userDataMapper ;
	
	@Autowired
	private UserRepository userRepository;
	
	private static Logger logger = LogManager.getLogger(UserDataMapper.class);
	
//=====================POST login user details====================================

	 @RequestMapping(value="/user",method=RequestMethod.POST)  
	 public HttpStatus createUser(@Valid @RequestBody UserData userData) {
		userDataMapper.createUser(userData); 
		return HttpStatus.CREATED;
		}

//=========================GET login user details by list==========================	

	 @GetMapping(value = "/users")
	  public List<UserData> getAllDetails(){
		 logger.info("Success");
		  return  userDataMapper.getAllUser();
	  }
	 
//======================GET particular user detail by mail===========================	 
 
	 @GetMapping(value = "/getByUserMail/{email}")
	 public ResponseEntity<UserData> getUserByMail(@PathVariable("email")String email){;
		return  new ResponseEntity<>( userDataMapper.findUserByMail(email),HttpStatus.OK);
		 
	 }

//========================GET all user details for particular role===================	 
	 
	 @GetMapping(value = "/getByUserRole/{role}")
	 public List<UserData> getUserByRole(@PathVariable("role")String role){;
		return userDataMapper.findUserByRole(role);
		 
	 }
	  
//=======================DELETE user detail by the mail	==========================	

	 @DeleteMapping("/user/{email}")
	   public ResponseEntity<?>deleteUser(@PathVariable("email")String email ){ 
		 userDataMapper.deleteUser(email);
		return new ResponseEntity<String>("User detail is Deleted",HttpStatus.OK);
		   
	   }
//=======================UPDATE user detail using mail==================================	 
 
	 @PutMapping("update/{email}")
		public ResponseEntity<String> updateEmployee(@PathVariable(name = "email") String email,
				@RequestBody UserData userData) {
			userDataMapper.UpdateUser(email, userData);
			return new ResponseEntity<>("user updated succesfully", HttpStatus.OK);

		}
//=======================Forgot user password functionality==================================	 
	 
		 @PutMapping("forgotpass/{email}")
			public ResponseEntity<String> updatePassword(@PathVariable(name = "email") String email,String password) {
				userRepository.updatePassword(email, password);
				return new ResponseEntity<>("user updated succesfully", HttpStatus.OK);

			}
		 
//====================================Login Functionality=====================================
//		 @PostMapping("/signin")
//		    public ResponseEntity<?> authenticateUser(@Valid @RequestBody User user) {
//
//		        Authentication authentication = authenticationManager.authenticate(
//		                new UsernamePasswordAuthenticationToken(
//		                        user.getEmail();
//		                        user.getPassword();
//		                )
//		        );
//
//		        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//		        String jwt = tokenProvider.generateToken(authentication);
//		        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
//		    }
}
