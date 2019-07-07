package com.sgic.internal.defecttracker.module;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sgic.internal.defecttracker.module.controller.DeleteModule;
import com.sgic.internal.defecttracker.module.controller.GetAllModule;
import com.sgic.internal.defecttracker.module.controller.GetByModuleId;
import com.sgic.internal.defecttracker.module.controller.GetByModuleName;
import com.sgic.internal.defecttracker.module.controller.UpdateModule;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	GetAllModule.class,
	GetByModuleId.class,
	GetByModuleName.class,
	DeleteModule.class,
	UpdateModule.class
	
})
public class ModuleTestSuite {
	
}