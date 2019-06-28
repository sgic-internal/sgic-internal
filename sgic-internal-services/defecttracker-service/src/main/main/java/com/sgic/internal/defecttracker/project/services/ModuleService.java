package com.sgic.internal.defecttracker.project.services;

import java.util.List;

import com.sgic.internal.defecttracker.project.entities.Module;

public interface ModuleService {

	public Module createProject(Module module);
	public boolean isModuleAlreadyExists(Long id);
	public List<Module>getallDetails();
	public void delete(Long id);
	Module updateModule(Module module);
	Module getBymoduleId(Long id);
	Module getBymoduleName (String name);
}
