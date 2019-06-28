package com.sgic.internal.employee.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// import form Employee Entity 
import com.sgic.internal.employee.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

	// Find Employee By ID Method
	Employee findEmployeeByEmpId(String empId);

	// Find Employee By Email
	Employee findEmployeeByEmail(String email);

	// Find Employee By Designation
	@Query(value = "from Employee where designation = :designation")
	List<Employee> findByDesignation(String designation);
	
	// Find Employee By Name
	@Query(value= "from Employee where name = :name")
	List<Employee> findByName(String name);
	
}