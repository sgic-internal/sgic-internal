package com.sgic.internal.defecttracker.project.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
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

	// Author :: by jakki
	// Get Mapping For Get Project By Id
	@Test
	public void GetProjectById() throws IOException, RestClientException {
		String newUser = "INSERT INTO project_service.project (project_id, config_id, duration, end_date, project_name, start_date, status, type)VALUES (5,6,'15','2019-05-05','Thanu','2019-06-05','open','High')";
		jdbcTemplate.execute(newUser);
		ResponseEntity<String> response = testRestTemplate.exchange(
				"http://localhost:8080/project_service" + "/getProjectById/4", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	// Author :: by Mercy
	// Get Mapping For Get Project
	@Test
	public void GetAllProject() {
		ResponseEntity<String> response1 = testRestTemplate.exchange(
				"http://localhost:8080/project_service" + "/GetAllproject", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, response1.getStatusCode());
	}

	// Author :: By Sujanthan
	// Get Mapping For Project Name
	@Test
	public void GetProjectByName() {
		ResponseEntity<String> response2 = testRestTemplate.exchange(
				"http://localhost:8080/project_service" + "/getName/jakee", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, response2.getStatusCode());
	}

	// Author ::By Mercy
	// Get Mapping For Project Status
	@Test
	public void GetProjectByStatus() {
		ResponseEntity<String> response3 = testRestTemplate.exchange(
				"http://localhost:8080/project_service" + "/getstatus/Mercy", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, response3.getStatusCode());

	}

	// Author :: By Aarany
	// Get Mapping For Project duration
	@Test
	public void GetProjectByduration() {
		ResponseEntity<String> response3 = testRestTemplate.exchange(
				"http://localhost:8080/project_service" + "/getduration/Mercy", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, response3.getStatusCode());
	}

	// Author :: By Sajitha
	// Get Mapping For Project Type By Sajitha
	@Test
	public void GetProjectBytype() {
		ResponseEntity<String> response3 = testRestTemplate.exchange(
				"http://localhost:8080/project_service" + "/gettype/Mercy", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, response3.getStatusCode());
	}

	
	@Test
	public void GetDate() {
	ResponseEntity<String> response3 = testRestTemplate.exchange(
	"http://localhost:8080/project_service" + "/GetDate/1994-12-15", HttpMethod.GET,
	new HttpEntity<>(httpHeaders), String.class);
//		assertEquals(HttpStatus.OK, response3.getStatusCodeValue());

	}


	// Author :: by sajitha
	// Post Mapping For Create a Project
	@Test
	public void PostProjectDevelopmentTestSuccessfull() throws IOException, RestClientException {

		Project project = new Project();
		String endDate = ("2018, 07, 12");
		String startDate = ("2019, 02, 13");
		project.setProjectId((long) 1);
		project.setProjectName("Jakeerththana");
		project.setDuration("two hours");
		project.setStatus("open");
		project.setType("high");
		testRestTemplate.postForEntity("http://localhost:8080/project_service" + "/createproject", project,
				Project.class);
	}

	@Test
	// Author :: By Arany
	// Put Mapping For Project
	public void updateProjectupdateTest() throws IOException, RestClientException {

		int projectid = 1;
		ResponseEntity<Project> project = testRestTemplate
				.getForEntity("http://localhost:8080/project_service" + "/getProjectById/" + projectid, Project.class);
		assertNotNull(project);
		Project project2 = new Project();
		String endDate = ("2018, 07, 12");
		String startDate = ("2019, 02, 13");
		project2.setConfigId("1");
		project2.setDuration("1");
		project2.setProjectName("xx");
		project2.setStatus("dd");
		project2.setType("oo");
		testRestTemplate.put("http://localhost:8080/project_service/" + "updateProject/" + projectid, project2,
				Project.class);
	}

	private String getRootUrl() {
		return "http://localhost:8080/project_service";
	}

	// Author :: By thadsha
	// Delete Mapping For Project
	@Test
	public void DeleteProjectTest() throws IOException, RestClientException {
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
