
package com.bongz.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.bongz.enums.ConfigProperties;
import com.bongz.utils.PropertyUtils;
import com.bongz.utils.ScreenshotUtils;

/**
 * Used for logging the events in the extent report.
 * <p>
 * Encapsulates the unnecessary methods from users
 * 
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public final class ExtentLogger {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentLogger() {}
	
	/**
	 * Logs pass event in the extent report
	 * @author Bongz
	 * @param message custom message that needs to be logged
	 */
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}
	
	/**
	 * Logs fail event in the extent report
	 * @author Bongz
	 * @param message custom message that needs to be logged
	 */
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}
	
	/**
	 * Logs skip event in the extent report
	 * @author Bongz
	 * @param message custom message that needs to be logged
	 */
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	
	/**
	 * Logs pass event in the extent report based on user input in property file
	 * 
	 * @author Bongz
	 * @param message custom message that needs to be logged
	 * @param isScreenshotNeeded appends screenshot when true ,ignore otherwise
	 */
	public static void pass(String message, boolean isScreenshotNeeded) {
		if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotNeeded ) {
			ExtentManager.getExtentTest()
				.pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}
	
	/**
	 * Logs fail event in the extent report based on user input in property file
	 * 
	 * @author Bongz
	 * @param message custom message that needs to be logged
	 * @param isScreenshotNeeded appends screenshot when true ,ignore otherwise
	 */
	public static void fail(String message, boolean isScreenshotNeeded) {
		if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotNeeded ) {
			ExtentManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			fail(message);
		}
	}
	
	/**
	 * Logs skip event in the extent report based on user input in property file
	 * 
	 * @author Bongz
	 * @param message custom message that needs to be logged
	 * @param isScreenshotNeeded appends screenshot when true ,ignore otherwise
	 */
	public static void skip(String message, boolean isScreenshotNeeded)  {
		if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotNeeded ) {
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			skip(message);
		}
	}

}
