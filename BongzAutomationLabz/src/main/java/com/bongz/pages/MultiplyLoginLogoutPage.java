/**
 * 
 */
package com.bongz.pages;

import org.openqa.selenium.By;

import com.bongz.enums.WaitStrategy;

/**
 * 19 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public final class MultiplyLoginLogoutPage extends BasePage{

	private final By textboxUsername = By.xpath("//input[@id='username']");
	private final By textboxPassword = By.xpath("//input[@id='password-popup' and @type='password']");
	private final By buttonLogin = By.xpath("//*[@class='btn btn-default' and @type='submit']");
	private final By buttonLogout = By.xpath("//div[contains(text(),'LOG OUT')]");
	
	public MultiplyLoginLogoutPage enterUserName(String username) {

		sendKeys(textboxUsername, username, WaitStrategy.PRESENCE,"Username");
		return this;
	}

	public MultiplyLoginLogoutPage enterPassWord(String password) {
		sendKeys(textboxPassword,password, WaitStrategy.PRESENCE,"Password");
		return this;
	}
	/**
	 * Still to decide action after clickLogin ? MultiplyPostLogin
	 * @author Bongz
	 * @return
	 */
	public MultiplyHomePage clickLogin() {
		click(buttonLogin, WaitStrategy.PRESENCE, "Login Button");
		return new MultiplyHomePage();
	}

	public MultiplyHomePage clickLogout() {
		click(buttonLogout, WaitStrategy.PRESENCE, "Logout Button");
		return new MultiplyHomePage();
	}

	public String getTitle() {
		return getPageTitle();
	}

}
