package com.sgic.internal.defecttracker.project.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import com.sgic.internal.defecttracker.project.ProjectApplicationTest;
import com.sgic.internal.defecttracker.project.entities.Project;

public class ProjectDevelopmentTest extends ProjectApplicationTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Before
	public void setup() {

	}

@Test
	public void GetProjectById() throws IOException, RestClientException {

		String newUser = "INSERT INTO project_service.project (project_id, config_id, duration, end_date, project_name, start_date, status, type)VALUES (5,6,'15','2019-05-05','Thanu','2019-06-05','open','High')";
		
		jdbcTemplate.execute(newUser);
		

		ResponseEntity<String> response = testRestTemplate.exchange(
				"http://localhost:8080/project_service" + "/getProjectById/1", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
		@Test
		public void GetAllProject() {
			ResponseEntity<String> response1 = testRestTemplate.exchange(
					"http://localhost:8080/project_service" + "/GetAllproject", HttpMethod.GET,
					new HttpEntity<>(httpHeaders), String.class);
			assertEquals(HttpStatus.OK, response1.getStatusCode());
		}


	@Test
	public void GetProjectByName() {
		ResponseEntity<String> response2 = testRestTemplate.exchange(
				"http://localhost:8080/project_service" + "/getName/jakee", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, response2.getStatusCode());
	}
	@Test
	public void GetProjectByStatus() {
		ResponseEntity<String> response3 = testRestTemplate.exchange(
				"http://localhost:8080/project_service" + "/getstatus/Mercy", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, response3.getStatusCode());
	}
	@Test
	public void GetProjectByType() {
		ResponseEntity<String> response3 = testRestTemplate.exchange(
				"http://localhost:8080/project_service" + "/gettype/Mercy", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, response3.getStatusCode());
	}
	@Test
	public void GetProjectByduration() {
		ResponseEntity<String> response3 = testRestTemplate.exchange(
				"http://localhost:8080/project_service" + "/getduration/Mercy", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, response3.getStatusCode());

	}

	@Test
	public void PostProjectDevelopmentTestSuccessfull() throws IOException, RestClientException {

		Project project = new Project();
		Date endDate=new Date(2018, 07, 12);
		Date startDate=new Date(2019, 02, 13);
//		endDate.setYear(2018);
//		endDate.setMonth(07);
//		endDate.setDate(12);
		project.setProjectId((long) 1);
		project.setProjectName("Jakeerththana");
		project.setDuration("two hours");
		project.setEndDate(endDate);
		project.setStatus("open");
		project.setType("high");
		project.setStartDate(startDate);
		testRestTemplate.postForEntity("http://localhost:8080/project_service" + "/createproject", project,Project.class);

	}
	
	@Test
	public void updateProjectupdateTest() throws IOException, RestClientException {
		
		int projectid =1;
		ResponseEntity<Project> project = testRestTemplate.getForEntity("http://localhost:8080/project_service" + "/getProjectById/" + projectid,Project.class);
		assertNotNull(project);
		Project project2 = new Project();
		Date endDate=new Date(2018, 07, 12);
		Date startDate=new Date(2019, 02, 13);
		project2.setConfigId("1");
		project2.setDuration("1");
		project2.setEndDate(startDate);
		project2.setProjectName("xx");
		project2.setStartDate(endDate);
		project2.setStatus("dd");
		project2.setType("oo");
		testRestTemplate.put("http://localhost:8080/project_service/"+"updateProject/"+projectid, project2, Project.class);
		
	}
	private String getRootUrl() {
		// TODO Auto-generated method stub
		return "http://localhost:8080/project_service";
	}
	 @Test
	    public void DeleteProjectTest() throws IOException,RestClientException {
	         int id = 1;
	         Project project = testRestTemplate.getForObject(getRootUrl() + "/deleteById/" + id, Project.class);
	         assertNotNull(project);
	         testRestTemplate.delete(getRootUrl() + "/project/" + id);
	         try {
	              project = testRestTemplate.getForObject(getRootUrl() + "/deleteById/" + id, Project.class);
	         } catch (final HttpClientErrorException e) {
	              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
	         }
	    }

	@After
	public void tearDown() {

	}

	public final class ProjectDevelopmentTestConstant {

		public ProjectDevelopmentTestConstant() {
		}

		private static final String PROJECT_DEVELOPMENT_TEST_RESPONSE = "[ { \\\"projectId\\\": 1, \\\"projectName\\\": \\\"jakee\\\", \\\"type\\\": \\\"fytvh\\\", \\\"startDate\\\": \\\"2018-07-12\\\", \\\"endDate\\\": \\\"2018-02-16\\\", \\\"duration\\\": \\\"2 year\\\", \\\"status\\\": \\\"open\\\", \\\"configId\\\": \\\"011\\\" } ]";
	}

}
