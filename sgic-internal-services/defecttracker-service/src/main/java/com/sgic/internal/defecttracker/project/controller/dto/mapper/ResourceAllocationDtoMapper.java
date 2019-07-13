package com.sgic.internal.defecttracker.project.controller.dto.mapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.defecttracker.project.controller.converter.ResourceAllocationConverter;
import com.sgic.internal.defecttracker.project.controller.dto.ResourceAllocationDto;
import com.sgic.internal.defecttracker.project.entities.ResourceAllocation;
import com.sgic.internal.defecttracker.project.services.ResourceAllocationService;

@Service
public class ResourceAllocationDtoMapper {

	@Autowired
	private ResourceAllocationConverter resourceAllocationConverter;

	@Autowired
	private ResourceAllocationService resourceAllocationService;

	@Autowired
	private static Logger logger = LogManager.getLogger(ResourceAllocationService.class);

	@SuppressWarnings("static-access")
//	<--- Save Method's Mapped ---Single Object -->
	public ResourceAllocation saveResource(ResourceAllocationDto resourceAllocationDto) {
		logger.info("Resource Allaction Mapper --- Successfully Saved Resource Allocation --- Single Object ");
		return resourceAllocationService.saveresource(
				resourceAllocationConverter.ResourceAllocationDtoToResourceAllocation(resourceAllocationDto));
	}

	@SuppressWarnings("static-access")
//	<--- SaveAll Method's Mapped --- Balk Object -->
	public void saveResourceTable(List<ResourceAllocationDto> resourceAllocationDto) {
		logger.info("Resource Allaction Mapper --- Successfully Saved Resource Allocation --- Balk Data");
		resourceAllocationService.saveResourceTable(
				resourceAllocationConverter.ResourceAllocationDtoToResourceAllocationList(resourceAllocationDto));

	}

	@SuppressWarnings("static-access")
//	<--- Get List Method's Mapped  -->
	public List<ResourceAllocationDto> getAllResource() {
		logger.info("Resource Allaction Mapper --- Successfully Listed Resource Allocation --- ");
		List<ResourceAllocation> resourceList = resourceAllocationService.gettAllResource();
		return resourceAllocationConverter.ResourceAllocationToResourceAllocationDtoList(resourceList);
	}

	@SuppressWarnings("static-access")
//	<--- Get By Resource Resource Id  Method's Mapped  -->
	public ResourceAllocationDto findResourceAllocationByresourceId(Long resourceId) {
		logger.info("Resource Allaction Mapper --- Successfully Get  Resource Allocation By Id --- ");
		ResourceAllocation resourceAllocation = resourceAllocationService
				.findResourceAllocationByresourceId(resourceId);
		return resourceAllocationConverter.ResourceAllocationToResourceAllocationDto(resourceAllocation);
	}

//	<--- Get Resource List By Resource Id  Method's Mapped  -->
	public List<ResourceAllocation> getresourceById(Long resourceId) {
		logger.info("Resource Allaction Mapper --- Successfully Resource Allocation Id Listed --- ");
		@SuppressWarnings("unused")
		List<ResourceAllocation> resourceAllocation;
		return resourceAllocationService.getresourceById();
	}

}
