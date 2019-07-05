package com.sgic.internal.defecttracker.project.controller.dtomapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sgic.internal.defecttracker.project.controller.converter.SubModuleConverter;

<<<<<<< HEAD
import com.sgic.internal.defecttracker.project.controller.dto.SubModuleDto;

import com.sgic.internal.defecttracker.project.entities.SubModule;

import com.sgic.internal.defecttracker.project.services.SubModuleService;

=======
import com.sgic.internal.defecttracker.project.controller.dto.SubModuleData;

import com.sgic.internal.defecttracker.project.entities.SubModule;
import com.sgic.internal.defecttracker.project.services.SubModuleService;



>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
@Service
public class SubModuleDtoMapper {
	@Autowired
	public SubModuleService subModuleService; 
	
<<<<<<< HEAD
	public List<SubModuleDto>getAllSubModuleForMapper(){
=======
	public List<SubModuleData>getAllSubModuleForMapper(){
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
		List<SubModule>subModuleList =subModuleService.getallDetails();
		return SubModuleConverter.subModuleToSubModuleDto(subModuleList);
	}
	
<<<<<<< HEAD
	public SubModule saveSubModuleforMapper(SubModuleDto subModuleDto) {
		SubModule subModule = SubModuleConverter.subModuleDtoToSubModule(subModuleDto);
		return subModuleService.createSubModule(subModule);
	}
	
	public SubModuleDto getBySubModuleId(String subModuleId) {
=======
	public SubModule saveSubModuleforMapper(SubModuleData subModuleData) {
		SubModule subModule = SubModuleConverter.subModuleDtoToSubModule(subModuleData);
		return subModuleService.createSubModule(subModule);
	}
	
	public SubModuleData getBySubModuleId(String subModuleId) {
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
		SubModule subModule = subModuleService.getBySubModuleId(subModuleId);
		return SubModuleConverter.subModuleTosubModuleDto(subModule);
	}
	
<<<<<<< HEAD
	public List<SubModuleDto>getBysubModuleNameForMapper(String subModuleName){
=======
	public List<SubModuleData>getBysubModuleNameForMapper(String subModuleName){
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
		List <SubModule>subModule=subModuleService.getBysubModuleName(subModuleName);
		return SubModuleConverter.subModuleToSubModuleDto(subModule);
		
	}

<<<<<<< HEAD
	public SubModule UpdateSubModule(String subModuleId, SubModuleDto subModuleDto) {
		SubModule subModule = SubModuleConverter.subModuleDtoToSubModule(subModuleDto);
		return subModuleService.updateSubModule(subModuleId, subModule);
		
	}
	public SubModuleDto deleteById(String subModuleId) {
		subModuleService.deleteById(subModuleId);
		return null;
	}
=======
	public SubModule UpdateSubModule(String subModuleId, SubModuleData subModuleData) {
		SubModule subModule = SubModuleConverter.subModuleDtoToSubModule(subModuleData);
		return subModuleService.updateSubModule(subModuleId, subModule);
		
	}
	public SubModuleData deleteById(String subModuleId) {
		subModuleService.deleteById(subModuleId);
		return null;
	}

	

	
>>>>>>> f1bb3f266238a45ba97d2ec2eb6348085a0c1f87
}
