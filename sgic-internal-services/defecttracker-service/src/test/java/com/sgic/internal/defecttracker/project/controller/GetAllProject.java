//package com.sgic.internal.defecttracker.project.controller;
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
//
//public class GetAllProject extends ProjectApplicationTest{
//	
//	@Autowired
//	JdbcTemplate jdbcTemplate;
////	INSERT INTO `project_service`.`project` (`project_id`, `config_id`, `duration`, `end_date`, `project_name`, `start_date`, `status`, `type`) VALUES ('4', 'nn', 'nn', '2019-02-03', 'mm', '2019-02-03', 'nn', 'nn');
//
//	@Before
//	public void setup() {
//		String newSql1 = "INSERT INTO `project_service`.`project` (`project_id`,`config_id`,`duration`,`end_date`,`project_name`,`start_date`,`status`,`type`) VALUES ('4','nn','nn','2019-02-03','mm','2019-02-03','nn','nn')";
////		String newSql2 = "INSERT INTO project_service.project (projectName,type,startDate,endDate,duration,status,configId) VALUES ('jazz','hikk','2019-02-08','2019-05-09','hikk','hinn','mm')";
////		String newSql3 = "INSERT INTO project_service.project (projectName,type,startDate,endDate,duration,status,configId) VALUES ('mercy','hill','2019-02-01','2019-05-08','hinn','himm','himm')";
//	
//		jdbcTemplate.execute(newSql1);
////		jdbcTemplate.execute(newSql2);
////		jdbcTemplate.execute(newSql3);
//	}
//
//	private String BASE_URL = "http://localhost:8080/project_service";
//	
//	//private static final String GET_ALL_PROJECT = "[{\"project_id\":1,\"config_id\":hi,\"duration\":hi,\"end_date\":2019-05-06,\"project_name\":MERCY,\"start_date\":2019-02-03,\"status\":hi,\"type\":hi}]";
//
//	// Testing for get all project types
//	
//	@Test
//	public void getAllproject() throws IOException, RestClientException {
//		ResponseEntity<String> responseall = testRestTemplate.exchange(BASE_URL + "/GetAllproject", HttpMethod.GET,
//				new HttpEntity<>(httpHeaders), String.class);
//		Object body = "[{\"projectId\":\"Pro1\",\"projectName\":\"DefectTracker\",\"type\":\"Medium\",\"startDate\":\"2019-06-12\",\"endDate\":\"2019-06-17\",\"duration\":\"duration\",\"status\":\"status\",\"configId\":\"configId\"}]";
//		assertEquals(200, responseall.getStatusCodeValue());
//		assertEquals(body, responseall.getBody());
//		
//	}
//	
//	@After 
//	public void tearDown() {
//		
//	}
//}
