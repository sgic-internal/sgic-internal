package com.sgic.internal.defecttracker.configure.controller.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.configure.controller.dto.RolePrivilegesDto;
import com.sgic.internal.defecttracker.configure.entity.Role;
import com.sgic.internal.defecttracker.configure.entity.RolePrivileges;

@Service
public class RolePrivilegesConverter {
	private static Logger logger = LogManager.getLogger(RolePrivileges.class);

	// Convert All List<Entity> to List<DTO>
		public static List<RolePrivilegesDto> EntityListTODtoList(List<RolePrivileges>  rolePrivilegesList) {
			if (rolePrivilegesList != null) {
				logger.info("Role Privileges Converter -> Convert Lists Entity to DTO");
				List<RolePrivilegesDto> listRolePrivilegesDto = new ArrayList<>();
				for (RolePrivileges rolePrivileges : rolePrivilegesList) {
					RolePrivilegesDto rolePrivilegesDto = new RolePrivilegesDto();
					rolePrivilegesDto.setProductprivilegeId(rolePrivileges.getId());
					rolePrivilegesDto.setRoleId(rolePrivileges.getRole().getRoleId());
					rolePrivilegesDto.setRoleName(rolePrivileges.getRole().getRoleName());
					rolePrivilegesDto.setProductprivilegeId(rolePrivileges.getProductprivilegeId());
					listRolePrivilegesDto.add(rolePrivilegesDto);
				}
				return listRolePrivilegesDto;
			}
			return null;
		}

		// Convert Data To Entity
				public static RolePrivileges DtoToEntity(RolePrivilegesDto rolePrivilegesDto) {
					RolePrivileges rolePrivileges = new RolePrivileges();
					if (rolePrivilegesDto != null) {
						logger.info("Role Privileges Converter -> Convert Object DTO to Entity For Save");
//						rolePrivileges.setId(rolePrivilegesDto.getRoleId());
						
						Role role = new Role();
						role.setRoleId(rolePrivilegesDto.getRoleId());
						role.setRoleName(rolePrivilegesDto.getRoleName());
						rolePrivileges.setRole(role);
						
						rolePrivileges.setProductprivilegeId(rolePrivilegesDto.getProductprivilegeId());
						
						return rolePrivileges;
					}
					return null;
				}

				// Convert Data To Entity
				public static RolePrivileges DtoToEntityUpdate(RolePrivilegesDto rolePrivilegesDto) {
					RolePrivileges rolePrivileges = new RolePrivileges();
					if (rolePrivilegesDto != null) {
						logger.info("Role Privileges Converter -> Convert Object DTO to Entity For Save");
						rolePrivileges.setId(rolePrivilegesDto.getRoleId());
						
						Role role = new Role();
						role.setRoleId(rolePrivilegesDto.getRoleId());
						role.setRoleName(rolePrivilegesDto.getRoleName());
						rolePrivileges.setRole(role);
						
						rolePrivileges.setProductprivilegeId(rolePrivilegesDto.getProductprivilegeId());
						
						return rolePrivileges;
					}
					return null;
				}

				// Convert Entity To Data
			public static RolePrivilegesDto EntityToDto(RolePrivileges rolePrivileges) {
				RolePrivilegesDto rolePrivilegesDto = new RolePrivilegesDto();
				if (rolePrivileges != null) {
					logger.info("Role Privileges Converter -> Convert Object Entity to DTO");
					rolePrivilegesDto.setProductprivilegeId(rolePrivileges.getId());
					rolePrivilegesDto.setRoleId(rolePrivileges.getRole().getRoleId());
					rolePrivilegesDto.setRoleName(rolePrivileges.getRole().getRoleName());
					rolePrivilegesDto.setProductprivilegeId(rolePrivileges.getProductprivilegeId());
					return rolePrivilegesDto;
				}
				return null;
			}
}
