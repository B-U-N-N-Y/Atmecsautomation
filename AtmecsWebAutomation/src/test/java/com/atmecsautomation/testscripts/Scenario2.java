package com.atmecsautomation.testscripts;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.atmecsautomation.constants.LoadPropertyFile;
import com.atmecsautomation.helpers.CommonUtility;
import com.atmecsautomation.pages.Scenario2Validation;
import com.atmecsautomation.testbase.TestBase;

public class Scenario2 extends TestBase {
	public static Logger log;

	@Test(priority = 10)
	public void blogPage() {
		log = Logger.getLogger(Scenario2.class);
		logger = extent.startTest("Insights validation");
		Scenario2Validation.scenario2Flow(driver);

	}

	@Test(priority = 11)
	public void blogDateValidation() {
		Scenario2Validation.dateValidation(log);
	}

	@Test(priority = 12)
	public void blogContentValidation() {
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.blog.ai.btn"));
		Scenario2Validation.contentValidtion(log);
	}

	@Test(priority = 13)
	public void blogBreadcrum() {
		Scenario2Validation.breadcrumbValidation(log);

	}

	@Test(priority = 14)
	public void errorMsgValidation() {
		CommonUtility.scrollDownPage(0, 4500);
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.blog.comment.submit"));
		Scenario2Validation.errorValidation(log);
	}

}
