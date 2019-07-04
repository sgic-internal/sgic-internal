package com.sgic.internal.defecttracker.defect.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sgic.internal.defecttracker.defect.CommentTest;
import com.sgic.internal.defecttracker.defect.controller.dto.CommentData;

public class CreateCommentApi extends CommentTest {
	
	/* Unit test for Create Attachment - Thuviyan */
	@Autowired
	JdbcTemplate jdbcTemplate;
	private String BASE_URL = "http://localhost:8080/defect";
	
	private static final String CREATE_COMMENTS= "[{\"commentId\":1,\"comments\":\"aaa\",\"defectId\":\"1\",\"commentedDate\":\"2019/06/21 16:17:33\"}]";

	
	
	@Before
	public void setup() {
		String psql = "INSERT INTO defecttracker.project (project_name) VALUES ('aaa')";
		String dsql = "INSERT INTO defecttracker.defect (defect_id,assign_to,comments,defect_type,description,module,priority,severity,status,steps,project_id) VALUES  ('1','','','','','','','','','',1)" ;
		//String sql1 = "INSERT INTO defecttracker.comments (commented_date, comments, defect_id) VALUES ('2019/06/21 16:17:33','aaa','1')";
		
		jdbcTemplate.execute(psql);
		jdbcTemplate.execute(dsql);
		//jdbcTemplate.execute(sql1);
		
	}
	
	// Testing for save defect type
	@Test
	public void createCommentsTest() throws IOException {
		CommentData comment=new CommentData();
		comment.setCommentId(1L);
		comment.setComments("aaa");
		comment.setCommentedDate("2019/06/21 16:17:33");
		comment.setDefectId("1");
		
		HttpEntity<CommentData> request = new HttpEntity<CommentData>(comment, httpHeaders);
		ResponseEntity<String> postResponse = testRestTemplate.exchange(BASE_URL + "/comments", HttpMethod.POST,
				request, String.class);
		assertEquals(HttpStatus.OK, postResponse.getStatusCode());
		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/commentAll", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(CREATE_COMMENTS, getResponse.getBody());
	}
	
	@After
	public void tearDown() {

	}
	
	
}
