package com.sgic.internal.defecttracker.configure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.configure.entity.RolePrivileges;

public interface RolePrivilegesRepository  extends JpaRepository<RolePrivileges, Long>{
	RolePrivileges findRolePrivilegesById(Long id);
}
