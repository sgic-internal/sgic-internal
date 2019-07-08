package com.sgic.internal.defecttracker.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sgic.internal.defecttracker.project.controller.dto.ResourceAllocationDto;
import com.sgic.internal.defecttracker.project.controller.dto.mapper.ResourceAllocationDtoMapper;
import com.sgic.internal.defecttracker.project.entities.Employee;
import com.sgic.internal.defecttracker.project.entities.ResourceAllocation;
//import com.sgic.internal.employee.dto.EmployeeDTO;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResourceAllocationController {

	@Autowired
	private ResourceAllocationDtoMapper resourceAllocationDtoMapper;

	@PostMapping(value = "/saveresource")
	public ResourceAllocation createResource(@RequestBody ResourceAllocationDto resourceAllocationDto) {
		return resourceAllocationDtoMapper.saveResource(resourceAllocationDto);

	}

	@GetMapping(value = "/getallresource") // List Employee
	public ResponseEntity<List<ResourceAllocationDto>> sortListEmployeeInfo() {
		System.out.println("list");
		resourceAllocationDtoMapper.getAllResource();
		return new ResponseEntity<List<ResourceAllocationDto>>(resourceAllocationDtoMapper.getAllResource(),
				HttpStatus.OK);
	}

//	This APIs From Employee Service
	@GetMapping("/GetAllresources")
	public List<Employee> getEmployeeList() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Employee>> response = restTemplate.exchange(
				"http://localhost:8084/employeeservice/getallemployee", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		List<Employee> employee = response.getBody();
		return employee;
	}
	


}
