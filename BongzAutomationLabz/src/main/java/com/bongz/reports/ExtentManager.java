
package com.bongz.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

/**
 * ExtentManager class helps to achieve thread safety for the {@link com.aventstack.extentreports.ExtentTest} instance.
 * 
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 * @see Driver
 */
public class ExtentManager {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentManager() {}

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>() ;
	
	/**
	 * Returns the thread safe {@link com.aventstack.extentreports.ExtentTest} instance fetched from ThreadLocal variable.
	 * 
	 * @author Bongz
	 * @return Thread safe {@link com.aventstack.extentreports.ExtentTest} instance.
	 */
	public static ExtentTest getExtentTest() { //default --> it can be only accessed within the package --> private packages
		return extTest.get();
	}

	/**
	 * Set the {@link com.aventstack.extentreports.ExtentTest} instance to thread local variable
	 * 
	 * @author Bongz
	 * @param test {@link com.aventstack.extentreports.ExtentTest} instance that needs to saved from Thread safety issues.<p>
	 * TODO Disallow null assignment and call unload method instead.
	 */
	static void setExtentTest(ExtentTest test) {
		if(Objects.nonNull(test)) {
			extTest.set(test);
		}
		
	}
	
	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 * 
	 * @author Bongz
	 */
	static void unload() {
		extTest.remove();
	}

}
