package com.sgic.internal.defecttracker.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.entities.Module;
import com.sgic.internal.defecttracker.project.repositories.ModuleRepository;
import com.sgic.internal.defecttracker.project.services.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;

	@Override
	public Module createModule(Module module) {
		Module responseModule = moduleRepository.save(module);
		return responseModule;
	}

	@Override
	public void deleteById(String moduleId) {
		moduleRepository.getByModuleId(moduleId);

	}

	@Override
	public Module getByModuleId(String moduleId) {
		return moduleRepository.getByModuleId(moduleId);
	}

	@Override
	public List<Module> getBymoduleName(String moduleName) {
		return moduleRepository.getBymoduleName(moduleName);
	}

	@Override
	public List<Module> getallDetails() {
		return moduleRepository.findAll();
	}

	@Override
	public Module updateModule(String moduleId, Module module) {
		if (moduleRepository.findAll() != null) {
			module.setModuleId(moduleId);
			moduleRepository.save(module);
		}
		return module;
	}

	@Override
	public boolean isModuleAlreadyExists(String moduleId) {
		return moduleRepository.existsById(moduleId);
	}


}
