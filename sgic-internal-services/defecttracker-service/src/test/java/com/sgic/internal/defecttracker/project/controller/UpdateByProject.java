<<<<<<< HEAD
=======
<<<<<<< HEAD
package com.sgic.internal.defecttracker.project.controller;


import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;

import com.sgic.internal.defecttracker.project.ProjectApplicationTest;
import com.sgic.internal.defecttracker.project.controller.dto.ProjectDto;


public class UpdateByProject extends ProjectApplicationTest{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
//	INSERT INTO `project_service`.`project` (`project_id`, `config_id`, `duration`, `end_date`, `project_name`, `start_date`, `status`, `type`) VALUES ('1', 'nn', 'nn', '2019-02-03', 'mm', '2019-02-03', 'nn', 'nn');

	@Before
	public void setup() {
		String newSql1 = "INSERT INTO project_service.project (`project_id`, `config_id`, `duration`, `end_date`, `project_name`, `start_date`, `status`, `type`) VALUES ('1', 'nn', 'nn', '2019-02-03', 'nn', '2019-02-03', 'nn', 'nn')";
//		String newSql2 = "INSERT INTO project_service.project (projectName,type,startDate,endDate,duration,status,configId) VALUES ('jazz','hikk','2019-02-08','2019-05-09','hikk','hinn','mm')";
//		String newSql3 = "INSERT INTO project_service.project (projectName,type,startDate,endDate,duration,status,configId) VALUES ('mercy','hill','2019-02-01','2019-05-08','hinn','himm','himm')";
	
		jdbcTemplate.execute(newSql1);
//		jdbcTemplate.execute(newSql2);
//		jdbcTemplate.execute(newSql3);
	}

	private String BASE_URL = "http://localhost:8080/project_service";
	
	//private static final String GET_ALL_PROJECT = "[{\"project_id\":1,\"config_id\":hi,\"duration\":hi,\"end_date\":2019-05-06,\"project_name\":MERCY,\"start_date\":2019-02-03,\"status\":hi,\"type\":hi}]";

	private static final String UPDATE_DEFECT_TYPE = "{\"projectId\":\"1\",\"projectName\":\"nn\",\"type\":\"nn\",\"startDate\":\"2019-02-03\",\"endDate\":\"2019-02-03\",\"duration\":\"nn\",\"status\":\"nn\",\"configId\":\"nn\"}";
	private static final String CHECK_UPDATE_DEFECT_TYPE ="{\"projectId\":\"1\",\"projectName\":\"mercy\",\"type\":\"mercy\",\"startDate\":\"2019-06-12\",\"endDate\":\"2019-06-17\",\"duration\":\"mercy\",\"status\":\"mercy\",\"configId\":\"mercy\"}";
	
	ProjectDto projectDto = new ProjectDto();
	
	// Testing for get all project types
	
	@Test
	public void Updateproject() throws IOException, RestClientException {
		String projectId = "1";
		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/getProjectById/" + projectId, HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(UPDATE_DEFECT_TYPE, getResponse.getBody());
		projectDto.setProjectId("1");
		projectDto.setProjectName("mercy");
		projectDto.setEndDate("2019-06-17");
		projectDto.setConfigId("mercy");
		projectDto.setDuration("mercy");
		projectDto.setStartDate("2019-06-12");
		projectDto.setStatus("mercy");
		projectDto.setType("mercy");
		
		HttpEntity<ProjectDto> request = new HttpEntity<ProjectDto>(projectDto, httpHeaders);
		testRestTemplate.exchange(BASE_URL + "/updateProject/" + projectId, HttpMethod.PUT,
				request, String.class);
		
		ResponseEntity<String> getUpdatedResponse = testRestTemplate.exchange(BASE_URL + "/getProjectById/" + projectId, HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(CHECK_UPDATE_DEFECT_TYPE, getUpdatedResponse.getBody());
	
//		ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL + "/GetAllproject", HttpMethod.GET,
=======
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
//package com.sgic.internal.defecttracker.project.controller;
//
//
//import static org.junit.Assert.assertEquals;
//
//import java.io.IOException;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.client.RestClientException;
//
//import com.sgic.internal.defecttracker.project.ProjectApplicationTest;
<<<<<<< HEAD
//import com.sgic.internal.defecttracker.project.controller.dto.ProjectDto;
=======
//import com.sgic.internal.defecttracker.project.controller.data.ProjectData;
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
//
//
//public class UpdateByProject extends ProjectApplicationTest{
//	
//	@Autowired
//	JdbcTemplate jdbcTemplate;
////	INSERT INTO `project_service`.`project` (`project_id`, `config_id`, `duration`, `end_date`, `project_name`, `start_date`, `status`, `type`) VALUES ('1', 'nn', 'nn', '2019-02-03', 'mm', '2019-02-03', 'nn', 'nn');
//
//	@Before
//	public void setup() {
//		String newSql1 = "INSERT INTO project_service.project (`project_id`, `config_id`, `duration`, `end_date`, `project_name`, `start_date`, `status`, `type`) VALUES ('1', 'nn', 'nn', '2019-02-03', 'nn', '2019-02-03', 'nn', 'nn')";
////		String newSql2 = "INSERT INTO project_service.project (projectName,type,startDate,endDate,duration,status,configId) VALUES ('jazz','hikk','2019-02-08','2019-05-09','hikk','hinn','mm')";
////		String newSql3 = "INSERT INTO project_service.project (projectName,type,startDate,endDate,duration,status,configId) VALUES ('mercy','hill','2019-02-01','2019-05-08','hinn','himm','himm')";
//	
//		jdbcTemplate.execute(newSql1);
////		jdbcTemplate.execute(newSql2);
////		jdbcTemplate.execute(newSql3);
//	}
//
<<<<<<< HEAD
//	private String BASE_URL = "http://localhost:8081/project_service";
=======
//	private String BASE_URL = "http://localhost:8080/project_service";
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
//	
//	//private static final String GET_ALL_PROJECT = "[{\"project_id\":1,\"config_id\":hi,\"duration\":hi,\"end_date\":2019-05-06,\"project_name\":MERCY,\"start_date\":2019-02-03,\"status\":hi,\"type\":hi}]";
//
//	private static final String UPDATE_DEFECT_TYPE = "{\"projectId\":\"1\",\"projectName\":\"nn\",\"type\":\"nn\",\"startDate\":\"2019-02-03\",\"endDate\":\"2019-02-03\",\"duration\":\"nn\",\"status\":\"nn\",\"configId\":\"nn\"}";
//	private static final String CHECK_UPDATE_DEFECT_TYPE ="{\"projectId\":\"1\",\"projectName\":\"mercy\",\"type\":\"mercy\",\"startDate\":\"2019-06-12\",\"endDate\":\"2019-06-17\",\"duration\":\"mercy\",\"status\":\"mercy\",\"configId\":\"mercy\"}";
//	
<<<<<<< HEAD
//	ProjectDto projectDto = new ProjectDto();
=======
//	ProjectData projectData = new ProjectData();
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
//	
//	// Testing for get all project types
//	
//	@Test
<<<<<<< HEAD
//	public void UpdateByproject() throws IOException, RestClientException {
//		String projectId = "1";
//		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/getProjectById/" + projectId, HttpMethod.GET,
//				new HttpEntity<>(httpHeaders), String.class);
//		assertEquals(UPDATE_DEFECT_TYPE, getResponse.getBody());
//		projectDto.setProjectId("1");
//		projectDto.setProjectName("mercy");
//		projectDto.setEndDate("2019-06-17");
//		projectDto.setConfigId("mercy");
//		projectDto.setDuration("mercy");
//		projectDto.setStartDate("2019-06-12");
//		projectDto.setStatus("mercy");
//		projectDto.setType("mercy");
//		
//		HttpEntity<ProjectDto> request = new HttpEntity<ProjectDto>(projectDto, httpHeaders);
=======
//	public void Updateproject() throws IOException, RestClientException {
//		String projectId = "1";
//		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/getProjectById/" + projectId, HttpMethod.GET,
>>>>>>> 1722263d35ed290770f31635785ba5317b961c1a
//				new HttpEntity<>(httpHeaders), String.class);
//		assertEquals(UPDATE_DEFECT_TYPE, getResponse.getBody());
//		projectData.setProjectId("1");
//		projectData.setProjectName("mercy");
//		projectData.setEndDate("2019-06-17");
//		projectData.setConfigId("mercy");
//		projectData.setDuration("mercy");
//		projectData.setStartDate("2019-06-12");
//		projectData.setStatus("mercy");
//		projectData.setType("mercy");
//		
//		HttpEntity<ProjectData> request = new HttpEntity<ProjectData>(projectData, httpHeaders);
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
//		testRestTemplate.exchange(BASE_URL + "/updateProject/" + projectId, HttpMethod.PUT,
//				request, String.class);
//		
//		ResponseEntity<String> getUpdatedResponse = testRestTemplate.exchange(BASE_URL + "/getProjectById/" + projectId, HttpMethod.GET,
//				new HttpEntity<>(httpHeaders), String.class);
//		assertEquals(CHECK_UPDATE_DEFECT_TYPE, getUpdatedResponse.getBody());
//	
////		ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL + "/GetAllproject", HttpMethod.GET,
////				new HttpEntity<>(httpHeaders), String.class);
////		Object body = "[{\"projectId\":\"4\",\"projectName\":\"mm\",\"type\":\"nn\",\"startDate\":\"2019-02-03\",\"endDate\":\"2019-02-03\",\"duration\":\"nn\",\"status\":\"nn\",\"configId\":\"nn\"}]";
////		assertEquals(200, response.getStatusCodeValue());
////		assertEquals(body, response.getBody());
//		
//	}
//	
//	@After 
//	public void tearDown() {
//		
//	}
//}
