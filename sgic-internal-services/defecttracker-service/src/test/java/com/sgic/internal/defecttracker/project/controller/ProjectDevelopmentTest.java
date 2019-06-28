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

public class ProjectDevelopmentTest extends ProjectApplicationTest {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	ProjectDto projectDto;

	@Test
	public void GetAll() throws IOException, RestClientException {
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
				.postForEntity("http://localhost:8080/project_service" + "/createproject", request, String.class);
		assertEquals(200, response.getStatusCodeValue());

		ResponseEntity<String> response1 = testRestTemplate.exchange(
				"http://localhost:8080/project_service" + "/GetAllproject", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(HttpStatus.OK, response1.getStatusCode());
		Object body = "[{\"projectId\":\"Pro1\",\"projectName\":\"DefectTracker\",\"type\":\"Medium\",\"startDate\":\"2019-06-12\",\"endDate\":\"2019-06-17\",\"duration\":\"duration\",\"status\":\"status\",\"configId\":\"configId\"}]";
<<<<<<< HEAD
//		assertEquals(body, response1.getBody());
=======
		assertEquals(body, response1.getBody());
>>>>>>> realease2
	}

	@After
	public void tearDown() {

	}

}
