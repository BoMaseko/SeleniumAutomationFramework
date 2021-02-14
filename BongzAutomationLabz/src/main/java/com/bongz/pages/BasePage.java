
package com.bongz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bongz.driver.DriverManager;
import com.bongz.enums.WaitStrategy;
import com.bongz.factories.ExplicitWaitFactory;
import com.bongz.reports.ExtentLogger;


public class BasePage {
	

	/**
	 * Locates element by given wait strategy, performs the clicking operation on webelement and
	 * writes the pass even to the extent report.
	 * @author Bongz
	 * @param by By Locator of the webelement
	 * @param waitstrategy Strategy to find webelement. Known  strategies {@link com.bongz.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
	protected void click(By by, WaitStrategy waitstrategy,String elementname) {
		WebElement element =ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.click();
		ExtentLogger.pass(elementname+" is clicked",true);
		
	}
	
	/**
	 * Locates element by given wait strategy, sends the value to located webelement and
	 * writes the pass even to the extent report.
	 * @author Bongz
	 * @param by By Locator of the webelement
	 * @param value value to be send the text box
	 * @param waitstrategy Strategy to find webelement. Known  strategies {@link com.bongz.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
	protected void sendKeys(By by, String value, WaitStrategy waitstrategy,String elementname) {
		WebElement element =ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.sendKeys(value);
		ExtentLogger.pass(value +" is entered successfully in "+elementname, true);
	}
	
	/**
	 * Return page title of webpage in String
	 * @author Bongz
	 * @return Page title of the webpage where the selenium is currently interacting.
	 */
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
}
