package com.sgic.internal.defecttracker.dashBoard.service;

public interface DashboardService {
	
	
public float CalculateLow(long count,int reject, int low, int rejectlow);

public float CalculateMedium(long count, int reject, int medium, int rejectmedium);
	
	public Integer countLow();
	
	public Integer countMedium();
	
	public Integer countHigh();	
	
	public Integer countReject();
	
	public Integer fetchHighWeight();
	
	public Integer fetchMediumWeight();
	
	public Integer fetchLowWeight();
	
	public Long TotalCount();
	
	public Double calculateSeverityIndex();

	
	

	
}
