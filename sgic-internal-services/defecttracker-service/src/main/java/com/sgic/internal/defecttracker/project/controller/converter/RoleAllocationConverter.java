package com.sgic.internal.defecttracker.project.controller.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.controller.dto.RoleAllocationDto;
import com.sgic.internal.defecttracker.project.entities.RoleAllocation;
import com.sgic.internal.defecttracker.project.entities.SubModule;

@Service
public class RoleAllocationConverter {
	
	private RoleAllocationConverter() {
	}

	
	
	public static RoleAllocationDto roleAllocationToRoleAllocationDto(
			RoleAllocation roleAllocation) {
		RoleAllocationDto roleAllocationDto = new RoleAllocationDto();
		
		if(roleAllocation !=null) {
//			roleAllocationDto.setRoleId(roleAllocation.getRoleId());
//			roleAllocationDto.setAvailability(roleAllocation.getAvailability());
//			roleAllocationDto.setRole(roleAllocation.getRole());
//			roleAllocationDto.setrId(roleAllocation.getrId());
//			roleAllocationDto.setDesignationname(roleAllocation.getDesignationname());
//			roleAllocationDto.setEmpId(roleAllocation.getEmpId());
//			roleAllocationDto.setFirstname(roleAllocation.getFirstname());
//			roleAllocationDto.setSubModuleId(roleAllocation.getSubModule().getSubModuleId());
			//GetsubModuleId
//			RoleAllocation  roleAllocation2 = new RoleAllocation();
//			roleAllocationDto.setSubModuleId(roleAllocation.getSubModule().getSubModuleId());
			
			
			return roleAllocationDto;
			
		}
		return null;
			
		}
	
	public static RoleAllocation roleAllocationDtoToRoleAllocation(RoleAllocationDto roleAllocationDto) {
		RoleAllocation roleAllocation = new  RoleAllocation();
		
		
//			roleAllocation.setRoleId(roleAllocationDto.getRoleId());
//			roleAllocation.setAvailability(roleAllocationDto.getAvailability());
////			roleAllocation.setEmail(roleAllocationDto.getEmail());
//			roleAllocation.setRole(roleAllocationDto.getRole());
//			roleAllocation.setDesignationname(roleAllocationDto.getDesignationname());
//			roleAllocation.setEmpId(roleAllocationDto.getEmpId());
//			roleAllocation.setrId(roleAllocationDto.getrId());
//			roleAllocation.setFirstname(roleAllocationDto.getFirstname());
//			SubModule constructor
//			SubModule subModule =new SubModule();
//          get by subModuleId
//			subModule.setSubModuleId(roleAllocationDto.getSubModuleId());
//			roleAllocation.setSubModule(subModule);
			return roleAllocation;
			
	       
	
	
		 
} 
			
     
	
		
	
		
	public static List<RoleAllocationDto> roleAllocationToRoleAllocationDto(List<RoleAllocation>roleAllocationList){
		if(roleAllocationList!=null) {
			List<RoleAllocationDto>lRoleAllocationDto =new ArrayList<>();
			for(RoleAllocation roleAllocation: roleAllocationList) {
				RoleAllocationDto roleAllocationDto =new RoleAllocationDto();
				
				
//				roleAllocationDto.setAvailability(roleAllocation.getAvailability());;
//				roleAllocationDto.setDesignationname(roleAllocation.getDesignationname());;
//				roleAllocationDto.setEmpId(roleAllocation.getEmpId());
//				roleAllocationDto.setFirstname(roleAllocation.getFirstname());
//				roleAllocationDto.setRoleId(roleAllocation.getRoleId());
//				roleAllocationDto.setRole(roleAllocation.getRole());
//				roleAllocationDto.setrId(roleAllocation.getrId());
				lRoleAllocationDto.add(roleAllocationDto);
				// subModule constutor
//				roleAllocationDto.setSubModuleId(roleAllocation.getSubModule().getSubModuleId());
//				ListroleAllocationDto.add(roleAllocationDto);
			}
			return lRoleAllocationDto;
				
			}
		return null;
		}

	}
	
		
	


