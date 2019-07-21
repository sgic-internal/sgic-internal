package com.sgic.internal.defecttracker.configure.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.sgic.internal.defecttracker.configure.controller.dto.RolePrivilegesDto;
import com.sgic.internal.defecttracker.configure.controller.dtomapper.RolePrivilegesDtoMapper;
import com.sgic.internal.defecttracker.configure.services.RolePrivilegesService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RolePrivilegesController {
	@Autowired
	RolePrivilegesDtoMapper rolePrivilegesDtoMapper;

	@Autowired
	RolePrivilegesService rolePrivilegesService;

	private static Logger logger = LogManager.getLogger(RolePrivilegesDtoMapper.class);

	// Get All Role Privileges
	@GetMapping("/RolePrivileges")
	public List<RolePrivilegesDto> getAllRolePrivileges() {
		logger.info("Role Privileges Controller INFO -> Create RolePrivileges Method Started");
		try {
			return rolePrivilegesDtoMapper.getAllRolePrivileges();
		} finally {
			logger.info("Role Privileges Controller INFO -> Create RolePrivileges Method Finished");
		}
	}

//	// Get All Product Privileges Id
//	@GetMapping("/RolePrivilegess")
//	public List<RolePrivileges> getAllProductPrivilegesId() {
//		return rolePrivilegesService.getAllProductPrivilegesIds();
//	}
//
//	// Get All Product Privileges Id
//	@GetMapping("/RolePrivilegesss")
//	public List<RolePrivilegesDto> getAllProductPrivileges() {
////						return rolePrivilegesService.getAllProductPrivileges();
//		return rolePrivilegesDtoMapper.getAllRolePrivileges();
//	}
//
//	// Get Role Privileges By Id
//	@GetMapping("/RolePrivilegesss/{productPrivilegeId}")
//	public Object getProductPrivilegeById(@PathVariable(name = "productPrivilegeId") Long productPrivilegeId) {
//		return rolePrivilegesService.getProductPrivilegeById(productPrivilegeId);
//
//	}

	// Get Role Privileges By Id
	@GetMapping("/RolePrivilege/{rolePrivilegesId}")
	public Object getStatusById(@PathVariable(name = "rolePrivilegesId") Long rolePrivilegesId) {
		logger.info("Role Privileges Controller INFO -> Create Role Privileges Method Started");
		try {
			// check status id
			if (rolePrivilegesDtoMapper.getDefectSeverityById(rolePrivilegesId) != null) {
				logger.info("Role Privileges Controller INFO -> Role Privileges Id Found -> Status Id : "
						+ rolePrivilegesId);
				return rolePrivilegesDtoMapper.getDefectSeverityById(rolePrivilegesId);
			} else {
				logger.warn("Role Privileges Controller WARNING! -> Role Privileges Id Not Found -> Status Id : "
						+ rolePrivilegesId);
				return "Role Privileges Not Found For this Id : " + rolePrivilegesId;
			}
		} finally {
			logger.info("Role Privileges Controller INFO -> Create Role Privileges Method Finished");
		}
	}

	// Save All Role Privileges
	@PostMapping("/RolePrivilege")
	public ResponseEntity<String> saveRolePrivileges(@Valid @RequestBody RolePrivilegesDto rolePrivilegesDto) {
		logger.info("Role Privileges Controller INFO -> Save Role Privileges Method Started");
		try {
			if (rolePrivilegesDtoMapper.saveRolePrivileges(rolePrivilegesDto) != null) {
				logger.info("Role Privileges Controller -> Role Privileges Created Successful");
				return new ResponseEntity<>("Defect Severity added succesfully", HttpStatus.OK);
			}
			logger.warn("Role Privileges Controller -> Role Privileges creation FAILED!!!");
			return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			logger.error("Role Privileges Controller ERROR! :-> " + ex.getMessage());
		} finally {
			logger.info("Role Privileges Controller INFO -> Save Role Privileges Method Finished");
		}
		return null;
	}

	// Update Status
	@PutMapping("/RolePrivilege")
	public ResponseEntity<String> updateRolePrivileges(@RequestBody RolePrivilegesDto rolePrivilegesDto) {
		logger.info("Role Privileges Controller INFO -> Update Role Privileges Status Method Started");
		try {
			if (rolePrivilegesDtoMapper.updateRolePrivileges(rolePrivilegesDto) != null) {
				return new ResponseEntity<>("Role Privileges Updated Sucessfully ", HttpStatus.OK);
			} else {
				logger.warn("Role Privileges Controller -> Role Privileges Updated Failed!!!");
				return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
			}
		} finally {
			logger.info("Role Privileges Controller INFO -> Update Role Privileges Status Method Finished");
		}
	}

	// Delete Status
	@DeleteMapping("/RolePrivilege/{rolePrivilegesId}")
	public ResponseEntity<String> deleteRolePrivilege(@PathVariable(name = "rolePrivilegesId") Long rolePrivilegesId) {
		logger.info("Role Privileges Controller INFO -> Delete Role Privileges Method Started");
		try {
			// check status id
			if (rolePrivilegesDtoMapper.getDefectSeverityById(rolePrivilegesId) != null) {
				// delete status by id
				if (rolePrivilegesDtoMapper.deleteDefectSeverityById(rolePrivilegesId) == null) {
					logger.info("Role Privileges Controller -> Role Privileges Id Found -> Role Privileges Id : "
							+ rolePrivilegesId);
					return new ResponseEntity<>("Role Privileges Sucessfully deleted", HttpStatus.OK);
				}
			} else {
				logger.warn("Role Privileges Controller -> Role Privileges Id Not Found -> Role Privileges Id : "
						+ rolePrivilegesId);
				return new ResponseEntity<>(
						"Delete Failed! -> Role Privileges Id Not FOUND, Role Privileges Id : " + rolePrivilegesId,
						HttpStatus.BAD_REQUEST);
			}
		} finally {
			logger.info("Role Privileges Controller INFO -> Delete Role Privileges Method Finished");
		}
		return null;
	}

}
