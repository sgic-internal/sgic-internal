package com.sgic.internal.defecttracker.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.defecttracker.project.entities.Module;

public interface ModuleRepository extends JpaRepository<Module, Long>{

	Module getBymoduleId(Long id);
	Module getBymoduleName(String name);
}
