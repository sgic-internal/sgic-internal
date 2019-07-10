package com.sgic.internal.product.privileges.services;

import java.util.List;

import com.sgic.internal.product.privileges.entities.Role;

public interface RoleService {
	
	// Get Role By Id
	public Role getRoleById(Long roleId);

	// Save Role
	public Role saveRole(Role role);

	// List all Role
	public List<Role> getAllRole();

	// Delete Role
	public Role deleteRoleById(Long roleId);

	// Update Role
	public Role updateRole(Role role);

}
