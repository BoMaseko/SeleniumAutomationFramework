/**
 * 
 */
package com.bongz.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.bongz.driver.DriverManager;

/**
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public final class LoginPageTests extends BaseTest {

	private LoginPageTests(){}

	@Test
	public void test2() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);
	}

}
