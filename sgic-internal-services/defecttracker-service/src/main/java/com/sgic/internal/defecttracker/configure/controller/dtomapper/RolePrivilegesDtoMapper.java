package com.sgic.internal.defecttracker.configure.controller.dtomapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.configure.controller.converter.RolePrivilegesConverter;
import com.sgic.internal.defecttracker.configure.controller.dto.RolePrivilegesDto;
import com.sgic.internal.defecttracker.configure.entity.RolePrivileges;
import com.sgic.internal.defecttracker.configure.services.RolePrivilegesService;

@Service
public class RolePrivilegesDtoMapper {
@Autowired
RolePrivilegesService rolePrivilegesService;
@Autowired
RolePrivilegesConverter rolePrivilegesConverter;

private static Logger logger = LogManager.getLogger(RolePrivilegesDto.class);

//Get All Role Privileges
@SuppressWarnings("static-access")
public List<RolePrivilegesDto> getAllRolePrivileges() {
	logger.info("Role Privileges Mapper INFO -> Get All Role Privileges Method Started");
	try {
		List<RolePrivileges> rolePrivilegesList = rolePrivilegesService.getAllRolePrivilegesy();
		return rolePrivilegesConverter.EntityListTODtoList(rolePrivilegesList);
	} finally {
		logger.info("Role Privileges Mapper INFO -> Get All Role Privileges Method Finished");
	}
}



	// Save Role Privileges
	@SuppressWarnings("static-access")
	public RolePrivileges saveRolePrivileges(RolePrivilegesDto rolePrivilegesDto) {
		logger.info("Role Privileges Mapper INFO -> Save Role Privileges Method Started");
		try {
			logger.info("Role Privileges Mapper INFO -> Role Privileges Saved");
			return rolePrivilegesService.createRolePrivileges(rolePrivilegesConverter.DtoToEntity(rolePrivilegesDto));
		} finally {
			logger.info("Role Privileges Mapper INFO -> Save Role Privileges Method Finished");
		}
	}

	// Update Role Privileges
		@SuppressWarnings("static-access")
		public RolePrivileges updateRolePrivileges(RolePrivilegesDto rolePrivilegesDto) {
			logger.info("Role Privileges Mapper INFO -> Update Role Privileges Method Started");
			try {
				return rolePrivilegesService.updateRolePrivileges(rolePrivilegesConverter.DtoToEntityUpdate(rolePrivilegesDto));

			} finally {
				logger.info("Role Privileges Mapper INFO -> Update Role Privileges Method Finished");
			}
		}
	
		// Delete Role Privileges
		public RolePrivilegesDto deleteDefectSeverityById(Long rolePrivilegesId) {
			logger.info("Role Privileges Mapper INFO -> Delete Role Privileges Method Started");
			try {
				rolePrivilegesService.deleteRolePrivilegesById(rolePrivilegesId);
			} finally {
				logger.info("Role Privileges Mapper INFO -> Delete Role Privileges Method Finished");
			}
			return null;
		}
	
		// Get Role Privileges By Id
		@SuppressWarnings("static-access")
		public RolePrivilegesDto getDefectSeverityById(Long rolePrivilegesId) {
			logger.info("Role Privileges Mapper -> Get Role Privileges By Id Method Started");
			try {
				RolePrivileges rolePrivileges = rolePrivilegesService.getRolePrivilegesById(rolePrivilegesId);
				return rolePrivilegesConverter.EntityToDto(rolePrivileges);
			} finally {
				logger.info("Role Privileges Mapper -> Get Role Privileges By Id Method Finished");
			}
		}
		

	
}
