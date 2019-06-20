package com.sgic.internal.login.controller;

import static org.junit.Assert.assertEquals;

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
import org.springframework.web.client.RestClientException;

import com.sgic.internal.login.LoginApplicationTests;


public class LoginApplicationFunctionalitiesTest extends LoginApplicationTests{
  
  @Autowired
  JdbcTemplate jdbcTemplate;
  
  @Before
  public void setup() {
	  
  
  String newUser = "INSERT INTO login.user(email, password,role) VALUES ('hai@gmail.com', 'mathu','sharma')";

  jdbcTemplate.execute(newUser);

  }
  
  @Test
  public void getLoginUserDetailSuccessfull() throws IOException, RestClientException {
   ResponseEntity<String> response =
        testRestTemplate.exchange("http://localhost:8081/login" + "/users", HttpMethod.GET,
           new HttpEntity<>(httpHeaders), String.class);
   assertEquals(HttpStatus.OK, response.getStatusCode());
   }
  
    
  
  @After
  public void tearDown() {

  }
  
  public final class LoginApplicationTest{
    
    public LoginApplicationTest() {
    }
    
    private static final String CAREER_DEVELOPMENT_PLAN_RESPONSE =
        "[ { \\\"email\\\": \\\"iiiiiii\\\", \\\"password\\\": \\\"kala\\\", \\\"role\\\": \\\"user\\\" }, { \\\"email\\\": \\\"kala@gmail.com\\\", \\\"password\\\": \\\"kala\\\", \\\"role\\\": \\\"user\\\" }, { \\\"email\\\": \\\"mathu@gmail.com\\\", \\\"password\\\": \\\"one\\\", \\\"role\\\": \\\"user\\\" } ]";

  }
}
