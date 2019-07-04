package com.sgic.internal.defecttracker.defecttypes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sgic.internal.defecttracker.defecttypes.controller.CreateDefectStatusTest;
import com.sgic.internal.defecttracker.defecttypes.controller.DeleteDefectStatusTest;
import com.sgic.internal.defecttracker.defecttypes.controller.GetAllDefectStatusesTest;
import com.sgic.internal.defecttracker.defecttypes.controller.GetByIdDefectStatusTest;
import com.sgic.internal.defecttracker.defecttypes.controller.UpdateDefectStatusTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	CreateDefectStatusTest.class,
	GetAllDefectStatusesTest.class,
	GetByIdDefectStatusTest.class,
	UpdateDefectStatusTest.class,
	DeleteDefectStatusTest.class
})
public class DefectStatusAppTestSuite {

}
