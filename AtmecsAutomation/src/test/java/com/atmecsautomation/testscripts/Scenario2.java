package com.atmecsautomation.testscripts;

import org.testng.annotations.Test;

import com.atmecsautomation.pages.Scenario2Validation;
import com.atmecsautomation.testbase.TestBase;

public class Scenario2 extends TestBase {
	
	
	@Test()
	public void test() {
		Scenario2Validation.scenario2Flow(driver);
	}

}
