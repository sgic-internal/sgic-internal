package com.sgic.internal.employee.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.sgic.internal.employee.dto.EmployeeDTO;
import com.sgic.internal.employee.dto.mapper.EmployeeDTOMapper;
import com.sgic.internal.employee.entities.Employee;
import com.sgic.internal.employee.services.EmployeeService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

	@Autowired
	private EmployeeDTOMapper employeeDTOMapper;
	
	
	@Autowired
	private EmployeeService employeeservice;


	private static Logger logger = LogManager.getLogger(EmployeeDTOMapper.class);

	/* Author:KeerthanaR 17-06-2019 */
	@PostMapping(value = "/createemployee") // Save Employee
	public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		logger.info("Employee Controller -> CreateEmployee");
		try {
			if (employeeDTOMapper.getById(employeeDTO.getEmpId()) != null) {
				logger.info("Successfully Saved");
				System.out.println("Successfully Saved");
			} else {
				employeeDTOMapper.saveEmployee(employeeDTO);
			}

		} catch (Exception ex) {
			logger.error("Check Your Error");
			System.out.println("Something went Wrong" + ex.getMessage());
		}

		return null;
	}

	/* Author:KiishanthS 17-06-2019 */
	@GetMapping(value = "/getallemployee") // List Employee
	public ResponseEntity<List<EmployeeDTO>> sortListEmployeeInfo(Long empId) {
		try {
			logger.info("Employee Controller : --> GetAllEmployeeInfo");
			return new ResponseEntity<>(employeeDTOMapper.getAllSortEmployeeInfo(empId), HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Employee Controller Error :-> " + ex.getMessage());
		}

		return null;
	}

	/* Author:DalistaaA 17-06-2019 */
	@GetMapping("/getempolyeebyid/{empid}") // Get Employee By Employee ID
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "empid") Long empid) {
		try {
			logger.info("Employee Controller :-> GetEmployeeById");
			return new ResponseEntity<>(employeeDTOMapper.getById(empid), HttpStatus.OK);

		} catch (Exception ex) {
			logger.error("Employee Controller :->" + ex.getMessage());

		}
		return null;

	}

	/* Author:JothiM 17-06-2019 */
	@DeleteMapping("/deletebyid/{empId}") // Delete Employee Using Employee ID
	public ResponseEntity<String> deleteEmployeeByempId(@PathVariable("empId") Long empId) {
		try {
			logger.info("Employee Controller :-> DeleteEmployeeById");
//			employeeDTOMapper.deleteByEmployeeId(empid.toUpperCase());
			employeeDTOMapper.deleteByEmployeeId(empId);
			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Employee Controller :-> Error" + ex.getMessage());
		}
		return null;
	}

	/* Author:ThuvarakanT 17-06-2019 */
	@GetMapping("/getemail/{email}")
	// Get Employee By Email
	public ResponseEntity<EmployeeDTO> getEmployeeByEmail(@PathVariable(name = "email") String email) {
		try {
			logger.info("Employee Controller:: -> GetEmail");
			return new ResponseEntity<>(employeeDTOMapper.getByEmployeeEmailforMapper(email), HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Employee Controller:: -> Error" + ex.getMessage());
		}
		return null;
	}

	/* Author:RammiyaN 19-06-2019 */
	@PutMapping("update/{empId}") // update Employee Using Employee ID
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		try {
			logger.info("Employee Controller :-> Update");
			if (employeeDTOMapper.UpdateEmployee(employeeDTO) != null) {
				return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
			}
			return new ResponseEntity<>("Failed To Update", HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Employee Controller :-> Error" + ex.getMessage());
		}

		return null;
	}

	/* Author:DalistaaA 19-06-2019 */
	@GetMapping("/getdesignation/{designationid}") // Get Employee By Designation
	public List<EmployeeDTO> getByDesignation(@PathVariable(name = "designationid") Long designationid) {
		try {
			logger.info("Employee Controller :-> GetDesignation");
			return employeeDTOMapper.getEmployeeByDesignation(designationid);
		} catch (Exception ex) {
			logger.error("Employee Controller :-> Error" + ex.getMessage());
		}
		return null;

	}

	/* Author:KeerthanaR 23-06-2019 */
	@GetMapping("/getname/{name}") // Get Employee By Name
	public List<EmployeeDTO> getByName(@PathVariable(name = "name") String name) {
		try {
			logger.info("Employee Controller -> GetName");
			return employeeDTOMapper.getEmployeeByName(name);
		} catch (Exception ex) {
			logger.error("Employee Controller -> error" + ex.getMessage());
		}
		return null;

	}

	@GetMapping("/getcount")
// <----	Employee DataBase Employee Table Row Count Method --->
	public ResponseEntity<Long> getTotalCount() {
		try {
			logger.info("Employee Controller :-> getCount");
			return new ResponseEntity<>(employeeDTOMapper.getByEmployeeCountforMapper(), HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Employee Controller :-> Error" + ex.getMessage());
		}
		return null;

	}

	@PostMapping("/database")
//	<----Import Excel File For Employee Service Employee Table---> 
	public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, Model model) {
		try {
			System.out.println("controller");
			employeeservice.store(file);
			model.addAttribute("message", "File uploaded successfully!");
		} catch (Exception e) {
			model.addAttribute("message", "Fail! -> uploaded filename: " + file.getOriginalFilename());
		}
		return "File uploaded successfully";
	}

}
