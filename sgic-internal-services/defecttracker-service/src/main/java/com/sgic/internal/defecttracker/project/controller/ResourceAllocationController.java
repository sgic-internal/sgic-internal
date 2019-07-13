package com.sgic.internal.defecttracker.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.sgic.internal.defecttracker.project.controller.dto.ResourceAllocationDto;
import com.sgic.internal.defecttracker.project.controller.dto.mapper.ResourceAllocationDtoMapper;
import com.sgic.internal.defecttracker.project.entities.Employee;
import com.sgic.internal.defecttracker.project.entities.Project;
import com.sgic.internal.defecttracker.project.entities.ResourceAllocation;
import com.sgic.internal.defecttracker.project.entities.ResourceAllocationList;
import com.sgic.internal.defecttracker.project.services.ResourceAllocationService;

@SuppressWarnings("unused")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResourceAllocationController {

	@Autowired
	private ResourceAllocationDtoMapper resourceAllocationDtoMapper;

	@Autowired
	private ResourceAllocationService resourceAllocationService;
	
	

//	<----This APIs Is -- Save Single Object--->
	@PostMapping(value = "/saveresource")
	public ResourceAllocation createResource(@RequestBody ResourceAllocationDto resourceAllocationDto) {
		return resourceAllocationDtoMapper.saveResource(resourceAllocationDto);

	}

//	<----This APIs Is --- Save List -- Use To Save Balk Resource  --->
	@PostMapping(value = "/saveresourceTable")
	public void createResourceTable(@RequestBody List<ResourceAllocationDto> resourceAllocationDto) {
//		resourceAllocationService.saveResourceTable(resourceAllocation);
		resourceAllocationDtoMapper.saveResourceTable(resourceAllocationDto);

	}

//	<--This APIs Is --- Get All Resources Object--->
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

//	<----This APIs Is --- Get Resource By Resource Id --->
	@GetMapping("/getresourcebyId/{resourceId}")
	public ResponseEntity<ResourceAllocationDto> getResourceById(@PathVariable(name = "resourceId") Long resourceId) {
//		logger.info("Employee Controller -> GetEmployeeById");
		return new ResponseEntity<>(resourceAllocationDtoMapper.findResourceAllocationByresourceId(resourceId),
				HttpStatus.OK);

	}

//	<----This APIs Is -- Get Resource Object By Resource Id --->

	@RequestMapping("/resourceObj/{resourceId}")
	public ResourceAllocationList getResourceAllocationObj(@PathVariable("resourceId") Long resourceId) {
		ResourceAllocationList resourceAllocationList = new ResourceAllocationList();
		ResourceAllocation resourceAllocation = resourceAllocationService
				.findResourceAllocationByresourceId(resourceId);
		resourceAllocationList.setResourceId(resourceAllocation.getResourceId());
		resourceAllocationList.setEmpId(resourceAllocation.getEmpId());

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employee> response = restTemplate.exchange(
				"http://localhost:8084/employeeservice/getempolyeebyid/" + resourceAllocation.getEmpId(),
				HttpMethod.GET, null, new ParameterizedTypeReference<Employee>() {
				});

		Employee employee = response.getBody();
//		resourceAllocationList.setEmployeeObj(employee);

		return resourceAllocationList;

	}

//	<----This APIs Is -- Get Resource+Project+Employee List  --->
	@GetMapping("/getallresource")
	public List<ResourceAllocationList> getAllSubClassList() {
		RestTemplate restTemplate = new RestTemplate();
		List<ResourceAllocation> resourceList = resourceAllocationService.getresourceById();
		int length = resourceList.size();
		System.out.println(length);
		List<ResourceAllocationList> retrievedresource = new ArrayList<ResourceAllocationList>();
		for (int i = 0; i < length; i++) {
			ResourceAllocationList resourceAllocationList = new ResourceAllocationList();
			Long resourceId = Long.parseLong(String.valueOf(resourceList.get(i)));
			ResourceAllocation resourceallocation = resourceAllocationService
					.findResourceAllocationByresourceId(resourceId);
			resourceAllocationList.setResourceId(resourceallocation.getResourceId());
			resourceAllocationList.setEmpId(resourceallocation.getEmpId());
			resourceAllocationList.setProjectId(resourceallocation.getProject().getProjectId());
			resourceAllocationList.setProjectName(resourceallocation.getProject().getProjectName());

			ResponseEntity<Employee> response = restTemplate.exchange(
					"http://localhost:8084/employeeservice/getempolyeebyid/" + resourceallocation.getEmpId(),
					HttpMethod.GET, null, new ParameterizedTypeReference<Employee>() {
					});

			Employee employee = response.getBody();
//			resourceAllocationList.setEmployeeObj(employee);
			resourceAllocationList.setEmpId(employee.getEmpId());
			resourceAllocationList.setEmployeeid(employee.getEmployeeid());
			resourceAllocationList.setFirstname(employee.getFirstname());
			resourceAllocationList.setName(employee.getName());
			resourceAllocationList.setEmail(employee.getEmail());
			resourceAllocationList.setAvailability(employee.getAvailability());
			resourceAllocationList.setBench(employee.isBench());
			resourceAllocationList.setDesignationid(employee.getDesignationid());
			resourceAllocationList.setDesignationname(employee.getDesignationname());
			retrievedresource.add(resourceAllocationList);
			System.out.println(employee.getEmployeeid());
		}
		return retrievedresource;
	}

}
