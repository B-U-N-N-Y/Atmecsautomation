package com.atmecsautomation.testscripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.atmecsautomation.constants.LoadPropertyFile;
import com.atmecsautomation.dataProvider.TestDataProvider;
import com.atmecsautomation.helpers.CommonUtility;
import com.atmecsautomation.pages.Scenario1Validation;
import com.atmecsautomation.testbase.TestBase;

public class Scenario1 extends TestBase {
	public static int counter = 0;
	public static Logger log;

	@Test(priority = 0, dataProvider = "HomePageTitle", dataProviderClass = TestDataProvider.class)
	public void isRedirectionPage(String title) {
		log= Logger.getLogger(Scenario1.class);
		logger = extent.startTest("Home Page validation");
		Scenario1Validation.directionPage(driver, title,log);
	}

	@Test(priority = 1, dataProvider = "footerdata", dataProviderClass = TestDataProvider.class)
	public void homePageFooter(String[] validatedata) {

		counter++;
		Scenario1Validation.footer(validatedata, counter, log);
		if (counter == 4) {
			counter = 0;
		}
	}

	@Test(priority = 2, dataProvider = "footerdata", dataProviderClass = TestDataProvider.class)
	public void aboutUsFooter(String[] validatedata) {

		if (counter == 0) {
			CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.aboutus.btn"));
		}
		counter++;
		Scenario1Validation.footer(validatedata, counter, log);
		if (counter == 4) {
			counter = 0;
		}
	}

	@Test(priority = 3, dataProvider = "footerdata", dataProviderClass = TestDataProvider.class)
	public void servicesFooter(String[] validatedata) {
		if (counter == 0) {
			CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.services.btn"));
		}
		counter++;
		Scenario1Validation.footer(validatedata, counter, log);
		if (counter == 4) {
			counter = 0;
		}
	}

	@Test(priority = 4, dataProvider = "footerdata", dataProviderClass = TestDataProvider.class)
	public void partnersFooter(String[] validatedata) {
		if (counter == 0) {
			CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.partners.btn"));
		}
		counter++;
		Scenario1Validation.footer(validatedata, counter, log);
		if (counter == 4) {
			counter = 0;
		}
	}

	@Test(priority = 5, dataProvider = "footerdata", dataProviderClass = TestDataProvider.class)
	public void mediaFooter(String[] validatedata) {
		if (counter == 0) {
			CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.media.btn"));
		}
		counter++;
		Scenario1Validation.footer(validatedata, counter, log);
		if (counter == 4) {
			counter = 0;
		}
	}

	@Test(priority = 6, dataProvider = "footerdata", dataProviderClass = TestDataProvider.class)
	public void insightsFooter(String[] validatedata) {
		if (counter == 0) {
			CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.insights.btn"));
		}
		counter++;
		Scenario1Validation.footer(validatedata, counter, log);
		if (counter == 4) {
			counter = 0;
		}
	}

	@Test(priority = 7, dataProvider = "footerdata", dataProviderClass = TestDataProvider.class)
	public void careersFooter(String[] validatedata) {
		if (counter == 0) {
			CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.careers.btn"));
		}
		counter++;
		Scenario1Validation.footer(validatedata, counter, log);
		if (counter == 4) {
			counter = 0;
		}
	}

	@Test(priority = 8, dataProvider = "footerdata", dataProviderClass = TestDataProvider.class)
	public void contactUsFooter(String[] validatedata) {
		if (counter == 0) {
			CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.contactus.btn"));
		}
		counter++;
		Scenario1Validation.footer(validatedata, counter, log);
		if (counter == 4) {
			counter = 0;
		}
	}

	@Test(priority = 9, dataProvider = "MenuOption", dataProviderClass = TestDataProvider.class)
	public void menuOptionvalidation(String[] validatedata) {
		if (counter == 0) {
			Scenario1Validation.digitallifeMenuValidation(driver, validatedata,log);
			counter++;
		} else {
			Scenario1Validation.infrastructureMenuValidation(driver, validatedata,log);
			counter = 0;
		}
	}

}
