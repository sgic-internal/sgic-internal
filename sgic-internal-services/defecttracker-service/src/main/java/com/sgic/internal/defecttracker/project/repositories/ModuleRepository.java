
package com.sgic.internal.defecttracker.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgic.internal.defecttracker.project.entities.Module;
import com.sgic.internal.defecttracker.project.entities.Project;

public interface ModuleRepository extends JpaRepository<Module, String> {
	
	Module getByModuleId(String moduleId);

	@Query(value = "FROM Project WHERE module_name= :moduleName")
	List<Module> getBymoduleName(@Param("moduleName") String moduleName);

	//boolean exists(String moduleId);

	List<Module> findModuleByProject(Project project);
}

//package com.sgic.internal.defecttracker.project.repositories;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.sgic.internal.defecttracker.project.entities.Module;
//
//public interface ModuleRepository extends JpaRepository<Module, String>{
//
//	Module getBymoduleId(String id);
//	Module getBymoduleName(String name);
//}
