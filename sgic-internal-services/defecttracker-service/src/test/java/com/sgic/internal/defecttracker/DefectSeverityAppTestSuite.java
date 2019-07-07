package com.sgic.internal.defecttracker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sgic.internal.defecttracker.controller.CreateDefectSeverityTest;
import com.sgic.internal.defecttracker.controller.DeleteDefectPriorityTest;
import com.sgic.internal.defecttracker.controller.GetAllDefectSeveritiesTest;
import com.sgic.internal.defecttracker.controller.GetDefectSeverityByIdTest;
import com.sgic.internal.defecttracker.controller.UpdateDefectSeverityTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CreateDefectSeverityTest.class,
	DeleteDefectPriorityTest.class,
	GetAllDefectSeveritiesTest.class,
	GetDefectSeverityByIdTest.class,
	UpdateDefectSeverityTest.class
})
public class DefectSeverityAppTestSuite {

}
