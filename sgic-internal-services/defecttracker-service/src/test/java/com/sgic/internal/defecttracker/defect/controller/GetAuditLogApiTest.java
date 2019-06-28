package com.sgic.internal.defecttracker.defect.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.io.IOException;
import java.net.URI;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgic.internal.defecttracker.defect.CommentTest;
import com.sgic.internal.defecttracker.defect.controller.dto.CommentData;
import com.sgic.internal.defecttracker.defect.controller.dto.FileData;
import com.sgic.internal.defecttracker.defect.entities.Comments;
import com.sgic.internal.defecttracker.defect.entities.DBFile;
import com.sgic.internal.defecttracker.defect.entities.Defect;
import com.sgic.internal.defecttracker.project.entities.Project;

public class GetAuditLogApiTest extends CommentTest {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Before
	public void setup() throws JSONException {

		String psql = "INSERT INTO defecttracker.project (project_name) VALUES ( 'hgyugu')";
		String dsql = "INSERT INTO defecttracker.defect (defect_id, assign_to, comments, defect_type, description, module, priority, severity, status, steps, project_id) VALUES  ('1','','','','','','','','','',1)";
		String sql1 = "INSERT INTO defecttracker.auditlog (fix_date, status, user, defect_id) VALUES ('2019/06/25 14:09:55', 'Niru', 'Thanus', '1')";

		jdbcTemplate.execute(psql);
		jdbcTemplate.execute(dsql);
		jdbcTemplate.execute(sql1);

	}

	private String BASE_URL = "http://localhost:8080/defect";
	private static final String GET_ALL_AUDITLOG = "[{\"auditId\":1,\"user\":\"Thanus\",\"defectId\":\"1\",\"status\":\"Niru\",\"fixDate\":\"2019/06/25 14:09:55\"}]";

	@Test
	public void getAllAuditTest() throws IOException, RestClientException {
		ResponseEntity<String> response = testRestTemplate.exchange(BASE_URL + "/auditLogAll", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(GET_ALL_AUDITLOG, response.getBody());
	}

	@After
	public void tearDown() {
	}

}