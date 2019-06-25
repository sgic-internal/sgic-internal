package com.sgic.internal.defecttracker.defect.controller;

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

import com.sgic.internal.defecttracker.defect.CommentTest;
//import com.sgic.internal.defecttracker.defect.controller.dto.CommentData;
import com.sgic.internal.defecttracker.defect.controller.dto.FileData;

public class CreateAttachmentApi extends CommentTest {
	
	/* Unit test for Create Attachment - Thanushan */
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private String BASE_URL = "http://localhost:8080/defect";
	
	private static final String CREATE_ATTACHMENTS= "[{6170}]";

	
	
	@Before
	public void setup() {
		//String psql = "INSERT INTO defecttracker.files (id,defect_id, file_download_uri, file_name, file_type, size) VALUES ('1','1', 'Users/Thanushan/romi/img/SP.jpg', 'SP.jpg', 'image/jpeg', '6170')";
		//String dsql = "INSERT INTO defecttracker.defect (defect_id,assign_to,comments,defect_type,description,module,priority,severity,status,steps,project_id) VALUES  ('1','','','','','','','','','',1)" ;
		//String sql1 = "INSERT INTO defecttracker.comments (commented_date, comments, defect_id) VALUES ('2019/06/21 16:17:33','aaa','1')";
		
		//jdbcTemplate.execute(psql);
		//jdbcTemplate.execute(dsql);
		//jdbcTemplate.execute(sql1);
		
	}
	
	// Testing for save defect type
	@Test
	public void createAttachmentsTest() throws IOException {
		byte[] fileContent = "bar".getBytes(StandardCharsets.UTF_8);
		MockMultipartFile filePart = new MockMultipartFile("file", "orig", null, fileContent);
		FileData file = new FileData();
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
		ResponseEntity<String> postResponse = testRestTemplate.postForEntity(BASE_URL + "/uploadFile", filePart, String.class);
		assertEquals(CREATE_ATTACHMENTS, postResponse.getBody());
		ResponseEntity<String> getResponse = testRestTemplate.exchange(BASE_URL + "/downloadFile/SP.jpg", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), String.class);
		assertEquals(200, getResponse.getStatusCodeValue());
	
	}
	
	@After
	public void tearDown() {

	}
	
	
}
