package com.sgic.internal.login.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;

import com.sgic.internal.login.controller.dto.UserData;
import com.sgic.internal.login.entities.User;

@Service
public class UserDataConverter {
	
	private static Logger logger = LogManager.getLogger(User.class);

	//To list all the user details
	public static List<UserData> userEntityToUserData(List<User> userList){
		
		if(userList!= null) {
			logger.info("Coverting UserEntity to UserData");
		List<UserData> listUserData = new ArrayList<>();
		for(User user :userList) {
			UserData userdata = new UserData();
			
			userdata.setEmail(user.getEmail());
			userdata.setPassword(user.getPassword());
			userdata.setRole(user.getRole());
			
			listUserData.add(userdata);
				
		}
		return listUserData;
	}
		return null;
}
	
	
	//To convert Entity to DTO
	    @SuppressWarnings("unused")
		public static UserData userEntityToUserData(User user) {
			UserData userData = new UserData();
			
			if(userData != null) {
				logger.info("Coverting Entity to DTO");
				userData.setEmail(user.getEmail());
				userData.setPassword(user.getPassword());
				userData.setRole(user.getRole());
				
				return userData;
			}
			return null;	
		}
	
	
	
   //To convert DTO to Entity 
	public static User UserDataToUser(UserData userData) {
		User user = new User();
		if(userData != null) {
			logger.info("Coverting UserData to UserEntity");
			
			user.setEmail(userData.getEmail());
			user.setPassword(userData.getPassword());
			user.setRole(userData.getRole());
			
			return user;
		}
		return null;	
	}
}