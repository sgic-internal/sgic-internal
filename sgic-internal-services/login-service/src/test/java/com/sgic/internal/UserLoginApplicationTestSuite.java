package com.sgic.internal;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sgic.internal.userController.UserLoginApplicationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	UserLoginApplicationTest.class
})
public class UserLoginApplicationTestSuite {

}
