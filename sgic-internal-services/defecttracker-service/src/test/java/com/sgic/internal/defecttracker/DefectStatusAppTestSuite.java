package com.sgic.internal.defecttracker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sgic.internal.defecttracker.controller.CreateDefectStatusTest;
import com.sgic.internal.defecttracker.controller.DeleteDefectStatusTest;
import com.sgic.internal.defecttracker.controller.GetAllDefectStatusesTest;
import com.sgic.internal.defecttracker.controller.GetByIdDefectStatusTest;
import com.sgic.internal.defecttracker.controller.UpdateDefectStatusTest;


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
