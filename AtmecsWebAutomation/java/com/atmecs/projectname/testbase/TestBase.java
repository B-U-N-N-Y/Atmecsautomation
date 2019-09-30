package com.atmecs.projectname.testbase;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.atmecs.projectname.constants.FilePath;
import com.atmecs.projectname.constants.LoadPropertyFile;
import com.atmecs.projectname.extentreports.ExtentReport;
import com.atmecs.projectname.utils.ReadPropertiesFile;

/**
 * This class operate to choose the driver
 * 
 * @author arjun.santra
 *
 */
public class TestBase extends ExtentReport {

	Properties baseClass;
	String url;
	public static String browser;
	int downloadFile;
	LoadPropertyFile property=new LoadPropertyFile();

	@BeforeTest
	public void intitailizeBrowser() throws IOException {

		baseClass = ReadPropertiesFile.loadProperty(FilePath.CONFIG_FILE);
		url = baseClass.getProperty("url");
		browser = baseClass.getProperty("browser");

		System.out.println("browser is " + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", FilePath.CHROME_PATH);

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", FilePath.FIREFOX_PATH);
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

}
