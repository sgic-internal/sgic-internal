package com.sgic.internal.privileges.service;

import java.util.List;

import com.sgic.internal.privileges.entities.Privilege;

public interface PrivilegeService {
	
	// Get Privilege By Id
	public Privilege getPrivilegeById(Long privilageId);

	// Save Privilege
	public Privilege savePrivilege(Privilege privilege);

	// List all Privilege
	public List<Privilege> getAllPrivilege();

	// Delete Privilege
	public Privilege deletePrivilegeById(Long privilageId);

	// Update Privilege
	public Privilege updatePrivilege(Privilege privilege);

}
