package com.sgic.internal.defecttracker.project.controller.dto;

<<<<<<< HEAD
public class ProjectDto {

	
	private String projectId;
	
	private String projectName;
	
=======
import java.sql.Date;
import org.springframework.stereotype.Component;

@Component
public class ProjectDto {
	
	private String projectId;

	private String projectName;

	private String type;

	private Date startDate;

	private Date endDate ;

	private Long duration;

	private String status;

	private String configId;
>>>>>>> mathu

	public String getProjectId() {
		return projectId;
	}
<<<<<<< HEAD
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	





}
=======

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConfigId() {
		return configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}



//	public ProjectDto (String projectId, String projectName, String type, Date startDate, Date endDate,
//				Long duration, String status, String configId) {
//		super();
//		this.projectId = projectId;
//		this.projectName = projectName;
//		this.type = type;
//		this.startDate = startDate;
//		this.endDate = endDate;
//		this.duration = duration;
//		this.status = status;
//		this.configId = configId;
//	}


}
>>>>>>> mathu
