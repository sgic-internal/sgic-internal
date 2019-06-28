package com.sgic.internal.defecttracker.project.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.sgic.internal.defecttracker.project.ProjectApplicationTest;
import com.sgic.internal.defecttracker.project.controller.dto.ProjectDto;

public class DeleteProject  extends  ProjectApplicationTest {

@SuppressWarnings("unused")
private ProjectDto projectDto = new ProjectDto();

private String BASE_URL = "http://localhost:8080/project_service";
private String ADD_API_URL = "/createprojec";
private String DELETE_API_URL = "/deleteById/";
private String projectId ="1";

@SuppressWarnings("unused")
private static final String ADD_PROJECT_RESPONSE ="[{\"projectId\":\"1\",\"projectName\":\"DefectTracker\",\"type\":\"Sweet 1\",\"startDate\":\"2017-05-06\",\"endDate\":\"2017-05-05\",\"duration\":\"week 7month\",\"status\":\"New\",\"configId\":\"03\"}]";
@SuppressWarnings("unused")
private static final String GET_PROJECT_RESPONSE ="[{\"projectId\":\"1\",\"projectName\":\"DefectTracker\",\"type\":\"Sweet 1\",\"startDate\":\"2017-05-06\",\"endDate\":\"2017-05-05\",\"duration\":\"week 7month\",\"status\":\"New\",\"configId\":\"03\"}]";
private static final String DELETE_PROJECT_RESPONSE = "Deleted Successfully";

@Test
public void deleteProject() throws IOException, RestClientException {

ProjectDto projectDto =new ProjectDto ("1","DefectTracker","Sweet 1","2017-05-06","2017-05-05","week 7month","New","03");
HttpEntity<ProjectDto> request  = new HttpEntity<ProjectDto>(projectDto,httpHeaders);
ResponseEntity<String> postResponse = testRestTemplate.postForEntity(BASE_URL+ ADD_API_URL , request,String.class);
assertEquals(200,postResponse.getStatusCodeValue());

ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL+ DELETE_API_URL + projectId,HttpMethod.DELETE, new HttpEntity<>(httpHeaders), String.class);
//assertEquals(200, getResponse.getStatusCodeValue());
assertEquals(200, response.getStatusCodeValue());

assertEquals(DELETE_PROJECT_RESPONSE, DELETE_PROJECT_RESPONSE);


}
}