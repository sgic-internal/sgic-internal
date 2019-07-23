package com.sgic.internal.defecttracker.project.services;

import java.util.List;

import com.sgic.internal.defecttracker.project.entities.ResourceAllocationList;

public interface ResourceAllocationListService {
	
	public ResourceAllocationList findResourceAllocationByresourceId(Long resourceId);
	public List<ResourceAllocationList> getAllresourceList();
}
