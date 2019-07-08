package com.sgic.internal.defecttracker.project.services;

import java.util.List;

import com.sgic.internal.defecttracker.project.entities.Module;


public interface ModuleService {

	public Module createModule(Module module);

	public boolean isModuleAlreadyExists(String moduleId);

	public List<Module> getallDetails();

	public List<Object> getSubmodule(String projectid);

	public void deleteById(String moduleId);

	public Module updateModule(String moduleId, Module module);

	Module getByModuleId(String moduleId);

	public List<Module> getBymoduleName(String moduleName);

	// service for get project id
	public List<Module> getByprojectId(String projectid);

	// service for submodule id
//	public List<Module> getBySubModuleId(String subModuleId);

}
