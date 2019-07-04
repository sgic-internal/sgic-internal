package com.sgic.internal.defecttracker.defect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.sgic.internal.defecttracker.defect.DefectApplicationTest;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectData;

public class GetApplicationController extends DefectApplicationTest {
	
	@Autowired
	  JdbcTemplate jdbcTemplate;
	
	  private DefectData defectData = new DefectData();
	  private String BASE_URL ="http://localhost:8081/defectservices";
	  private String GET_API_URL="/getAllDefects";
	  
	  private static final String GET_DEFECT_RESPONSE="[{\"defectId\":\"defect001\",\"projectId\":\"defect\",\"moduleId\":\"login\",\"severityId\":1,\"priorityId\":1,\"typeId\":1,\"statusId\":1,\"defectDescription\":\"login not work\",\"stepsToRecreate\":\"redo the application\",\"assignTo\":\"pinky\",\"reassignTo\":\"thanu\",\"enteredBy\":\"mathu\",\"fixedBy\":\"mathu\",\"commentId\":1,\"attachmentId\":1,\"dateAndTime\":\"2017-05-05\"}]";
	  
	  @Test
	  public void getDefectDetailSuccessfull() throws IOException, RestClientException {
	   ResponseEntity<String> response =
	        testRestTemplate.exchange(BASE_URL + GET_API_URL, HttpMethod.GET,
	           new HttpEntity<>(httpHeaders), String.class);
	   assertEquals(HttpStatus.OK, response.getStatusCode());
	   assertEquals(GET_DEFECT_RESPONSE,GET_DEFECT_RESPONSE);
	   }
	  
	  
	  
}
