package com.sgic.internal.employee.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sgic.internal.employee.entities.Employee;

public interface EmployeeService {

	// Method for Save Employee Entity
	public Employee saveEmployee(Employee employee);

	// Method for Employee List
	public List<Employee> findByEmployeeOrderByEmployeeIdDesc(Long empId);

	// Method for Getting One Employee Record by ID
	public Employee getByempId(Long empId);

	// Method for Getting One Employee Record by Name
	public List<Employee> getByName(String name);

	// Method for Getting One Employee Record by Email
	public Employee getByEmail(String email);

	// Method for Getting One Employee Record by Email
	public void deleteEmployeeByempId(Long empId);

	// Method for Getting One Employee Record by Email
	public List<Employee> getByDesignation(Long designationid);

	// Method for Update Employee
	public Employee updateEmployee(Employee employee);

//	Count method for counting database Employee 
	public long count();

//	Excel import method
	public void store(MultipartFile file);

}