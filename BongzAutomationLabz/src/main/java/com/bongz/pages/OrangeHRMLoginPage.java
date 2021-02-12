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
public final class OrangeHRMLoginPage extends BasePage {
	
	private final By textboxUsername = By.id("txtUsername");
	private final By textboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
	private final By buttonLogin = By.id("btnLogin");


	public OrangeHRMLoginPage enterUserName(String username) {
		
		sendKeys(textboxUsername, username, WaitStrategy.PRESENCE,"Username");
		return this;
	}

	public OrangeHRMLoginPage enterPassWord(String password) {
		sendKeys(textboxPassword,password, WaitStrategy.PRESENCE,"Password");
		return this;
	}
	public OrangeHRMHomePage clickLogin() {
		click(buttonLogin, WaitStrategy.PRESENCE, "Login Button");
		return new OrangeHRMHomePage();
	}

	public String getTitle() {
		return getPageTitle();
	}

}
