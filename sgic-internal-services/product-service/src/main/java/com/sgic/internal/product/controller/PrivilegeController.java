package com.sgic.internal.product.controller;
//package com.sgic.internal.product.privileges.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sgic.internal.product.privileges.controller.dto.PrivilegeDTO;
//import com.sgic.internal.product.privileges.controller.dto.mapper.PrivilegeMapper;
//
//@CrossOrigin(origins = "*",allowedHeaders = "*")
//@RestController
//public class PrivilegeController {
//	
//	@Autowired
//	private PrivilegeMapper privilegeMapper;
//	private static Logger logger = LogManager.getLogger(PrivilegeMapper.class);
//
//	// Get All Privilege
//	@GetMapping("/Privileges")
//	public List<PrivilegeDTO> getAllPrivilege() {
//		logger.info("Controller -> Data Retrieved Successfull");
//		return privilegeMapper.getAllPrivilage();
//	}
//
//	 //Get Privilege By Id
//	@GetMapping("/Privilege/{privilageId}")
//	public PrivilegeDTO getPrivilegeById(@PathVariable(name = "privilageId") Long privilageId) {
//		logger.info("Controller -> Data Retrieved Successfull");
//		return privilegeMapper.getPrivilegeById(privilageId);
//	}
//	
//
//	// Save All Privilege
//	@PostMapping("/Privilege")
//	public ResponseEntity<String> savePrivilege(@Valid @RequestBody PrivilegeDTO privilegeDTO) {
//		if (privilegeMapper.savePrivilege(privilegeDTO) != null) {
//			logger.info("Privilege Controller -> Privilege Created Successful");
//			return new ResponseEntity<>("Privilege added succesfully", HttpStatus.OK);
//		}
//		logger.info("Privilege Controller -> Privilege creation FAILED!!!");
//		return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
//	}
//
//	// Update Privilege
//	@PutMapping("/Privilege")
//	public ResponseEntity<String> updatePrivilege(@RequestBody PrivilegeDTO privilegeDTO) {
//		logger.info("Privilege Controller -> Privilege Updated Successful");
//		if (privilegeMapper.updatePrivilege(privilegeDTO) != null) {
//			return new ResponseEntity<>("Sucessfully Updateed Privilege", HttpStatus.OK);
//		}
//		logger.info("Privilege Controller -> Privilege Updated Failed!!!");
//		return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
//	}
//
//	// Delete Privilege
//	@DeleteMapping("/Privilege/{privilageId}")
//	public ResponseEntity<String> deletePrivilege(@PathVariable(name = "privilageId") Long privilageId) {
//		System.out.print(privilageId);
//		if (privilegeMapper.getPrivilegeById(privilageId) != null) {
//			if (privilegeMapper.deletePrivilegeById(privilageId) == null) {
//				logger.info("Privilege Controller -> Privilege Deleted Successful");
//				return new ResponseEntity<>("Privilege Sucessfully deleted", HttpStatus.OK);
//			}
//		} else {
//			logger.info("Privilege Controller -> Privilege Id Not Found");
//			return new ResponseEntity<>("Privilege Id Not FOUND!!!", HttpStatus.BAD_REQUEST);
//		}
//		logger.info("Privilege Controller -> Privilege Deleted Failed!!!");
//		return new ResponseEntity<>("Delete FAILED!!!", HttpStatus.BAD_REQUEST);
//	}
//
//
//
//}
