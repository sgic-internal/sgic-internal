package com.sgic.internal.product.controller.dto.mapper;
//package com.sgic.internal.product.privileges.controller.dto.mapper;
//
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.sgic.internal.product.privileges.controller.dto.RoleDTO;
//import com.sgic.internal.product.privileges.controller.dto.converter.RoleConverter;
//import com.sgic.internal.product.privileges.entities.Role;
//import com.sgic.internal.product.privileges.services.RoleService;
//
//public class RoleMapper {
//	
//	@Autowired
//	private RoleConverter roleConverter;
//	@Autowired
//	private RoleService roleService;
//
//	private static Logger logger = LogManager.getLogger(RoleDTO.class);
//
//	// Get All Privilege
//	@SuppressWarnings("static-access")
//	public List<RoleDTO> getAllRole() {
//		logger.info("Role Mapper -> All Role Data Retrieved");
//		List<Role> rolelist = roleService.getAllRole();
//		return roleConverter.RoleEntityTORoleDTOList(rolelist);
//	}
//
//	// Save Role
//	@SuppressWarnings("static-access")
//	public Role saveRole(RoleDTO roleDTO) {
//		logger.info("Role Mapper -> Role Saved");
//		return roleService.saveRole(roleConverter.RoleDTOTORoleEntity(roleDTO));
//	}
//
//	// Update Role
//	@SuppressWarnings("static-access")
//	public Role updateRole(RoleDTO roleDTO) {
//		logger.info("Role Mapper -> Role Updated ", roleDTO.getRoleName());
//		return roleService.updateRole(roleConverter.RoleDTOTORoleEntity(roleDTO)); 
//	}
//
//	// Delete Role
//	public RoleDTO deleteRoleById(Long roleId) {
//		logger.info("Role Mapper -> Role Deleted");
//		roleService.deleteRoleById(roleId);
//		return null;
//	}
//
//	// Get Role By Id
//	@SuppressWarnings("static-access")
//	public RoleDTO getRoleById(Long roleId) {
//		logger.info("Role Mapper -> Role Id Found");
//		Role role  = roleService.getRoleById(roleId);
//		return roleConverter.RoleEntityTORoleDTO(role);
//	}
//
//
//}
