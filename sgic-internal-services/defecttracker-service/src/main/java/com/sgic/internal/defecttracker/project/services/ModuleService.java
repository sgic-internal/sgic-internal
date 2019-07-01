<<<<<<< HEAD
package com.sgic.internal.defecttracker.project.services;

import java.util.List;

import com.sgic.internal.defecttracker.project.entities.Module;

public interface ModuleService {
	
	public Module createModule(Module module);

	public boolean isModuleAlreadyExists(String moduleId);

	public List<Module> getallDetails();

	public void deleteById(String moduleId);

	public Module updateModule(String moduleId, Module module); // Update moduleid

	Module getByModuleId(String moduleId);

	public List<Module> getBymoduleName(String moduleName);

}
=======
//package com.sgic.internal.defecttracker.project.services;
//
//import java.util.List;
//
//import com.sgic.internal.defecttracker.project.entities.Module;
//
//public interface ModuleService {
//
//	public Module createProject(Module module);
//	public boolean isModuleAlreadyExists(String id);
//	public List<Module>getallDetails();
//	public void delete(String id);
//	Module updateModule(Module module);
//	Module getBymoduleId(String id);
//	Module getBymoduleName (String name);
//}
>>>>>>> 2abd14002e2c632b7456f4e8d098e5f21d4b008f
