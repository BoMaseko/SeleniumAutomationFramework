/**
 * 
 */
package com.bongz.pages;

import org.openqa.selenium.By;

import com.bongz.enums.WaitStrategy;

/**
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public final class OrangeHRMHomePage extends BasePage{
	
	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//a[text()='Logout']");
	
	
	public OrangeHRMHomePage clickWelcome() {
		click(linkWelcome, WaitStrategy.PRESENCE,"Welcome link");
		return this;
	}
	
	
			
	public OrangeHRMLoginPage clickLogout() {
		click(linkLogout, WaitStrategy.CLICKABLE,"Logout button");
		return new OrangeHRMLoginPage();
	}

}
