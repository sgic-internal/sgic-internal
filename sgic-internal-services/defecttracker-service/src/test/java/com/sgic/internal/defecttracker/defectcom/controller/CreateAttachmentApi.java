package com.sgic.internal.defecttracker.defectcom.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockMultipartFile;

import com.sgic.internal.defecttracker.defectcom.CommentTest;
import com.sgic.internal.defecttracker.defect.controller.dto.CommentData;
//import com.sgic.internal.defecttracker.defect.controller.dto.CommentData;
import com.sgic.internal.defecttracker.defect.controller.dto.FileData;

public class CreateAttachmentApi extends CommentTest {
	
	/* Unit test for Create Attachment - Thanushan */
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private String BASE_URL = "http://localhost:8080/defect";
	
	private static final String CREATE_ATTACHMENTS= "[{131526}]";

	
	
	@Before
	public void setup() {
		String psql = "INSERT INTO defecttracker.project (project_name) VALUES ('hgyugu')";
		String dsql = "INSERT INTO defecttracker.defect (defect_id, assign_to, comments, defect_type, description, module, priority, severity, status, steps, project_id) VALUES  ('1','','','','','','','','','',1)" ;
		//String sql1 = "INSERT INTO defecttracker.files (defect_id, file_download_uri, file_name, file_type, size) VALUES ('2', 'Users/Attachment/aerial_view_of.jpg', 'aerial_view_of.jpg', 'image/jpeg', '131526')";
		
		jdbcTemplate.execute(psql);
		jdbcTemplate.execute(dsql);
		//jdbcTemplate.execute(sql1);
		
	}
	
	// Testing for save defect type
	@Test
	public void createAttachmentsTest() throws IOException {
//		byte[] fileContent = "bar".getBytes(StandardCharsets.UTF_8);
//		MockMultipartFile filePart = new MockMultipartFile("file", "orig", null, fileContent);
//		FileData file = new FileData();
		//file.setFileType("image/jpeg");
		//file.setFileName("SP.jpg");
		//file.setFileDownloadUri("Users/Thanushan/romi/img/SP.jpg");
		//file.setSize(6170L);
		//System.out.println("aaaaaaaaaaaaaaaaaaaaa"+jsonPart.getName());
//		file.setSize(jsonPart.getSize());
//		file.setFileType(jsonPart.getContentType());
//		file.setFileName(jsonPart.getName());
		//HttpEntity<MockMultipartFile> request = new HttpEntity<MockMultipartFile>(jsonPart, httpHeaders);
//		ResponseEntity<String> postResponse = testRestTemplate.exchange(BASE_URL + "/uploadFile", HttpMethod.POST,
//				request, String.class);
		FileData fileData = new FileData();
		fileData.setDefectId((long) 1);
		fileData.setFileDownloadUri("Users/Attachment/aerial_view_of.jpg");
		fileData.setFileName("aerial_view_of.jpg");
		fileData.setFileType("image/jpeg");
		fileData.setSize(131526L);
//		ResponseEntity<String> postResponse = testRestTemplate.postForEntity(BASE_URL + "/uploadFile",String.class);
//		assertEquals(CREATE_ATTACHMENTS, postResponse.getBody());
//		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/downloadFile/aerial_view_of.jpg", HttpMethod.GET,
//				new HttpEntity<>(httpHeaders), String.class);
//		assertEquals(200, getResponse.getStatusCodeValue());
		
		HttpEntity<FileData> request = new HttpEntity<FileData>(fileData, httpHeaders);
		ResponseEntity<String> postResponse = testRestTemplate.exchange(BASE_URL + "/uploadFile", HttpMethod.POST,
				request, String.class);
		assertEquals(HttpStatus.OK, postResponse.getStatusCode());
		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/downloadFile/2", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(CREATE_ATTACHMENTS, getResponse.getBody());
	
	}
	
	@After
	public void tearDown() {

	}
	
	
}
