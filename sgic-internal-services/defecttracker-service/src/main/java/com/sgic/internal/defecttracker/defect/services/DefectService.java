package com.sgic.internal.defecttracker.defect.services;


import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.entities.Defect;

@Service
public interface DefectService {

	public Defect createDefect(Defect defect);   
	public Defect getByDefectId(Long defectId);
	public Defect updateDefect(Defect defect);
	public Defect deleteDefect(Long defectId);   
	public List<Defect> getAllDefects(); 
	
	public Defect updateDefectStatus(int statusId); 
	public Defect updateReassignTo(String reassignTo); 
	public Defect updateDefectComment(int commentId); 
	public Defect updateDefectAttachment(int attachmentId);
	public List<Defect> getAllDefectByStatus (int statusId); 
	public List<Defect> getProjectById (Long projectId); 
	public List<Defect> getModuleById (Long moduleId); 
	public List<Defect> getAllSeverityById (int severityId); 
	public List<Defect> getAllPriorityById (int priorityId);
	public List<Defect> getDefectByDate (Date dateAndTime);
	public boolean isDefectAlreadyExist(Long defectId);           
	     	
}
