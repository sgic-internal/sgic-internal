package com.sgic.internal.defecttracker.project.controller.dto.mapper;

import java.util.List;

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
//	
//	@Autowired
//	private ResourceAllocationListService resourceAllocationListService;
//	
//	@SuppressWarnings("unused")
//	@Autowired
//	private ResourceAllocationListConverter resourceAllocationListConverter;
//	
	
	@SuppressWarnings("static-access")
	public ResourceAllocation saveResource (ResourceAllocationDto resourceAllocationDto) {
		return resourceAllocationService.saveresource(resourceAllocationConverter.ResourceAllocationDtoToResourceAllocation(resourceAllocationDto));
	}
	
	
	
	@SuppressWarnings("static-access")
	public List<ResourceAllocationDto> getAllResource(){
		List<ResourceAllocation> resourceList = resourceAllocationService.gettAllResource();
		return resourceAllocationConverter.ResourceAllocationToResourceAllocationDtoList(resourceList);
	}

	
	
	@SuppressWarnings("static-access")
	public  ResourceAllocationDto findResourceAllocationByresourceId(Long resourceId) {
		ResourceAllocation resourceAllocation = resourceAllocationService.findResourceAllocationByresourceId(resourceId);
		return resourceAllocationConverter.ResourceAllocationToResourceAllocationDto(resourceAllocation);
	}
	
	@SuppressWarnings("unused")
	public  List<ResourceAllocation> getresourceById(Long resourceId) {
		List<ResourceAllocation> resourceAllocation;
		return resourceAllocationService.getresourceById();
	}
	
	
//	@SuppressWarnings("static-access")
//	public List<ResourceAllocationList> getAllResourceList(){
//		@SuppressWarnings("unused")
//		List<ResourceAllocationList> resourceAllocationList;
//		return resourceAllocationListService.getAllresourceList();
////		return resourceAllocationListConverter.ResourceAllocationListToResourceAllocationListDto(resourceAllList);
//
//	}

	
	
	
}




	

