
package com.bongz.pages;

import org.openqa.selenium.By;

import com.bongz.enums.WaitStrategy;

/**
 * 19 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public final class MultiplyHomePage extends BasePage{

	private final By loginLink = By.xpath("//div[@class='stBannerMenus']//div[3]//a[@id='mtLoginLink']");
	private final By rewardsButton = By.xpath("//a[@id='Z6_PQ842HC0NOSD30QCGVEBIT30G7']");
	private final By optionsButton = By.xpath("//a[@id='Z6_JHG0G280N0BR40AB2RD35314R7']");
	private final By updateBrowserNotification = By.xpath("//a[@id='buorgig']");
	

	public MultiplyLoginLogoutPage clinkLoginLink() {
		click(updateBrowserNotification, WaitStrategy.CLICKABLE, "Ignored");
		click(loginLink, WaitStrategy.CLICKABLE,"Login link");
		return new MultiplyLoginLogoutPage();
		
	}
	
	public MultiplyRewardsPage clickRewards() {
		click(rewardsButton, WaitStrategy.CLICKABLE, "Rewards");
		return new MultiplyRewardsPage();
	}
	
	public MultiplyOptionsPage clickOptions() {
		click(optionsButton, WaitStrategy.CLICKABLE, "Options");
		return new MultiplyOptionsPage();
	}

	
}
