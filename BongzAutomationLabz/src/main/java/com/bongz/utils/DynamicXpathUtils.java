/**
 * 
 */
package com.bongz.utils;

/**
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public final class DynamicXpathUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private DynamicXpathUtils() {}
	
	public static String getXpath(String xpath, String value) {
		return String.format(xpath, value);//a[text()='%s'] 
	}
	
	public static String getXpath(String xpath, String value1, String value2) {
		return String.format(xpath, value1,value2);
	}
}
