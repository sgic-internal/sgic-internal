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

import com.sgic.internal.login.HrmEmployeeApplicationTests;


public class CareerDevelopmentPlanCompanyTest extends HrmEmployeeApplicationTests{
  
  @Autowired
  JdbcTemplate jdbcTemplate;
  
  @Before
  public void setup() {
	  
  
  String newUser = "INSERT INTO loginservice.user (email, password,role) VALUES ('mathu@gmail.com', 'mathu','sharma')";

  jdbcTemplate.execute(newUser);

  }
  
  @Test
  public void getCareerDevelopmentPlanCompanySuccessfull() throws IOException, RestClientException {
    ResponseEntity<String> response =
        testRestTemplate.exchange("http://localhost:8081/loginservice" + "/users", HttpMethod.GET,
            new HttpEntity<>(httpHeaders), String.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
   }
  
  @Test
  public void getCareerDevelopmentPlanCompanySuccessfull1() throws IOException, RestClientException {
    ResponseEntity<String> response =
        testRestTemplate.exchange("http://localhost:8081/loginservice" + "/users", HttpMethod.GET,
            new HttpEntity<>(httpHeaders), String.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
   }
  
    
  
  @After
  public void tearDown() {

  }
  
  public final class CareerDevelopmentPlanConstant{
    
    public CareerDevelopmentPlanConstant() {
    }
    
    private static final String CAREER_DEVELOPMENT_PLAN_RESPONSE =
        "[ { \\\"email\\\": \\\"iiiiiii\\\", \\\"password\\\": \\\"kala\\\", \\\"role\\\": \\\"user\\\" }, { \\\"email\\\": \\\"kala@gmail.com\\\", \\\"password\\\": \\\"kala\\\", \\\"role\\\": \\\"user\\\" }, { \\\"email\\\": \\\"mathu@gmail.com\\\", \\\"password\\\": \\\"one\\\", \\\"role\\\": \\\"user\\\" } ]";

  }
}
