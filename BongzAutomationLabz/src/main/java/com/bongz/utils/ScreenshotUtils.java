
package com.bongz.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.bongz.driver.DriverManager;

/**
 * Utility to take base64 screenshot.
 * 
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 * @see  com.bongz.reports.ExtentLogger
 */
public final class ScreenshotUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ScreenshotUtils() {}
	
	/**
	 * Captures screenshot of the current page, constructs a base64 string from the image and return to the caller.
	 * There is no temporary screenshot image generated here. If user needs separate screenshot image, they can construct
	 * a new method. It is advisable to use this method for many reasons.
	 * 
	 * @author Bongz
	 * @return Image in the form of Base64 String which can be appended directly to report
	 */
	public static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
