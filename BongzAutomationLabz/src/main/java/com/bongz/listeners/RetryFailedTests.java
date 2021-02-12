/**
 * 
 */
package com.bongz.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.bongz.enums.ConfigProperties;
import com.bongz.utils.PropertyUtils;

/**
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public class RetryFailedTests implements IRetryAnalyzer{
	
	private int count=0;
	private int retries = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		boolean value =false;

		if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
			value = count<retries ;
			count++;
		} 
		return value;
	}

}
