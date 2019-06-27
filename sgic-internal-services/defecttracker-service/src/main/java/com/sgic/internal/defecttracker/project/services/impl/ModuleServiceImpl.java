//package com.sgic.internal.defecttracker.project.services.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sgic.internal.defecttracker.project.entities.Module;
//import com.sgic.internal.defecttracker.project.repositories.ModuleRepository;
//import com.sgic.internal.defecttracker.project.services.ModuleService;
//
//@Service
//public class ModuleServiceImpl  implements ModuleService{
//
//	@Autowired
//	private ModuleRepository moduleRepository;
//	
//	@Override
//	public Module createProject(Module module) {
//		Module responseModule = moduleRepository.save(module);
//		return responseModule;
//	}
//
//	@Override
//	public boolean isModuleAlreadyExists(String id) {
//		return moduleRepository.existsById(id);
//	}
//
//	@Override
//	public List<Module> getallDetails() {
//		return moduleRepository.findAll();
//	}
//
//	@Override
//	public void delete(String id) {
//		moduleRepository.deleteById(id);
//		
//	}
//
//	@Override
//	public Module updateModule(Module module) {
//		
//		return moduleRepository.save(module);
//	}
//
//	@Override
//	public Module getBymoduleId(String id) {
//		return moduleRepository.getBymoduleId(id);
//	}
//
//	@Override
//	public Module getBymoduleName(String name) {
//		return moduleRepository.getBymoduleName(name);
//	}
//
//}
