/**
 * 
 */
package com.bongz.driver;

import org.openqa.selenium.WebDriver;

/**
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public final class DriverManager {
	
	private DriverManager() {}
	
	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>() ;
	
	public static WebDriver getDriver() {
		return dr.get();
	}
	
	public static void setDriver(WebDriver driverref) {
		dr.set(driverref);
	}
	
	public static void unload() {
		dr.remove();
	}

}
