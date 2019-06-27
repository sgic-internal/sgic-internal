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

import com.github.tomakehurst.wiremock.http.HttpHeaders;
import com.sgic.internal.login.LoginApplicationTests;
import com.sgic.internal.login.controller.dto.UserData;
import com.sgic.internal.login.entities.User;


public class LoginApplicationFunctionalitiesTest extends LoginApplicationTests{
  
  @Autowired
  JdbcTemplate jdbcTemplate;
  private UserData userData = new UserData();
  private String BASE_URL ="http://localhost:8082/login";
  private String ADD_API_URL="/user";
  private String GET_API_URL="/users";
  private String PUT_API_URL="/updateUser";
  private String DELETE_API_URL="/deleteUser";
  
  private static final String GET_USER_RESPONSE="[{\"email\":\"jaanu\",\"password\":\"ja123\",\"role\":\"user\"}]";
  private static final String PUT_USER_RESPONSE="[{ \\\"email\\\":\\\"jaanu\\\", \\\"password\\\":\\\"ja123\\\", \\\"role\\\":\\\"user\\\" }]";
  private static final String ADD_USER_RESPONSE="{ \\\"email\\\":\\\"jaanu\\\", \\\"password\\\":\\\"ja123\\\", \\\"role\\\":\\\"user\\\" }";
  
  
//=====================Test to get create user detail==================================== 
  @Test
  public void addUser() throws IOException, RestClientException {

	   userData.setEmail("jaanu");
	   userData.setPassword("ja123");
	   userData.setRole("user");
	   
	   HttpEntity<UserData> request = new HttpEntity<UserData>(userData,httpHeaders);


    ResponseEntity<String> PostResponse = testRestTemplate.postForEntity(BASE_URL+ADD_API_URL, request, String.class);
	assertEquals(200, PostResponse.getStatusCodeValue());
	
	ResponseEntity<String> GetResponse = testRestTemplate.exchange(BASE_URL+GET_API_URL, HttpMethod.GET,
			new HttpEntity<>(httpHeaders), String.class);
	assertEquals(HttpStatus.OK, GetResponse.getStatusCode());
	assertEquals(GET_USER_RESPONSE, GetResponse.getBody());
  }
  
//=====================Test to get login user details==================================== 
  @Test
  public void getLoginUserDetailSuccessfull() throws IOException, RestClientException {
   ResponseEntity<String> response =
        testRestTemplate.exchange(BASE_URL + GET_API_URL, HttpMethod.GET,
           new HttpEntity<>(httpHeaders), String.class);
   assertEquals(HttpStatus.OK, response.getStatusCode());
   assertEquals(GET_USER_RESPONSE,GET_USER_RESPONSE);
   }

//=====================Test to delete login user details====================================  

  
  @After
  public void tearDown() {

  }
  
  
}
