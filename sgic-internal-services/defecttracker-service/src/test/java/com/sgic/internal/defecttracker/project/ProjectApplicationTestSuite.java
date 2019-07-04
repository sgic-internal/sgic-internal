package com.sgic.internal.defecttracker.project;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


import com.sgic.internal.defecttracker.project.controller.DeleteProject;
import com.sgic.internal.defecttracker.project.controller.GetByName;
import com.sgic.internal.defecttracker.project.controller.GetByProjectId;
import com.sgic.internal.defecttracker.project.controller.GetByStatus;
import com.sgic.internal.defecttracker.project.controller.GetDateProject;
//import com.sgic.internal.defecttracker.project.controller.GetDateProject;
import com.sgic.internal.defecttracker.project.controller.GetDurationProject;
import com.sgic.internal.defecttracker.project.controller.GetTypeProject;
import com.sgic.internal.defecttracker.project.controller.ProjectDevelopmentTest;
import com.sgic.internal.defecttracker.project.controller.UpdateByProject;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ProjectDevelopmentTest.class,
//	GetAllProject.class,
	GetByName.class,
	GetByStatus.class,
	GetDurationProject.class,
//	GetDateProject.class,
	GetTypeProject.class,
	UpdateByProject.class,
	GetByProjectId.class,
	DeleteProject.class,
	GetDateProject.class
	
	
})
public class ProjectApplicationTestSuite {

}

//@RunWith(Suite.class)
//@Suite.SuiteClasses({
//	ProjectDevelopmentTest.class
//})
//public class ProjectApplicationTestSuite {
//
//}

