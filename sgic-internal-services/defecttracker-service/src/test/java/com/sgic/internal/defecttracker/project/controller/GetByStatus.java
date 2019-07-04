<<<<<<< HEAD
package com.sgic.internal.defecttracker.project.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
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

public class GetByStatus extends ProjectApplicationTest {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ProjectDto projectDto;
	
	private String BASE_URL = "http://localhost:8080/project_service";
	
	@Test
	public void GetByStats() throws IOException, RestClientException {
		projectDto.setProjectId("Pro1");
		projectDto.setProjectName("DefectTracker");
		projectDto.setEndDate("2019-06-17");
		projectDto.setConfigId("configId");
		projectDto.setDuration("duration");
		projectDto.setStartDate("2019-06-12");
		projectDto.setStatus("status");
		projectDto.setType("Medium");
		
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<ProjectDto> request = new HttpEntity<ProjectDto>(projectDto, httpHeaders);
		
		ResponseEntity<String> response = testRestTemplate
				.postForEntity(BASE_URL + "/createproject", request, String.class);
		assertEquals(200, response.getStatusCodeValue());
		ResponseEntity<String> responseName = testRestTemplate.exchange(
				BASE_URL + "/getstatus"  + "/status", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, responseName.getStatusCode());
		Object body = "[{\"projectId\":\"Pro1\",\"projectName\":\"DefectTracker\",\"type\":\"Medium\",\"startDate\":\"2019-06-12\",\"endDate\":\"2019-06-17\",\"duration\":\"duration\",\"status\":\"status\",\"configId\":\"configId\"}]";
		assertEquals(body, responseName.getBody());
	}
	
	@After
	public void tearDown() {
		
		
	}

}
=======
//package com.sgic.internal.defecttracker.project.controller;
//
//import static org.junit.Assert.assertEquals;
//
//import java.io.IOException;
//
//import org.junit.After;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.client.RestClientException;
//
//import com.sgic.internal.defecttracker.project.ProjectApplicationTest;
//import com.sgic.internal.defecttracker.project.controller.data.ProjectData;
//
//public class GetByStatus extends ProjectApplicationTest {
//	
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	
//	@Autowired
//	ProjectData projectData;
//	
//	private String BASE_URL = "http://localhost:8080/project_service";
//	
//	@Test
//	public void GetByStats() throws IOException, RestClientException {
//		projectData.setProjectId("Pro1");
//		projectData.setProjectName("DefectTracker");
//		projectData.setEndDate("2019-06-17");
//		projectData.setConfigId("configId");
//		projectData.setDuration("duration");
//		projectData.setStartDate("2019-06-12");
//		projectData.setStatus("status");
//		projectData.setType("Medium");
//		
//		HttpHeaders httpHeaders = new HttpHeaders();
//		HttpEntity<ProjectData> request = new HttpEntity<ProjectData>(projectData, httpHeaders);
//		
//		ResponseEntity<String> response = testRestTemplate
//				.postForEntity(BASE_URL + "/createproject", request, String.class);
//		assertEquals(200, response.getStatusCodeValue());
//		ResponseEntity<String> responseName = testRestTemplate.exchange(
//				BASE_URL + "/getstatus"  + "/status", HttpMethod.GET,
//				new HttpEntity<>(httpHeaders), String.class);
//		assertEquals(HttpStatus.OK, responseName.getStatusCode());
//		Object body = "[{\"projectId\":\"Pro1\",\"projectName\":\"DefectTracker\",\"type\":\"Medium\",\"startDate\":\"2019-06-12\",\"endDate\":\"2019-06-17\",\"duration\":\"duration\",\"status\":\"status\",\"configId\":\"configId\"}]";
//		assertEquals(body, responseName.getBody());
//	}
//	
//	@After
//	public void tearDown() {
//		
//		
//	}
//
//}
>>>>>>> 1722263d35ed290770f31635785ba5317b961c1a
