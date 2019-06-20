package com.sgic.internal.login.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import com.sgic.internal.login.LoginApplicationTests;
import com.sgic.internal.login.entities.User;


public class LoginApplicationFunctionalitiesTest extends LoginApplicationTests{
  
  @Autowired
  JdbcTemplate jdbcTemplate;
  
  @Before
  public void setup() {
	  
  
//  String newUser = "INSERT INTO login.user(email, password,role) VALUES ('pppp', 'ppp','ooo')";
//  jdbcTemplate.execute(newUser);

  }
  
  @Test
  public void getLoginUserDetailSuccessfull() throws IOException, RestClientException {
   ResponseEntity<String> response =
        testRestTemplate.exchange("http://localhost:8081/login" + "/users", HttpMethod.GET,
           new HttpEntity<>(httpHeaders), String.class);
   assertEquals(HttpStatus.OK, response.getStatusCode());
   }
 
  @Test
  public void getLoginUserByMailSuccessfull() throws IOException, RestClientException {
	  User user = testRestTemplate.getForObject("http://localhost:8081/login" + "/getByUserMail/mathu@gmail.com", User.class);
     assertNotNull(user);
   }
  
    @Test
    public void createLoginUserDetails() throws IOException, RestClientException{
    	User user= new User();
    	user.setEmail("mathu");
    	user.setPassword("m123");
    	user.setRole("user");
    	
    	testRestTemplate.postForEntity("http://localhost:8081/login" + "/user",HttpMethod.POST, User.class);
    }
    
    @Test
    public void deleteLoginUserDetail()throws IOException, RestClientException{
    	String email ="mathu@gmail.com";
    	User user = testRestTemplate.getForObject("http://localhost:8081/login" + "/user/"+email, User.class);
    	assertNotNull(user);
    	
    	testRestTemplate.delete("http://localhost:8081/login" + "/user/"+email);
    	try {
    		
    		user = testRestTemplate.getForObject("http://localhost:8081/login" + "/user/"+email, User.class);
    	}catch(final HttpClientErrorException e) {
    	  assertEquals(e.getStatusCode(),HttpStatus.NOT_FOUND);
    	}
    }
  
  @After
  public void tearDown() {

  }
  
  public final class LoginApplicationTest{
    
    public LoginApplicationTest() {
    }
    
    private static final String LOGIN_APPLICATION_DETAILS =
        "[ { \\\"email\\\": \\\"iiiiiii\\\", \\\"password\\\": \\\"kala\\\", \\\"role\\\": \\\"user\\\" }, { \\\"email\\\": \\\"kala@gmail.com\\\", \\\"password\\\": \\\"kala\\\", \\\"role\\\": \\\"user\\\" }, { \\\"email\\\": \\\"mathu@gmail.com\\\", \\\"password\\\": \\\"one\\\", \\\"role\\\": \\\"user\\\" } ]";

  }
}
