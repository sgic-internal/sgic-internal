package com.sgic.internal.defecttracker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.sgic.internal.defecttracker.controller.CreateDefectPriorityTest;
import com.sgic.internal.defecttracker.controller.DeleteDefectPriorityTest;
import com.sgic.internal.defecttracker.controller.GetAllDefectPrioritiesTest;
import com.sgic.internal.defecttracker.controller.GetDefectPriorityByIdTest;
import com.sgic.internal.defecttracker.controller.UpdateDefectPriorityTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CreateDefectPriorityTest.class,
	GetAllDefectPrioritiesTest.class,
	GetDefectPriorityByIdTest.class,
	DeleteDefectPriorityTest.class,
	UpdateDefectPriorityTest.class
})
public class DefectPriorityAppTestSuite {

}
