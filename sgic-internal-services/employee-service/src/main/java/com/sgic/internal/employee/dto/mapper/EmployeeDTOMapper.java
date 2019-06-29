package com.sgic.internal.employee.dto.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.employee.dto.EmployeeDTO;
import com.sgic.internal.employee.dto.converter.EmployeeConverter;
import com.sgic.internal.employee.entities.Employee;
import com.sgic.internal.employee.repositories.EmployeeRepository;
import com.sgic.internal.employee.services.EmployeeService;

@Service
public class EmployeeDTOMapper {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeConverter employeeConverter;

	@SuppressWarnings("unused")
	private static Logger logger = LogManager.getLogger(EmployeeRepository.class);
	

	@SuppressWarnings("static-access")
	// save Method for EmployeeMapper
	public Employee saveEmployee(EmployeeDTO employeeDTO) {
		logger.info("New Employee Successfully saved");
		return employeeService.saveEmployee(employeeConverter.EmployeeDTOToEmployee(employeeDTO));
	}

	@SuppressWarnings("static-access")
	// List Method for EmployeeMapper
	public List<EmployeeDTO> getAllSortEmployeeInfo(String empId){
		logger.info(" Employee Successfully Get All Employee Details ");
		List<Employee> sortEmployeeList = employeeService.findByEmployeeOrderByEmployeeIdDesc(empId);
		return employeeConverter.EmployeeToEmployeeDTO(sortEmployeeList);
		
	}
	
	// getByID Method for EmployeeMapper
	@SuppressWarnings("static-access")
	public EmployeeDTO getById(String empId) {
		logger.info(" Employee Successfully Get By Id ");
		Employee employee = employeeService.getById(empId);
		return employeeConverter.EmployeeToEmployeeDTO(employee);

	}

	// Delete Method for EmployeeMapper
	public EmployeeDTO deleteByEmployeeId(String empId) {
		logger.info(" successfully deleted ");
		employeeService.deleteEmployeeById(empId);
		return null;

	}
	//Find Employee By Email
	public EmployeeDTO getByEmployeeEmailforMapper(String email) {
		Employee employee = employeeService.getByEmail(email);
		return EmployeeConverter.EmployeeToEmployeeDTO(employee);

	}
	
	@SuppressWarnings({ "static-access", "unused" })
	// Update Employee 
	public Employee UpdateEmployee(EmployeeDTO employeeDTO) {
		logger.info("Employee is Updated",employeeDTO.getEmpId());
		Employee employee = EmployeeConverter.EmployeeDTOToEmployee(employeeDTO);
		return employeeService.updateEmployee(employeeConverter.EmployeeDTOToEmployee(employeeDTO));

	}
	
	@SuppressWarnings("static-access")
	//Find Employee By Designation
	public List<EmployeeDTO> getEmployeeByDesignation(String designation){
		logger.info("Successfully Get Employee By Designation");
		List<Employee> employee= employeeService.getByDesignation(designation);
		return employeeConverter.EmployeeToEmployeeDTO(employee);

	}
	
	@SuppressWarnings("static-access")
	//Find Employee By Name 
	public List<EmployeeDTO> getEmployeeByName(String name){
		logger.info("Successfully Get Employee By Name");
		List<Employee> employee = employeeService.getByName(name);
		return employeeConverter.EmployeeToEmployeeDTO(employee);	
	}


}
