package com.sgic.internal.defecttracker.project.services;

import java.util.List;

import com.sgic.internal.defecttracker.project.entities.ResourceAllocation;
import com.sgic.internal.defecttracker.project.entities.ResourceAllocationList;

public interface ResourceAllocationService {
	
	public ResourceAllocation saveresource (ResourceAllocation resourceAllocation);
	
	public List<ResourceAllocation> gettAllResource();
	
	public ResourceAllocation findResourceAllocationByresourceId(Long resourceId);

    public List<ResourceAllocation> getresourceById();
    
    
}
