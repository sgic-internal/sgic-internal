package com.sgic.internal.defecttracker.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.entities.Module;
import com.sgic.internal.defecttracker.project.repositories.ModuleRepository;
import com.sgic.internal.defecttracker.project.repositories.ProjectRepository;
import com.sgic.internal.defecttracker.project.services.ModuleService;

@Service
public class ModuleServiceImpl  implements ModuleService{

	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired
	private ProjectRepository projectRepositoy;

	@Override
	public Module createModule(Module module) {
		// get the abbreviation of project
		
		// get the count of modules by project id
		
		// build the abbreviation string
		
		// set the datas
		
		// save the data
		return moduleRepository.save(module);
	}

	@Override
	public boolean isModuleAlreadyExists(String moduleId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Module> getallDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String moduleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Module updateModule(String moduleId, Module module) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Module getByModuleId(String moduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Module> getBymoduleName(String moduleName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
