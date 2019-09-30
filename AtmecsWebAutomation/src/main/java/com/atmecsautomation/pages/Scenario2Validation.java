package com.atmecsautomation.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.atmecsautomation.constants.LoadPropertyFile;
import com.atmecsautomation.helpers.CommonUtility;
import com.atmecsautomation.logreports.LogReport;

public class Scenario2Validation {
 static	LogReport logreport=new LogReport();

	
	public static void scenario2Flow(WebDriver driver) {
		Actions action = new Actions(driver);
		WebElement element=CommonUtility.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.header.insights.btn"));
		action.moveToElement(element).build().perform();
		CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.insights.blog.btn"));
		//CommonUtility.clickElement(LoadPropertyFile.locators.getProperty("loc.atmecs.blog.ai.btn"));
	}
	
	
	
	public static void dateValidation(Logger log) {
		int datedifference=getDate();
		Assert.assertFalse(datedifference < 3,"The date difference is not more then 3 month");
		log.info("Date Difference validate succesfully");
	}
	
	
	@SuppressWarnings("deprecation")
	public static int getDate() {

		String string = CommonUtility.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.blog.date")).getText();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
		LocalDate localDate = LocalDate.parse(string, formatter);
	//	System.out.println(localDate); // 2010-01-02

		String local[] = (localDate + "").split("-");

		String day = Calendar.getInstance().getTime() + "";
		Date date = new Date();
		int month = date.getMonth() + 1;
//		System.out.println(day);// 5 2 1 Fri Sep 27 14:28:35 IST 2019
		String[] date1 = day.split(" ");
		//String systemDate = date1[5] + month + date1[2];
	//	System.out.println(systemDate);
		int monthDifference = Integer.parseInt(local[1]) - month;
		if (monthDifference < 0) {
			monthDifference = 12 - monthDifference;
		}

		int yearDifference = Integer.parseInt(local[0]) - Integer.parseInt(date1[5]);
		if (yearDifference > 0) {
			int difference = yearDifference * 12;
			monthDifference = monthDifference + difference;
		}
		return monthDifference;
	}
	
	public static void contentValidtion(Logger log) {

		String text = CommonUtility.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.blog.content")).getText();
		Assert.assertEquals(text, (LoadPropertyFile.validate.getProperty("blog_content")), "Content is not present");
		log.info("Contect validate succesfully");
	}
	
	public static void breadcrumbValidation(Logger log) {
		String text=CommonUtility.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.breadcrumb")).getText();
		Assert.assertEquals(text, (LoadPropertyFile.validate.getProperty("blog_breadcrumb")), "Breadcrumb is not matched");
		log.info("Breadcrub validate succesfully");
	}
	
	public static void errorValidation(Logger log) {
		String text=CommonUtility.getElement(LoadPropertyFile.locators.getProperty("loc.atmecs.error.msg")).getAttribute("required");
		System.out.println(text);
		Assert.assertEquals(text,LoadPropertyFile.validate.getProperty("blog_postcomment_errormsg"),"Error msg not validated");
		log.info("Error msg validate succesfully");
	}
}
