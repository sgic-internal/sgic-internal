package com.sgic.internal.defecttracker.defect.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.defect.entities.Defect;

@Service
public interface DefectService {

	public Defect createDefect(Defect defect);   
	public Defect getByDefectId(String defectId);
	public Defect updateDefectStatus(int statusId); 
	public Defect updateReassignTo(String reassignTo); 
	public Defect updateDefectComment(int commentId); 
	public Defect updateDefectAttachment(int attachmentId); 
	public Defect deleteDefect(String defectId);   
	public List<Defect> getAllDefects(); 
	public List<Defect> getAllDefectByStatus (int statusId); 
	public List<Defect> getProjectById (String projectId); 
	public List<Defect> getModuleById (String moduleId); 
	public List<Defect> getAllSeverityById (int severityId); 
	public List<Defect> getAllPriorityById (int priorityId);
	public List<Defect> getDefectByDate (Date dateAndTime);
	public boolean isDefectAlreadyExist(String defectId);           
	     	
}
