package com.sgic.internal.employee.services;

import com.sgic.internal.employee.entities.Employee;

public interface EmployeeService {
public Employee createEmployee(Employee employee);
public boolean isEmployeeAlreadyExists(Long id);
}