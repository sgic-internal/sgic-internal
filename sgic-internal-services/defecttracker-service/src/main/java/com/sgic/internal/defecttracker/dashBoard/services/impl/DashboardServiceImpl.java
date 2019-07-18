package com.sgic.internal.defecttracker.dashBoard.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.dashBoard.repository.DashboardRepository;
import com.sgic.internal.defecttracker.dashBoard.service.DashboardService;
import com.sgic.internal.defecttracker.defect.repositories.DefectRepository;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private DefectRepository defectRepository;
	
	

	@SuppressWarnings("unused")
	private DashboardRepository dashboardRepository;

	@Override
	public Integer countlow() {
		return defectRepository.countBySeverity();
	}

	@Override
	public Integer countmudium() {
		return defectRepository.countBySeverityMedium();
	}

	@Override
	public Integer countHigh() {
		return defectRepository.countBySeverityhigh();
	}

	@Override
	public Integer countReject() {
		return defectRepository.countByStatusRejected();
	}

	@Override
	public float CalculateLow(long count, int reject, int low, int rejectlow) {
	    count = (int) defectRepository.count();
	    System.out.println(count);
	    reject = defectRepository.countByStatusRejected();
	    System.out.println(reject);
	    low = defectRepository.countBySeverity();
	    System.out.println(low);
	    rejectlow = defectRepository.countByStatusRejectedlow();
	    System.out.println(rejectlow);
		int c =(int) (count - reject);
		 System.out.println(c);
		int d = (int)(low - rejectlow);
		 System.out.println(d);
		float LowSeverity = (d *100/c);
		 System.out.println(LowSeverity);
		return LowSeverity;
	}

	@Override
	public float Calculatseverityhigh(long count, int reject, int High, int rejectHigh) {

		count = (int) defectRepository.count();
	    System.out.println(count);
	    
	    reject = defectRepository.countByStatusRejected();
	    System.out.println(reject);
	    
	    High = defectRepository.countBySeverity();
	    System.out.println(High);
	    
	    rejectHigh = defectRepository.countByStatusRejectedHigh();
	    System.out.println(rejectHigh);
	    
		int c =(int) (count - reject);
		 System.out.println(c);
		 
		int d = (int)(High - rejectHigh);
		 System.out.println(d);
		 
		float HighSeverity = (d *100/c);
		 System.out.println(HighSeverity);
		return HighSeverity;
		
	}

	@Override
	public Integer countseveritylow() {
		return defectRepository.countBySeverityhigh() ;
	}

	@Override
	public Integer countseveritymudium() {
		return defectRepository.countBySeverityMedium();
	}

	@Override
	public Integer countseverityHigh() {
		return defectRepository.countBySeverityhigh();
	}

	@Override
	public Integer countseverityReject() {
		return defectRepository.countByStatusRejected();
	}
}
