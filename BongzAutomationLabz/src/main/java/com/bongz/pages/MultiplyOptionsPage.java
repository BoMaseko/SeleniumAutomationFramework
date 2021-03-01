/**
 * 
 */
package com.bongz.pages;

import org.openqa.selenium.By;

import com.bongz.enums.WaitStrategy;

/**
 * 23 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public final class MultiplyOptionsPage extends BasePage {

	
	private final By optionsPremier = By.xpath("//a[contains(text(),'Premier')]");


	public MultiplyOptionsPage clickPremier() {
		click(optionsPremier, WaitStrategy.CLICKABLE, "Premier");
		return this;

	}

	public String getTitle() {
		return getPageTitle();
	}

}
