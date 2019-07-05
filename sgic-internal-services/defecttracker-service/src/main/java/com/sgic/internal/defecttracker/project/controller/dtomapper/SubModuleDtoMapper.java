package com.sgic.internal.defecttracker.project.controller.dtomapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sgic.internal.defecttracker.project.controller.converter.SubModuleConverter;

import com.sgic.internal.defecttracker.project.controller.dto.SubModuleDto;

import com.sgic.internal.defecttracker.project.entities.SubModule;
import com.sgic.internal.defecttracker.project.services.SubModuleService;



@Service
public class SubModuleDtoMapper {
	@Autowired
	public SubModuleService subModuleService; 
	
	public List<SubModuleDto>getAllSubModuleForMapper(){
		List<SubModule>subModuleList =subModuleService.getallDetails();
		return SubModuleConverter.subModuleToSubModuleDto(subModuleList);
	}
	
	public SubModule saveSubModuleforMapper(SubModuleDto subModuleDto) {
		SubModule subModule = SubModuleConverter.subModuleDtoToSubModule(subModuleDto);
		return subModuleService.createSubModule(subModule);
	}
	
	public SubModuleDto getBySubModuleId(String subModuleId) {
		SubModule subModule = subModuleService.getBySubModuleId(subModuleId);
		return SubModuleConverter.subModuleTosubModuleDto(subModule);
	}
	
	public List<SubModuleDto>getBysubModuleNameForMapper(String subModuleName){
		List <SubModule>subModule=subModuleService.getBysubModuleName(subModuleName);
		return SubModuleConverter.subModuleToSubModuleDto(subModule);
		
	}

	public SubModule UpdateSubModule(String subModuleId, SubModuleDto subModuleDto) {
		SubModule subModule = SubModuleConverter.subModuleDtoToSubModule(subModuleDto);
		return subModuleService.updateSubModule(subModuleId, subModule);
		
	}
	public SubModuleDto deleteById(String subModuleId) {
		subModuleService.deleteById(subModuleId);
		return null;
	}

	

	
}
