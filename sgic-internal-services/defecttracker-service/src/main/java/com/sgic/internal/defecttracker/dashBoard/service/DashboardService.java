package com.sgic.internal.defecttracker.dashBoard.service;

public interface DashboardService {
	
	
public float CalculateLow(long count,int reject, int low, int rejectlow);

	public Integer countlow();
	
	public Integer countmudium();
	
	public Integer countHigh();
	
	public Integer countReject();
}
