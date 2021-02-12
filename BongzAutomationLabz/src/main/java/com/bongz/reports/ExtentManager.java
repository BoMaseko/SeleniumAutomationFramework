/**
 * 
 */
package com.bongz.reports;

import com.aventstack.extentreports.ExtentTest;

/**
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public class ExtentManager {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentManager() {}

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>() ;
	
	public static ExtentTest getExtentTest() { //default --> it can be only accessed within the package --> private packages
		return extTest.get();
	}

	static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}
	
	static void unload() {
		extTest.remove();
	}

}
