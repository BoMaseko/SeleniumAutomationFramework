
package com.bongz.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

/**
 * DriverManager class helps to achieve thread safety for the {@link org.openqa.selenium.WebDriver} instance.
 * 
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 * 
 * @see Driver
 */
public final class DriverManager {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private DriverManager() {}
	
	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>() ;
	
	/**
	 * Returns the thread safe {@link org.openqa.selenium.WebDriver} instance fetched from ThreadLocal variable.
	 * 
	 * @author Bongz
	 * @return {@link org.openqa.selenium.WebDriver} instance.
	 */
	public static WebDriver getDriver() {
		return dr.get();
	}
	
	/**
	 * Set the WebDriver instance to thread local variable
	 * 
	 * @author Bongz
	 * @param driverref {@link org.openqa.selenium.WebDriver} instance that needs to saved from Thread safety issues.<p>
	 * TODO Disallow null assignment and call unload method instead. public access modifier can be changed to 
	 * default
	 */
	public static void setDriver(WebDriver driverref) {
		if(Objects.nonNull(driverref)) {
			dr.set(driverref);
		}
		
	}
	
	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 * 
	 * @author Bongz
	 * 
	 * TODO public access modifier can be changed to 
	 * default
	 */
	public static void unload() {
		dr.remove();
	}

}
