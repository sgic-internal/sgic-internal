package com.sgic.internal.defecttracker.project.controller;

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

import com.sgic.internal.defecttracker.project.ProjectApplicationTest;



public class ProjectDevelopmentTest extends ProjectApplicationTest{
	
	 @Autowired
	 JdbcTemplate jdbcTemplate;
	 
	 @Before
	 public void setup() {
	 
	 
	 String newUser = "INSERT INTO project_service.project (project_id, config_id, duration,end_date,project_name,start_date,status,type)VALUES ('5', 'sajit','ansar','2019-06-12','ss','2019-06-12','ss','ff')";
	 //String careerDevelopmentPlan = "INSERT INTO employee.careerdevelopmentplan (id, name) VALUES (2, 'careerDevelopmentOne')";
	  //String userCareerDevelopmentPlanCompany = "INSERT INTO employee.user_career_development_plan_company (id, cdp_Id,user_Id,status) VALUES (2,2,2,'Planning' )";
	 jdbcTemplate.execute(newUser);
	  //jdbcTemplate.execute(careerDevelopmentPlan);
	   //jdbcTemplate.execute(userCareerDevelopmentPlanCompany);
	   
	 }
	 
	 @Test
	 public void getProjectDevelopmentTestSuccessfull() throws IOException, RestClientException {
	   ResponseEntity<String> response =
	       testRestTemplate.exchange("http://localhost:8080/project_service" + "/ViewProject", HttpMethod.GET,
	           new HttpEntity<>(httpHeaders), String.class);
	   assertEquals(HttpStatus.OK, response.getStatusCode());
	  }
	   
	 
	 @After
	 public void tearDown() {

	 }
	 
	  public final class ProjectDevelopmentTestConstant{
	    
	    public ProjectDevelopmentTestConstant() {
	    }
	    
	    private static final String PROJECT_DEVELOPMENT_TEST_RESPONSE =
	        "[{ \"projectId\": 1, \"projectName\": \"ggggjh\", \"type\": \"spring\", \"startDate\": \"2018-07-12\", \"endDate\": \"2019-02-16\", \"duration\": \"2 year\", \"status\": \"open\", \"configId\": null }]";
	  }

}
