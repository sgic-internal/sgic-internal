package com.sgic.internal.employee.repositories;

import org.springframework.data.repository.CrudRepository;


import com.sgic.internal.employee.entities.Employee;

public interface EmpRepository extends CrudRepository<Employee, Long>{
}
