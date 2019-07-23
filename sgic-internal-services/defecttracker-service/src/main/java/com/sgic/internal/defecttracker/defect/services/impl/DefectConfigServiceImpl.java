package com.sgic.internal.defecttracker.defect.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.entities.DefectConfig;
import com.sgic.internal.defecttracker.defect.repositories.DefectConfigRepository;
import com.sgic.internal.defecttracker.defect.services.DefectConfigService;

@Service
public class DefectConfigServiceImpl implements DefectConfigService{

	@Autowired
	DefectConfigRepository defectConfigRepository;
	@Override
	public Object createDefectConfig(DefectConfig defectConfig) {
		return defectConfigRepository.save(defectConfig);
	}
	@Override
	public DefectConfig findDefectConfigById(long id) {
		return defectConfigRepository.findById(id).orElse(null);
	}

}
