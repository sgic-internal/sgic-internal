<<<<<<< HEAD
package com.sgic.internal.defecttracker.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgic.internal.defecttracker.project.entities.Module;

public interface ModuleRepository extends JpaRepository<Module, String> {
	
	Module getByModuleId(String moduleId);

	@Query(value = "FROM Project WHERE module_name= :moduleName")
	List<Module> getBymoduleName(@Param("moduleName") String moduleName);

	//boolean exists(String moduleId);

}
=======
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
>>>>>>> 2abd14002e2c632b7456f4e8d098e5f21d4b008f
