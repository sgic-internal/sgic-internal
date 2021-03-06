package com.sgic.internal.employee.dto.converter;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sgic.internal.employee.dto.EmployeeDTO;
import com.sgic.internal.employee.entities.Employee;

@Service
public class EmployeeConverter {

	private static Logger logger = LogManager.getLogger(EmployeeDTO.class);

	// Employee Entity To DTO Converter
	public static EmployeeDTO EmployeeToEmployeeDTO(Employee employee) {
		EmployeeDTO employeeDto = new EmployeeDTO();
		if (employee != null) {
			logger.info("Employee to DTO Converter");
			employeeDto.setEmpId(employee.getEmpId());
			employeeDto.setEmail(employee.getEmail());
			employeeDto.setName(employee.getName());
			employeeDto.setDesignation(employee.getDesignation());
			return employeeDto;
		}
		return null;

	}

//	Employee DTO To Employee Entity Converter
	public static Employee EmployeeDTOToEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		if (employeeDTO != null) {
			employee.setEmpId(employeeDTO.getEmpId());
			employee.setEmail(employeeDTO.getEmail());
			employee.setName(employeeDTO.getName());
			employee.setDesignation(employeeDTO.getDesignation());
			return employee;
		}
		return null;
	}

	public static List<EmployeeDTO> EmployeeToEmployeeDTO(List<Employee> employeeList) {

		if (employeeList != null) {
			logger.info("Employee to DTO Converter");
			List<EmployeeDTO> listemployeeDto = new ArrayList<>();
			for (Employee employee : employeeList) {
				EmployeeDTO employeeDto = new EmployeeDTO();
				employeeDto.setEmpId(employee.getEmpId());
				employeeDto.setName(employee.getName());
				employeeDto.setEmail(employee.getEmail());
				employeeDto.setDesignation(employee.getDesignation());
				listemployeeDto.add(employeeDto);
			}

			return listemployeeDto;
		}
		return null;
	}

}
