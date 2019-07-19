package com.sgic.internal.defecttracker.project.controller.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.controller.dto.RoleAllocationDto;
import com.sgic.internal.defecttracker.project.entities.Role;
import com.sgic.internal.defecttracker.project.entities.RoleAllocation;

@Service
public class RoleAllocationConverter {

	private RoleAllocationConverter() {
	}

	public static RoleAllocationDto roleAllocationToRoleAllocationDto(RoleAllocation roleAllocation) {
		RoleAllocationDto roleAllocationDto = new RoleAllocationDto();

		if (roleAllocation != null) {
			roleAllocationDto.setRoleallocationId(roleAllocation.getRoleallocationId());
			roleAllocationDto.setAvailability(roleAllocation.getAvailability());
			roleAllocationDto.setrId(roleAllocation.getrId());
			roleAllocationDto.setDesignationname(roleAllocation.getDesignationname());
			roleAllocationDto.setEmpId(roleAllocation.getEmpId());
			roleAllocationDto.setFirstname(roleAllocation.getFirstname());

//			new RoleAllocation();
//			roleAllocationDto.setRoleId(roleAllocation.getRole().getRoleId());


			
			return roleAllocationDto;

		}
		return null;

	}

	public static RoleAllocation roleAllocationDtoToRoleAllocation(RoleAllocationDto roleAllocationDto) {
		RoleAllocation roleAllocation = new RoleAllocation();
		
		Role role = new Role();
		new RoleAllocation();
		
		roleAllocation.setRoleallocationId(roleAllocationDto.getRoleallocationId());
		roleAllocation.setAvailability(roleAllocationDto.getAvailability());
		roleAllocation.setDesignationname(roleAllocationDto.getDesignationname());
		roleAllocation.setEmpId(roleAllocationDto.getEmpId());
		roleAllocation.setrId(roleAllocationDto.getrId());
		roleAllocation.setFirstname(roleAllocationDto.getFirstname());
		
		// get by Role id
//		role.setRoleId(roleAllocationDto.getRoleId());
//		roleAllocation.setRole(role);
		return roleAllocation;

	}

	public static List<RoleAllocationDto> roleAllocationToRoleAllocationDto(List<RoleAllocation> roleAllocationList) {
		if (roleAllocationList != null) {
			List<RoleAllocationDto> lRoleAllocationDto = new ArrayList<>();
			for (RoleAllocation roleAllocation : roleAllocationList) {
				RoleAllocationDto roleAllocationDto = new RoleAllocationDto();

				roleAllocationDto.setAvailability(roleAllocation.getAvailability());
				roleAllocationDto.setDesignationname(roleAllocation.getDesignationname());
				roleAllocationDto.setEmpId(roleAllocation.getEmpId());
				roleAllocationDto.setRoleallocationId(roleAllocation.getRoleallocationId());
				roleAllocationDto.setFirstname(roleAllocation.getFirstname());
				roleAllocationDto.setrId(roleAllocation.getrId());
//				roleAllocationDto.setRoleId(roleAllocation.getRole().getRoleId());
				lRoleAllocationDto.add(roleAllocationDto);

			}
			return lRoleAllocationDto;

		}
		return null;
	}

}
