package com.sgic.internal.defecttracker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sgic.internal.defecttracker.controller.CreateDefectTypeTest;
import com.sgic.internal.defecttracker.controller.DeleteDefectTypeTest;
import com.sgic.internal.defecttracker.controller.GetAllDefectTypesTest;
import com.sgic.internal.defecttracker.controller.GetByIdDefectTypeTest;
import com.sgic.internal.defecttracker.controller.UpdateDefectTypeTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	CreateDefectTypeTest.class,
	GetAllDefectTypesTest.class,
	GetByIdDefectTypeTest.class,
	DeleteDefectTypeTest.class,
	UpdateDefectTypeTest.class
})
public class DefectTypeAppTestSuite {

}
