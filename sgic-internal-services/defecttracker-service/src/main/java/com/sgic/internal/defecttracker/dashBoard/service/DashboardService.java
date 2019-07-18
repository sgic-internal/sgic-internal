package com.sgic.internal.defecttracker.dashBoard.service;

public interface DashboardService {
	public Integer countLow();
	
	public Integer countMedium();
	
	public Integer countHigh();	
	
	public Integer countReject();
	
	public Integer fetchHighWeight();
	
	public Integer fetchMediumWeight();
	
	public Integer fetchLowWeight();
	
	public Long TotalCount();
	
	public Double calculateSeverityIndex();

	
	public float CalculateLow(long count,int reject, int low, int rejectlow);

	
}
