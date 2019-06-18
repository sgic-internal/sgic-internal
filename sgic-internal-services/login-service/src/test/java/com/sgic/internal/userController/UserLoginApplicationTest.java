package com.sgic.internal.userController;

import com.sgic.internal.UserApplicationTest;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClientException;

@SpringBootConfiguration
@EnableAutoConfiguration
public class UserLoginApplicationTest extends UserApplicationTest{
	
	 @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	  @Before
	  public void setup() {
		  
	  
	  String newUser = "INSERT INTO loginservice.user (email,password,role) VALUES ('kkk','lll','user')";

	  jdbcTemplate.execute(newUser);

	  }
	  
	  @Test
	  public void getUserApplicationTestSuccessfull() throws IOException, RestClientException {
	    ResponseEntity<String> response =
	        testRestTemplate.exchange("http://localhost:8080/loginservice" + "/viewUser", HttpMethod.GET,
	            new HttpEntity<>(httpHeaders), String.class);
	    assertEquals(HttpStatus.OK, response.getStatusCode());
	   }
	    
	  
	  @After
	  public void tearDown() {

	  }
	  
	  public final class UserApplicationTest{
	    
	    public UserApplicationTest() {
	    }
	    
	    private static final String USER_LOGIN_TEST_RESPONSE =
	        "[ { \\\"email\\\": \\\"iiiiiii\\\", \\\"password\\\": \\\"kala\\\", \\\"role\\\": \\\"user\\\" }, { \\\"email\\\": \\\"kala@gmail.com\\\", \\\"password\\\": \\\"kala\\\", \\\"role\\\": \\\"user\\\" }, { \\\"email\\\": \\\"mathu@gmail.com\\\", \\\"password\\\": \\\"mathu\\\", \\\"role\\\": \\\"sharma\\\" } ]";

	  }

}
