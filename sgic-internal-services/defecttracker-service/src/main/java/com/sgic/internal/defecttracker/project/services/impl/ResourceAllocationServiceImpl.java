package com.sgic.internal.defecttracker.project.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.defecttracker.project.entities.ResourceAllocation;
import com.sgic.internal.defecttracker.project.repositories.ResourceAllocationRepository;
import com.sgic.internal.defecttracker.project.services.ResourceAllocationService;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

	@Autowired
	private ResourceAllocationRepository resourceAllocationRepository;

	@Autowired
	private static Logger logger = LogManager.getLogger(ResourceAllocationRepository.class);

	@Override
//	<---Resource Allocation Save method's implementation--->
	public ResourceAllocation saveresource(ResourceAllocation resourceAllocation) {
		logger.info("ResourceAllocationServiceImpl-->successfully saved Resource");
		return resourceAllocationRepository.save(resourceAllocation);
	}

	@Override
//	<---Resource Allocation Get List method's implementation--->
	public List<ResourceAllocation> gettAllResource() {
		logger.info("ResourceAllocationServiceImpl-->successfully listed Resource");
		return resourceAllocationRepository.findAll();
	}

	@Override
//	<---Resource Allocation Get By Id  method's implementation--->
	public ResourceAllocation findResourceAllocationByresourceId(Long resourceId) {
		logger.info("ResourceAllocationServiceImpl-->successfully Get Resource By Id");
		return resourceAllocationRepository.findResourceAllocationByresourceId(resourceId);
	}

	@Override
//	<---Resource Allocation List Resource Allocation By Id method's implementation--->
	public List<ResourceAllocation> getresourceById() {
		logger.info("ResourceAllocationServiceImpl-->successfully Resource by Resource Id");
		return resourceAllocationRepository.getAllresourceId();
	}

	@Override
//	<---Resource Allocation List Resource Save  method's implementation--->
	public void saveResourceTable(List<ResourceAllocation> resourceAllocation) {

		int size = resourceAllocation.size();
		int counter = 0;
		List<ResourceAllocation> temp = new ArrayList<>();

		for (ResourceAllocation emp : resourceAllocation) {
			logger.info("ResourceAllocationServiceImpl-->successfully Resource ---Get -- By --List");
			temp.add(emp);

			if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
				logger.info("ResourceAllocationServiceImpl-->successfully Resource ---Get -- By --List Saved");
				resourceAllocationRepository.saveAll(resourceAllocation);
				temp.clear();
			}
			counter++;
		}
	}

}
