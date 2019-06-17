package com.sgic.internal.employee.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.internal.employee.entities.Employee;
import com.sgic.internal.employee.repositories.EmployeeRepository;
import com.sgic.internal.employee.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
    @Transactional(readOnly = true)
	public Employee createEmployee(Employee employee) {
		Employee responseEmployee = employeeRepository.save(employee);
		return responseEmployee;
	}
	
	  @Override
	  @Transactional(readOnly = true)
	  public boolean isEmployeeAlreadyExists(Long id) {
	    return employeeRepository.existsById(id);
	  }

}