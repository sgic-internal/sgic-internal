package com.sgic.internal.defecttracker.configure.services;

import java.util.List;

import com.sgic.internal.defecttracker.configure.entity.Role;

public interface RoleService {
	// Save Role
	public List<Role> saveRole();
	// List all Role
	public List<Role> getAllRole();
}
