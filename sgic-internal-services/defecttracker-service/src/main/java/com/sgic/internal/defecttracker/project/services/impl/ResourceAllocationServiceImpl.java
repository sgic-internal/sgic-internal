package com.sgic.internal.defecttracker.project.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.internal.defecttracker.project.entities.ResourceAllocation;
import com.sgic.internal.defecttracker.project.entities.ResourceAllocationList;
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
		try {
			logger.info("ResourceAllocationServiceImpl-->successfully saved Resource");
			return resourceAllocationRepository.save(resourceAllocation);
		} catch (Exception ex) {
			logger.error("Resource Allocation Imp Error :-> " + ex.getMessage());
		}
		return null;

	}

	@Override
//	<---Resource Allocation Get List method's implementation--->
	public List<ResourceAllocation> gettAllResource() {
		try {
			logger.info("ResourceAllocationServiceImpl-->successfully listed Resource");
			return resourceAllocationRepository.findAll();
		} catch (Exception ex) {
			logger.error("Resource Allocation Imp Error :-> " + ex.getMessage());
		}
		return null;

	}

	@Override
//	<---Resource Allocation Get By Id  method's implementation--->
	public ResourceAllocation findResourceAllocationByresourceId(Long resourceId) {
		try {
			logger.info("ResourceAllocationServiceImpl-->successfully Get Resource By Id");
			return resourceAllocationRepository.findResourceAllocationByresourceId(resourceId);
		} catch (Exception ex) {
			logger.error("Resource Allocation Imp Error :-> " + ex.getMessage());
		}
		return null;

	}

	@Override
//	<---Resource Allocation List Resource Allocation By Id method's implementation--->
	public List<ResourceAllocation> getresourceById() {
		try {
			logger.info("ResourceAllocationServiceImpl-->successfully Resource by Resource Id");
			return resourceAllocationRepository.getAllresourceId();
		} catch (Exception ex) {
			logger.error("Resource Allocation Imp Error :-> " + ex.getMessage());
		}
		return null;

	}

	@Override
//	<---Resource Allocation List Resource Save  method's implementation--->
	public void saveResourceTable(List<ResourceAllocation> resourceAllocation) {

		try {
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
		} catch (Exception ex) {
			logger.error("Resource Allocation Imp Error :-> " + ex.getMessage());
		}

	}

	@Override
//	<---Resource Allocation Delete  method's implementation--->
	public ResourceAllocation deleteResourceById(Long resourceId) {
		try {
			logger.info("ResourceAllocationServiceImpl-->successfully Deleted");
			resourceAllocationRepository.deleteById(resourceId);
		} catch (Exception ex) {
			logger.error("Resource Allocation Imp Error :-> " + ex.getMessage());
		}

		return null;

	}

}
