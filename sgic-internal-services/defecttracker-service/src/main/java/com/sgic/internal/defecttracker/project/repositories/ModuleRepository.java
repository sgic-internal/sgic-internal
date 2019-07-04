
package com.sgic.internal.defecttracker.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgic.internal.defecttracker.project.entities.Module;

public interface ModuleRepository extends JpaRepository<Module, String> {
	
	Module getByModuleId(String moduleId);

	@Query(value = "FROM Module WHERE module_name= :moduleName")
	List<Module> getBymoduleName(@Param("moduleName") String moduleName);

	

}