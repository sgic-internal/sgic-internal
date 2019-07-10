package com.sgic.internal.employee.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.sgic.internal.employee.entities.Employee;
import com.sgic.internal.employee.repositories.EmployeeRepository;
import com.sgic.internal.employee.services.EmployeeService;


@Service
//Implement from Employee Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	private static Logger logger = LogManager.getLogger(EmployeeRepository.class);

	@Override
	// Save Employee
	public Employee saveEmployee(Employee employee) {
		logger.info("Save Employee Details methods");
		return employeeRepository.save(employee);
	}

	@Override
	// List Employee
	public List<Employee> findByEmployeeOrderByEmployeeIdDesc(String empId) {
		logger.info("Get All Employee Details Methods");
		return employeeRepository.findAll(Sort.by(Sort.Direction.DESC,"empId"));
	}

	@Override
	// Find By Employee Id
	public Employee getById(String empId) {
		logger.info("Get By Employee ID Methods");
		return employeeRepository.findEmployeeByEmpId(empId);
	}

	@Override
	// Delete Employee
	public void deleteEmployeeById(String empId) {
		logger.info("Delete Employee Details Methods");
		employeeRepository.deleteById(empId);

	}

	@Override
	// Update Employee
	public Employee updateEmployee(Employee employee) {
		String empId = employee.getEmpId();
		boolean isExist = employeeRepository.findEmployeeByEmpId(empId) != null;
		if (isExist) {
			logger.info("Employee updates Successfully");
			return employeeRepository.save(employee);
		} else {
			logger.info("Employee Id is Not Found");
		}

		return null;
	}

	@Override
	// Find By Employee Email
	public Employee getByEmail(String email) {
		logger.info("Successfully Get Employee By Email");
		return employeeRepository.findEmployeeByEmail(email);
	}

	@Override
	// Find By Employee Designation
	public List<Employee> getByDesignation(String designation) {
		logger.info("Successfully Get Employee By Designation");
		return employeeRepository.findByDesignation(designation);
	}

	@Override
	// Find By Employee Name
	public List<Employee> getByName(String name) {
		logger.info("Successfully Get Employee By Name");
		return employeeRepository.findByName(name);
	}

		

}