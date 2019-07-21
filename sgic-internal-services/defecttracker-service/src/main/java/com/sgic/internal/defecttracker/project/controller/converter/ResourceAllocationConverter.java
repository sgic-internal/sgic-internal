package com.sgic.internal.defecttracker.project.controller.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.defecttracker.project.controller.dto.ResourceAllocationDto;
import com.sgic.internal.defecttracker.project.entities.Project;
import com.sgic.internal.defecttracker.project.entities.ResourceAllocation;

@Service
public class ResourceAllocationConverter {
	

	@Autowired
	private static Logger logger = LogManager.getLogger(ResourceAllocationDto.class);

//	<----Convert Variable Entity To DTO --- For Send DTO In To DataBase ---->
	public static ResourceAllocationDto ResourceAllocationToResourceAllocationDto(
			ResourceAllocation resourceAllocation) {
		ResourceAllocationDto resourceAllocationDto = new ResourceAllocationDto();
		if (resourceAllocation != null) {
			logger.info("Resource Allocation Converter--- successfully Converte Resource Allocation Entity To DTO");
			resourceAllocationDto.setResourceId(resourceAllocation.getResourceId());
			resourceAllocationDto.setProjectId(resourceAllocation.getProject().getProjectId());
			resourceAllocationDto.setProjectName(resourceAllocation.getProject().getProjectName());

			return resourceAllocationDto;
		}
		return resourceAllocationDto;
	}

//	<----Convert Variable DTO To Entity  --- For Get  Data Form  DataBase  ---->
	public static ResourceAllocation ResourceAllocationDtoToResourceAllocation(
			ResourceAllocationDto resourceAllocationDto) {
		ResourceAllocation resourceAllocation = new ResourceAllocation();
		if (resourceAllocationDto != null) {
			logger.info("Resource Allocation Converter--- successfully Converte Resource Allocation DTO  To Entity");
			resourceAllocation.setResourceId(resourceAllocationDto.getResourceId());
			resourceAllocation.setEmpId(resourceAllocationDto.getEmpId());
//			<----Set Project Variable to Resource Allocation DTo---->
			Project project = new Project();
			project.setProjectId(resourceAllocationDto.getProjectId());
			project.setProjectName(resourceAllocationDto.getProjectName());
			resourceAllocation.setProject(project);
			
			return resourceAllocation;
		}

		return null;

	}

//	<----Convert Variable DTO To Entity  --- For Get  List  Form  DataBase  ---->
	public static List<ResourceAllocationDto> ResourceAllocationToResourceAllocationDtoList(
			List<ResourceAllocation> resourceAllocationList) {
		if (resourceAllocationList != null) {
			List<ResourceAllocationDto> ListresourceAllocationDto = new ArrayList<>();
			for (ResourceAllocation resourceAllocation : resourceAllocationList) {
				logger.info("Resource Allocation Converter--- successfully Converte List");
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

//	<----Convert Variable DTO To Entity  --- For Send  List  Form  DataBase  ---->
	public static List<ResourceAllocation> ResourceAllocationDtoToResourceAllocationList(
			List<ResourceAllocationDto> resourceAllocationDtolist) {
		if (resourceAllocationDtolist != null) {
			List<ResourceAllocation> ListresourceAllocation = new ArrayList<>();
			for (ResourceAllocationDto resourceAllocationDto : resourceAllocationDtolist) {
				logger.info("Resource Allocation Converter--- successfully Converte Post List ");
				ResourceAllocation resourceAllocation = new ResourceAllocation();
				resourceAllocation.setResourceId(resourceAllocationDto.getResourceId());
				resourceAllocation.setEmpId(resourceAllocationDto.getEmpId());
//				<----Set Project Variable to Resource Allocation DTo---->
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
