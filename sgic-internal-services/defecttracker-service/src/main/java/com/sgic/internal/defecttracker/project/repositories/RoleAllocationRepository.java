package com.sgic.internal.defecttracker.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgic.internal.defecttracker.project.entities.Module;
import com.sgic.internal.defecttracker.project.entities.RoleAllocation;
import com.sgic.internal.defecttracker.project.entities.SubModule;


public interface RoleAllocationRepository  extends JpaRepository<RoleAllocation, Long> {
	// Find Employee By ID Method
//	RoleAllocation findEmployeeByEmpId(Long empId);

	RoleAllocation getByroleId(Long roleId);
//	 RoleAllocation getByempId(Long empId);
	
}
