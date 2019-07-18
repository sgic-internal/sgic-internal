package com.sgic.internal.defecttracker.dashBoard.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.dashBoard.service.DashboardService;
import com.sgic.internal.defecttracker.defect.repositories.DefectRepository;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private DefectRepository defectRepository;

	@Override
	public Integer countLow() {
		return defectRepository.countBySeverity();
	}

	@Override
	public Integer countMedium() {
		return defectRepository.countBySeverityMedium();
	}

	@Override
	public Integer countHigh() {
		return defectRepository.countBySeverityhigh();
	}

	@Override
	public Integer fetchHighWeight() {
		return defectRepository.getHighWeight();
	}

	@Override
	public Integer fetchMediumWeight() {
		return defectRepository.getMediumWeight();
	}

	@Override
	public Integer fetchLowWeight() {
		return defectRepository.getLowWeight();
	}

	@Override
	public Long TotalCount() {
		return defectRepository.count();
	}

	@Override
	public Double calculateSeverityIndex() {
		int countLow = countLow();
		int countMedium =countMedium();
		int countHigh =countHigh();
		int fetchHighWeight =fetchHighWeight();
		int fetchMediumWeight =fetchMediumWeight();
		int fetchLowWeight =fetchLowWeight();
		long totalCount =TotalCount();
		
		int severityIndex1 = ((countHigh* fetchHighWeight)+(countMedium*fetchMediumWeight)+(countLow*fetchLowWeight));
		double severityIndex1d = severityIndex1;
		
		int totcount =(int)totalCount;
		double totcountd = totcount;
		
		double severityIndex = severityIndex1d/totcountd;
		return severityIndex;
	}


}
