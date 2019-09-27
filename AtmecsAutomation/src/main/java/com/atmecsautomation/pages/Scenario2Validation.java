package com.atmecsautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.atmecsautomation.constants.LoadPropertyFile;
import com.atmecsautomation.helpers.CommonUtility;

public class Scenario2Validation {

	
	public static void scenario2Flow(WebDriver driver) {
		Actions action = new Actions(driver);
		WebElement element=CommonUtility.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.insights.btn"));
		action.moveToElement(element).build().perform();
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.insights.blog.btn"));
		CommonUtility.clickElement("(//a[contains(@class,'gitem-link vc-zone-link')])[2]");
	}
}
