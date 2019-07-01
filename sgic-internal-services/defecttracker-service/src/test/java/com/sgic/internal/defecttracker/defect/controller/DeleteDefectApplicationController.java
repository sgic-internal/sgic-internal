package com.sgic.internal.defecttracker.defect.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.Date;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.sgic.internal.defecttracker.defect.DefectApplicationTest;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectData;


public class DeleteDefectApplicationController extends DefectApplicationTest {
    
	private DefectData defectData = new DefectData();
	
	private String BASE_URL = "http://localhost:8081/defectservices";
	private String ADD_API_URL = "/saveDefect";
	private String GET_API_URL="/getAllDefects";
	private String DELETE_API_URL = "/deleteDefect/";
	private Long defectId =1L;

	
	private static final String GET_DEFECT_RESPONSE="[{\"defectId\":1,\"projectId\":1,\"moduleId\":1,\"severityId\":1,\"priorityId\":1,\"typeId\":1,\"statusId\":1,\"defectDescription\":\"login not work\",\"stepsToRecreate\":\"redo the application\",\"assignTo\":\"pinky\",\"reassignTo\":\"thanu\",\"enteredBy\":\"mathu\",\"fixedBy\":\"mathu\",\"commentId\":1,\"attachmentId\":1,\"dateAndTime\":\"2017-05-05\"}]";
	private static final String ADD_DEFECT_RESPONSE="{\\\"defectId\\\":\\\"defect001\\\",\\\"projectId\\\":\\\"defect\\\",\\\"moduleId\\\":\\\"login'\\\",\\\"severityId\\\":1,\\\"priorityId\\\":1,\\\"typeId\\\":1,\\\"statusId\\\":1,\\\"defectDescription\\\":\\\"login not work\\\",\\\"stepsToRecreate\\\":\\\"redo the application\\\",\\\"assignTo\\\":\\\"pinky\\\",\\\"reassignTo\\\":\\\"thanu\\\",\\\"enteredBy\\\":\\\"mathu\\\",\\\"fixedBy\\\":\\\"mathu\\\",\\\"commentId\\\":1,\\\"attachmentId\\\":1,\\\"dateAndTime\\\":\\\"2017-05-05\\\"}";  
	private static final String DELETE_DEFECT_RESPONSE = "Deleted Successfully";
	

	@Test
	public void deleteDefect() throws IOException, RestClientException {
		
		//defectData.setDefectId(1L);
		   defectData.setProjectId(1L);
		   defectData.setModuleId(1L);
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
		   defectData.setDateAndTime(Date.valueOf("2017-05-05"));
		   

  
	HttpEntity<DefectData> request  = new HttpEntity<DefectData>(defectData,httpHeaders);
	ResponseEntity<String> postResponse = testRestTemplate.postForEntity(BASE_URL+ ADD_API_URL , request,String.class);
	assertEquals(200,postResponse.getStatusCodeValue());

	ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL+ DELETE_API_URL + defectId,HttpMethod.DELETE, new HttpEntity<>(httpHeaders), String.class);
	assertEquals(200, response.getStatusCodeValue());

	assertEquals(DELETE_DEFECT_RESPONSE, DELETE_DEFECT_RESPONSE);


	}
}
