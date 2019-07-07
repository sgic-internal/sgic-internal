package com.sgic.internal.defecttracker.project.services;

import java.util.List;

import com.sgic.internal.defecttracker.project.entities.SubModule;

public interface SubModuleService {

	public SubModule createSubModule(SubModule subModule);

	public boolean isSubModuleAlreadyExists(String subModuleId);

	public List<SubModule> getallDetails();

	public void deleteById(String subModuleId);

	public SubModule updateSubModule(String subModuleId, SubModule subModule);

	public SubModule getBySubModuleId(String subModuleId);
	
	public List<SubModule> getByabbr(String abbr);

	public List<SubModule> getBysubModuleName(String subModuleName);

}
