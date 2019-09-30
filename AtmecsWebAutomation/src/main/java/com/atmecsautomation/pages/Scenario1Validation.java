package com.atmecsautomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.atmecsautomation.constants.LoadPropertyFile;
import com.atmecsautomation.helpers.CommonUtility;
import com.atmecsautomation.logreports.LogReport;

public class Scenario1Validation {
	static LogReport logreport=new LogReport();

	public static void footer(String[] validatedata, int counter,Logger log) {

		switch (counter) {
		case 1:
			WebElement element = CommonUtility
					.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.footer.sitemap.txt"));
			footerValidation(validatedata, element,log);
			break;
		case 2:
			WebElement element1 = CommonUtility
					.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.footer.services.txt"));
			footerValidation(validatedata, element1,log);
			break;
		case 3:
			WebElement element2 = CommonUtility
					.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.footer.careers.txt"));
			footerValidation(validatedata, element2,log);
			break;
		case 4:
			WebElement element3 = CommonUtility
					.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.footer.contactus.txt"));
			footerValidation(validatedata, element3,log);
			break;
		}
	}

	private static void footerValidation(String[] validatedata, WebElement element,Logger log) {
		String[] val = element.getText().split("\n");
		int datasize = val.length;
		for (int intial = 0; intial < datasize; intial++) {
			Assert.assertEquals(validatedata[intial], val[intial], "Footer data not matched");
			log.info("Footer data match:" + val[intial] + ", " + validatedata[intial]);
		}
	}

	public static void directionPage(WebDriver driver, String title,Logger log) {

		Assert.assertEquals(driver.getTitle(), title, "Direction Page is Not Landing");
		log.info("Home Page Landing properly");
	}

	public static void digitallifeMenuValidation(WebDriver driver, String[] validatedata,Logger log) {
		Actions action = new Actions(driver);
		WebElement wb = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.services.btn"));
		action.moveToElement(wb).build().perform();
		WebElement wb1 = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.services.digitallife.btn"));
		action.moveToElement(wb1).build().perform();
		WebElement element = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.services.digitallife.option.txt"));
		String[] val = element.getText().split("\n");
		int datasize = val.length;
		for (int intial = 0; intial < datasize; intial++) {
			System.out.println(val[intial]);
			System.out.println(validatedata[intial]);
			Assert.assertEquals(validatedata[intial], val[intial], "Digital life menu not working");
			log.info("Digital menu validate:" + val[intial] + ", " + validatedata[intial]);
		}
	}

	public static void infrastructureMenuValidation(WebDriver driver, String[] validatedata, Logger log) {
		Actions action = new Actions(driver);
		WebElement wb1 = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.services.infrastructure.btn"));
		action.moveToElement(wb1).build().perform();
		WebElement element = CommonUtility
				.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.services.infrastructure.option.txt"));
		String[] val = element.getText().split("\n");
		int datasize = val.length;
		for (int intial = 0; intial < datasize; intial++) {
//			System.out.println(val[intial]);
//			System.out.println(validatedata[intial]);
			Assert.assertEquals(validatedata[intial], val[intial], "Infrastructure menu not working");
			log.info("Infrastructure services menu validate:" + val[intial] + ", " + validatedata[intial]);
		}
	}

}
