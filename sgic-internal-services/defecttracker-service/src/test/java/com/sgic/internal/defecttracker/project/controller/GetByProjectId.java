package com.sgic.internal.defecttracker.project.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;

import com.sgic.internal.defecttracker.project.ProjectApplicationTest;
import com.sgic.internal.defecttracker.project.controller.dto.ProjectDto;



public class GetByProjectId extends ProjectApplicationTest {

@Autowired
JdbcTemplate jdbcTemplate;

@SuppressWarnings("unused")
private ProjectDto projectDto = new ProjectDto();

//	private ProjectData projectData2 = new ProjectData();
private String projectId="1";

private static final String GET_BY_ID_RESPONSE ="{\"projectId\":\"pro1\",\"projectName\":\"Timetracker\",\"type\":\"springboot\",\"startDate\":\"2018-07-17\",\"endDate\":\"2018-02-26\",\"duration\":\"1year\",\"status\":\"open\",\"configId\":\"021\"}";

@Test
public void GetByProjectId() throws IOException {

	ProjectDto projectData = new ProjectDto("pro1","Timetracker","springboot","2018-07-17","2018-02-26","1year","open","021");
HttpHeaders httpHeaders = new HttpHeaders();
HttpEntity<ProjectDto> request = new HttpEntity<ProjectDto>(projectData, httpHeaders);
ResponseEntity<String> postresponse =testRestTemplate.postForEntity("http://localhost:8081/project_service/" + "/createproject", request, String.class);

ResponseEntity<String> getbyidresponse = testRestTemplate.exchange("http://localhost:8081/project_service" + "/getProjectById" + "/pro1" , HttpMethod.GET,
new HttpEntity<>(httpHeaders), String.class);
assertEquals(200, postresponse.getStatusCodeValue());
assertEquals(GET_BY_ID_RESPONSE,getbyidresponse.getBody());
assertEquals(HttpStatus.OK, getbyidresponse.getStatusCode());
}

}