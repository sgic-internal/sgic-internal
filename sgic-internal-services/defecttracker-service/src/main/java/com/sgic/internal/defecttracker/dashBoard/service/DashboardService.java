package com.sgic.internal.defecttracker.dashBoard.service;

public interface DashboardService {

	public Integer countLow();
	
	public Integer countMedium();
	
	public Integer countHigh();
	
	public Integer fetchHighWeight();
	
	public Integer fetchMediumWeight();
	
	public Integer fetchLowWeight();
	
	public Long TotalCount();
	
	public Double calculateSeverityIndex();
	
	
}
