package com.sgic.internal.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.employee.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}