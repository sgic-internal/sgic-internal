package com.sgic.internal.defecttracker.project.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.entities.SubModule;
import com.sgic.internal.defecttracker.project.repositories.SubModuleRepository;
import com.sgic.internal.defecttracker.project.services.SubModuleService;

@Service
public class SubModuleServiceImpl implements SubModuleService {

	@Autowired
	private SubModuleRepository subModuleRepository;

	@Override
	public SubModule createSubModule(SubModule subModule) {
		SubModule responseSubModule = subModuleRepository.save(subModule);
		return responseSubModule;
	}

	@Override
	public boolean isSubModuleAlreadyExists(String subModuleId) {
		return subModuleRepository.existsById(subModuleId);
	}

	@Override
	public List<SubModule> getallDetails() {
		return subModuleRepository.findAll();
	}

	@Override
	public void deleteSubModuleById(String subModuleId) {
		subModuleRepository.deleteById(subModuleId);

	}

	@Override
	public SubModule updateSubModule(String subModuleId, SubModule subModule) {
		if (subModuleRepository.getOne(subModuleId) != null) {
			subModule.setSubModuleId(subModuleId);
			subModuleRepository.save(subModule);
		}
		return subModule;
	}

	@Override
	public SubModule getBySubModuleId(String subModuleId) {
		return subModuleRepository.getBySubModuleId(subModuleId);
	}

	@Override
	public List<SubModule> getBysubModuleName(String subModuleName) {
		return subModuleRepository.getBysubModuleName(subModuleName);
	}

	@Override
	public List<SubModule> getByabbre(String abbre) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<SubModule> getByModuleId(String subModuleId) {
//		// TODO Auto-generated method stub
//		return subModuleRepository.getBySubModuleId(subModuleId);
//	}

//	@Override
//	public List<Module> getByprojectId(String projectid) {
//		return moduleRepository.getByProjectId(projectid);
//	}
}
