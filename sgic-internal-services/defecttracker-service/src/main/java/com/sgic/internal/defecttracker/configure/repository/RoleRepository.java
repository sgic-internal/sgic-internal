package com.sgic.internal.defecttracker.configure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.configure.entity.Role;

public interface RoleRepository   extends JpaRepository<Role, Long>{
	
}
