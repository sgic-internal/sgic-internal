package com.sgic.internal.defecttracker.configure.services;

import java.util.List;

import com.sgic.internal.defecttracker.configure.entity.ProductPrivilege;
import com.sgic.internal.defecttracker.configure.entity.RolePrivileges;


public interface RolePrivilegesService {
		// Create RolePrivileges
		public RolePrivileges createRolePrivileges(RolePrivileges rolePrivileges);
		// Update RolePrivileges
		public RolePrivileges updateRolePrivileges(RolePrivileges rolePrivileges);
		// Get RolePrivileges By Id
		public RolePrivileges getRolePrivilegesById(Long rolePrivilegesId);
		// Get All RolePrivileges 
		public List<RolePrivileges> getAllRolePrivilegesy();
		// Delete RolePrivileges Id
		public RolePrivileges deleteRolePrivilegesById(Long rolePrivilegesId);
		//
		public List<RolePrivileges> getAllProductPrivilegesIds();
		
		public List<ProductPrivilege> getAllProductPrivileges(); 
		
		public ProductPrivilege getProductPrivilegeById(Long productPrivilegeId);
}
