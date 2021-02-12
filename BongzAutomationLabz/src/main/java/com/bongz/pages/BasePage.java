/**
 * 
 */
package com.bongz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bongz.driver.DriverManager;
import com.bongz.enums.WaitStrategy;
import com.bongz.factories.ExplicitWaitFactory;
import com.bongz.reports.ExtentLogger;

/**
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public class BasePage {

	protected void click(By by, WaitStrategy waitstrategy,String elementname) {
		WebElement element =ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.click();
		ExtentLogger.pass(elementname+" is clicked",true);
		
	}
	
	protected void sendKeys(By by, String value, WaitStrategy waitstrategy,String elementname) {
		WebElement element =ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.sendKeys(value);
		ExtentLogger.pass(value +" is entered successfully in "+elementname, true);
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
}
