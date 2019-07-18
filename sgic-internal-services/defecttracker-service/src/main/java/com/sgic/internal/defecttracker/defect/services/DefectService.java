package com.sgic.internal.defecttracker.defect.services;


import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.entities.Defect;

@Service
public interface DefectService {

	public Defect createDefect(Defect defect);   
	public Defect getByDefectId(String defectId);
	public Defect updateDefect(Defect defect);
	public Defect deleteDefect(String defectId);   
	public List<Defect> getAllDefects(); 
	
	public Defect updateDefectStatus(int statusId); 
	public Defect updateReassignTo(String reassignTo); 
	public Defect updateDefectComment(int commentId); 
	public Defect updateDefectAttachment(int attachmentId);
	public List<Defect> getProjectById (String projectId); 
	public List<Defect> getModuleById (String moduleId); 
	public List<Defect> getDefectByAvailableIn (String availableIn);
	public List<Defect> getDefectByFoundIn (String foundIn);
	public List<Defect> getDefectByFixedIn (String fixedIn);
	
	public List<Defect> getDefectByDate (Date dateAndTime);
	public boolean isDefectAlreadyExist(String defectId);
	public List<Defect> getDefectByStatus(String status); 
	public List<Defect> getDefectByPriority(String priority);
	public List<Defect> getDefectBySeverity(String severity);
	public List<Defect> getDefectByType(String type);
	
	

	     	
}
