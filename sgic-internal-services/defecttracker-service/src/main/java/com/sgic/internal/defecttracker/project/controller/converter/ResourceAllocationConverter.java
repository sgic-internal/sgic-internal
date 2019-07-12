package com.sgic.internal.defecttracker.project.controller.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.controller.dto.ResourceAllocationDto;
import com.sgic.internal.defecttracker.project.entities.Project;
import com.sgic.internal.defecttracker.project.entities.ResourceAllocation;

@Service
public class ResourceAllocationConverter {

	public static ResourceAllocationDto ResourceAllocationToResourceAllocationDto(
			ResourceAllocation resourceAllocation) {
		ResourceAllocationDto resourceAllocationDto = new ResourceAllocationDto();

		if (resourceAllocation != null) {
			resourceAllocationDto.setResourceId(resourceAllocation.getResourceId());
//			resourceAllocationDto.setEmpId(resourceAllocation.getEmpId());
			resourceAllocationDto.setProjectId(resourceAllocation.getProject().getProjectId());
			resourceAllocationDto.setProjectName(resourceAllocation.getProject().getProjectName());

			return resourceAllocationDto;
		}
		return resourceAllocationDto;
	}

	public static ResourceAllocation ResourceAllocationDtoToResourceAllocation(
			ResourceAllocationDto resourceAllocationDto) {
		ResourceAllocation resourceAllocation = new ResourceAllocation();
		if (resourceAllocationDto != null) {
			resourceAllocation.setResourceId(resourceAllocationDto.getResourceId());
			resourceAllocation.setEmpId(resourceAllocationDto.getEmpId());
			Project project = new Project();
			// project.setPid(resourceAllocationDto.getPid());
			project.setProjectId(resourceAllocationDto.getProjectId());
			project.setProjectName(resourceAllocationDto.getProjectName());
			resourceAllocation.setProject(project);

			return resourceAllocation;
		}

		return null;

	}

	public static List<ResourceAllocationDto> ResourceAllocationToResourceAllocationDtoList(
			List<ResourceAllocation> resourceAllocationList) {

		if (resourceAllocationList != null) {
			List<ResourceAllocationDto> ListresourceAllocationDto = new ArrayList<>();
			for (ResourceAllocation resourceAllocation : resourceAllocationList) {
				ResourceAllocationDto resourceAllocationDto = new ResourceAllocationDto();
				resourceAllocationDto.setResourceId(resourceAllocation.getResourceId());
				resourceAllocationDto.setEmpId(resourceAllocation.getEmpId());
				resourceAllocationDto.setProjectId(resourceAllocation.getProject().getProjectId());
				resourceAllocationDto.setProjectName(resourceAllocation.getProject().getProjectName());

				ListresourceAllocationDto.add(resourceAllocationDto);

			}

			return ListresourceAllocationDto;
		}
		return null;

	}

	public static List<ResourceAllocation> ResourceAllocationDtoToResourceAllocationList(
			List<ResourceAllocationDto> resourceAllocationDtolist) {

		if (resourceAllocationDtolist != null) {
			List<ResourceAllocation> ListresourceAllocation = new ArrayList<>();
			for (ResourceAllocationDto resourceAllocationDto : resourceAllocationDtolist) {

				ResourceAllocation resourceAllocation = new ResourceAllocation();
				resourceAllocation.setResourceId(resourceAllocationDto.getResourceId());
				resourceAllocation.setEmpId(resourceAllocationDto.getEmpId());
				Project project = new Project();
				project.setProjectId(resourceAllocationDto.getProjectId());
				resourceAllocation.setProject(project);
				ListresourceAllocation.add(resourceAllocation);

			}

			return ListresourceAllocation;
		}
		return null;

	}
}
