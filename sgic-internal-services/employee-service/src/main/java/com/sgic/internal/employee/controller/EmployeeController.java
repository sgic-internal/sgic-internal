package com.sgic.internal.employee.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.internal.employee.dto.EmployeeDTO;
import com.sgic.internal.employee.dto.mapper.EmployeeDTOMapper;
import com.sgic.internal.employee.entities.Employee;
import com.sgic.internal.employee.repositories.EmployeeRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeController {

	@Autowired
	private EmployeeDTOMapper employeeDTOMapper;

	@SuppressWarnings("unused")
	private static Logger logger = LogManager.getLogger(EmployeeRepository.class);

	/* Author:KeerthanaR 17-06-2019 */
	@PostMapping(value = "/createemployee") // Save Employee
	public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		logger.info("successfully saved");
		return employeeDTOMapper.saveEmployee(employeeDTO);
	}

	/* Author:KiishanthS 17-06-2019 */
	@GetMapping(value = "/GetAllemployee") // List Employee
	public ResponseEntity<List<EmployeeDTO>> listEmployeeInfo() {
		logger.info("successfully Get All Employee Details");
		return new ResponseEntity<>(employeeDTOMapper.getAllEmployeeForMapper(), HttpStatus.OK);
	}

	/* Author:DalistaaA 17-06-2019 */
	@GetMapping("/GetEmpolyeeById/{empid}") // Get Employee By Employee ID
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "empid") String empid) {
		logger.info("successfully Get By ID");
		employeeDTOMapper.getById(empid);
		return new ResponseEntity<>(employeeDTOMapper.getById(empid), HttpStatus.OK);
	}

	/* Author:JothiM 17-06-2019 */
	@DeleteMapping("DeleteById/{empId}") // Delete Employee Using Employee ID
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("empId")String empId) {
		logger.info("Successfully Deleted");
		employeeDTOMapper.deleteByEmployeeId(empId);
		return new ResponseEntity<>("deleted", HttpStatus.OK);
	}

	/* Author:ThuvarakanT 17-06-2019 */
	@GetMapping("/GetEmail/{email}")
	// Get Employee By Email
	public ResponseEntity<EmployeeDTO> getEmployeeByEmail(@PathVariable(name = "email") String email) {
		logger.info("Successfully Get Employee By Email");
		return new ResponseEntity<>(employeeDTOMapper.getByEmployeeEmailforMapper(email), HttpStatus.OK);
	}

	/* Author:RammiyaN 19-06-2019 */
	@PutMapping("update/{empId}") // update Employee Using Employee ID
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		logger.info("successfully updated ");
		if (employeeDTOMapper.UpdateEmployee(employeeDTO) != null) {
			return new ResponseEntity<>("ok", HttpStatus.OK);
		}

		return new ResponseEntity<>("updated", HttpStatus.OK);
	}

	/* Author:DalistaaA 19-06-2019 */
	@GetMapping("/GetDesignation/{designation}") // Get Employee By Email
	public List<EmployeeDTO> getByDesignation(@PathVariable(name = "designation") String designation) {
		return employeeDTOMapper.getEmployeeByDesignation(designation);
	}
}
