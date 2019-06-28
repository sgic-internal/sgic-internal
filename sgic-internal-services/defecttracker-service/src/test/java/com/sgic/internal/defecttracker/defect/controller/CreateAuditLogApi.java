package com.sgic.internal.defecttracker.defect.controller;

import static org.junit.Assert.assertEquals;

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

import com.sgic.internal.defecttracker.defect.CommentTest;
import com.sgic.internal.defecttracker.defect.controller.dto.AuditLogData;
//import com.sgic.internal.defecttracker.defect.controller.dto.CommentData;

public class CreateAuditLogApi extends CommentTest {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	private String BASE_URL = "http://localhost:8080/defect";
	
	private static final String CREATE_AUDITLOG= "[{\"auditId\":1,\"user\":\"Thanus\",\"defectId\":\"1\",\"status\":\"Niru\",\"fixDate\":\"2019/06/25 14:09:55\"}]";

	
	
	@Before
	public void setup() {
		String psql = "INSERT INTO defecttracker.project (project_name) VALUES ( 'hgyugu')";
		String dsql = "INSERT INTO defecttracker.defect (defect_id, assign_to, comments, defect_type, description, module, priority, severity, status, steps, project_id) VALUES  ('1','','','','','','','','','',1)" ;
		String sql1 = "INSERT INTO defecttracker.auditlog (fix_date, status, user, defect_id) VALUES ('2019/06/25 14:09:55', 'Niru', 'Thanus', '1')";
		
		jdbcTemplate.execute(psql);
		jdbcTemplate.execute(dsql);
		jdbcTemplate.execute(sql1);
		
	}
	
	// Testing for save defect type
	@Test
	public void createAuditTest() throws IOException {
		AuditLogData audit=new AuditLogData();
		audit.setAuditId(1L);
		audit.setFixDate("2019/06/25 14:09:55");
		audit.setStatus("Niru");
		audit.setUser("Thanus");
		audit.setDefectId("1");
		HttpEntity<AuditLogData> request = new HttpEntity<AuditLogData>(audit, httpHeaders);
		ResponseEntity<String> postResponse = testRestTemplate.exchange(BASE_URL + "/audit", HttpMethod.POST,
				request, String.class);
		assertEquals(HttpStatus.OK, postResponse.getStatusCode());
		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/auditLogAll", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(CREATE_AUDITLOG, getResponse.getBody());
	}
	
	@After
	public void tearDown() {

	}
	
	
}
