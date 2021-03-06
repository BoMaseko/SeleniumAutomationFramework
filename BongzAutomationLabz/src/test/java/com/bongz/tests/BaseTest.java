
package com.bongz.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.bongz.driver.Driver;

/**
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public class BaseTest {

	protected BaseTest() {}
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) { //Map<String,String>
		Map<String,String> map = (Map<String,String>)data[0];
		Driver.initDriver(map.get("browser"), map.get("version"));
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}
}
