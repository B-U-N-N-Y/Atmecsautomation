package com.atmecsautomation.constants;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
/**
 * This class operate Grid Connection
 * @author arjun.santra
 *
 */
public class GridConnection {
	public static URL url;
	static String nodeurl;
	
	public static WebDriver driver;
	public static void GridCon(WebDriver driver,String browser) {

		nodeurl ="http://55.55.52.203:4444/wd/hub";

		DesiredCapabilities capability = new DesiredCapabilities();
		
		try {
			url = new URL(nodeurl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		capability.setBrowserName(browser);
		capability.setPlatform(Platform.WIN10);
		driver = new RemoteWebDriver(url, capability);
	}
}
