package com.sgic.internal.defecttracker.project.services;

import java.util.List;

import com.sgic.internal.defecttracker.project.entities.Module;
import com.sgic.internal.defecttracker.project.entities.Project;

public interface ModuleService {
	
	public Module createModule(Module module);

	public boolean isModuleAlreadyExists(String moduleId);

	public List<Module> getallDetails();

	public void deleteById(String moduleId);

	public Module updateModule(String moduleId, Module module);

	Module getByModuleId(String moduleId);

	public List<Module> getBymoduleName(String moduleName);
	
   public List<Module> getByprojectId(String projectid);

}
