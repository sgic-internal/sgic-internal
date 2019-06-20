package com.sgic.internal.login.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.internal.login.controller.dto.UserData;
import com.sgic.internal.login.entities.User;
import com.sgic.internal.login.repositories.UserRepository;
import com.sgic.internal.login.services.UserService;


@Service
public class UserServiceImpl implements UserService {
	
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    
//   @Autowired
//    public UserServiceImpl(UserRepository userRepository,
//            BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userRepository = userRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//    
//    @Override
//    public User createUser(User userDto) {
//        UserDto returnValue = new UserDto();
//        
//  
//        // Generate secure password
//        userDto.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
//        UserEntity userEntity = new UserEntity();
//        BeanUtils.copyProperties(userDto, userEntity);
//        // Record data into a database
//        userEntity = userRepository.save(userEntity);
// 
//         ...
//        return returnValue;
//    }

	@Autowired
	private UserRepository userRepository;
	
//=====================================================================================
//Creating new users 
	@Override
	@Transactional(readOnly=false)
	public User createUsers(User user) {
		User responseUser= userRepository.save(user);
		return responseUser;
	}

//=====================================================================================	
//List all the users
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll() ;
	}
	
//=====================================================================================
//check the user email address is already exists or not
	@Override
	public boolean isUserAlreadyExist(String email) {
		return userRepository.existsById(email) ;
	}
	
//=====================================================================================	
//Get the user detail using the mail address
	@Override
	public User findByEmail(String email) {
		
		return userRepository.getByEmail(email);
	}
	
//=====================================================================================	
//Delete user details
	@Override
	public void deleteUser(String email) {
		userRepository.deleteById(email);
	}

//=====================================================================================	
//Update user details
	@Override
	public User updateUser(String email, User user) {
		
			if (userRepository.getOne(email) != null) {
				user.setEmail(email);
				userRepository.save(user);
			}
		
		return user;
	}

//=====================================================================================	
//Get the user detail using the role
	@Override
	public List <User>findByRole(String role) {
		return userRepository.getByRole(role);
	}
}
