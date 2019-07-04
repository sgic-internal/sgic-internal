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
//import com.sgic.internal.defecttracker.project.controller.dto.ProjectData;
//
//public class UpdateProject extends ProjectApplicationTest {
//
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
//	@Autowired
//	ProjectData projectData;
//
//	@Test
//	public void updateProjetc() throws IOException, RestClientException {
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
//				.postForEntity("http://localhost:8080/project_service" + "/createproject", request, String.class);
//		assertEquals(200, response.getStatusCodeValue());
//
//		ProjectData projectData1=new ProjectData("Pro1","DefectTracker","2019-06-17","configId","duration","2019-06-12","status","Medium");
//			HttpEntity<ProjectData> updaterequest = new HttpEntity<ProjectData>(projectData1, httpHeaders);
//			ResponseEntity<String> putResponse = testRestTemplate.exchange("http://localhost:8080/project_service" + "/updateProject"+"/Pro1" , HttpMethod.PUT, updaterequest,
//					String.class);
//			assertEquals(200, putResponse.getStatusCodeValue());
//			
//		ResponseEntity<String> getresponse = testRestTemplate.exchange(
//				"http://localhost:8080/project_service" + "/GetAllproject" + "/Pro1", HttpMethod.GET ,String.class);
//				new HttpEntity<>(httpHeaders), String.class);
//		assertEquals(HttpStatus.OK, getresponse.getStatusCode());
//		
//				Object body = "[{\"projectId\":\"Pro1\",\"projectName\":\"DefectTracker\",\"type\":\"Medium\",\"startDate\":\"2019-06-12\",\"endDate\":\"2019-06-17\",\"duration\":\"duration\",\"status\":\"status\",\"configId\":\"configId\"}]";
//		assertEquals(body, getresponse.getBody());
//	}
//
//	@After
//	public void tearDown() {
//
//	}
//}
