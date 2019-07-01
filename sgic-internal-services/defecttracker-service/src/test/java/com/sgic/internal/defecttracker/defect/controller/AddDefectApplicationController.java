package com.sgic.internal.defecttracker.defect.controller;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;


import com.sgic.internal.defecttracker.defect.DefectApplicationTest;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectData;

public class AddDefectApplicationController extends DefectApplicationTest{
	
	@Autowired
	  JdbcTemplate jdbcTemplate;
	
	  private DefectData defectData = new DefectData();
	  private String BASE_URL ="http://localhost:8080/defectservices";
	  private String ADD_API_URL="/saveDefect";
	  private String GET_API_URL="/getAllDefects";
	  
	  private static final String GET_DEFECT_RESPONSE="[{\"defectId\":\"defect001\",\"projectId\":\"defect\",\"moduleId\":\"login\",\"severityId\":1,\"priorityId\":1,\"typeId\":1,\"statusId\":1,\"defectDescription\":\"login not work\",\"stepsToRecreate\":\"redo the application\",\"assignTo\":\"pinky\",\"reassignTo\":\"thanu\",\"enteredBy\":\"mathu\",\"fixedBy\":\"mathu\",\"commentId\":1,\"attachmentId\":1,\"dateAndTime\":\"2017-05-05\"}]";
	  private static final String ADD_DEFECT_RESPONSE="{\\\"defectId\\\":\\\"defect001\\\",\\\"projectId\\\":\\\"defect\\\",\\\"moduleId\\\":\\\"login'\\\",\\\"severityId\\\":1,\\\"priorityId\\\":1,\\\"typeId\\\":1,\\\"statusId\\\":1,\\\"defectDescription\\\":\\\"login not work\\\",\\\"stepsToRecreate\\\":\\\"redo the application\\\",\\\"assignTo\\\":\\\"pinky\\\",\\\"reassignTo\\\":\\\"thanu\\\",\\\"enteredBy\\\":\\\"mathu\\\",\\\"fixedBy\\\":\\\"mathu\\\",\\\"commentId\\\":1,\\\"attachmentId\\\":1,\\\"dateAndTime\\\":\\\"2017-05-05\\\"}";
	  
	  
	//=====================Test to create defect detail==================================== 
	  @Test
	  public void addDefect() throws IOException, RestClientException {

		   defectData.setDefectId("defect001");
		   defectData.setProjectId("defect");
		   defectData.setModuleId("login");
		   defectData.setSeverityId(1);
		   defectData.setPriorityId(1);
		   defectData.setTypeId(1);
		   defectData.setStatusId(1);
		   defectData.setDefectDescription("login not work");
		   defectData.setStepsToRecreate("redo the application");
		   defectData.setAssignTo("pinky");
		   defectData.setReassignTo("thanu");
		   defectData.setEnteredBy("mathu");
		   defectData.setFixedBy("mathu");
		   defectData.setCommentId(1);
		   defectData.setAttachmentId(1);
		   defectData.setDateAndTime("2017-05-05");
		   
		   
		   HttpEntity<DefectData> request = new HttpEntity<DefectData>(defectData,httpHeaders);


	    ResponseEntity<String> PostResponse = testRestTemplate.postForEntity(BASE_URL+ADD_API_URL, request, String.class);
		assertEquals(200, PostResponse.getStatusCodeValue());
		
		ResponseEntity<String> GetResponse = testRestTemplate.exchange(BASE_URL+GET_API_URL, HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, GetResponse.getStatusCode());
		assertEquals(GET_DEFECT_RESPONSE, GetResponse.getBody());
	  }
	  

}
