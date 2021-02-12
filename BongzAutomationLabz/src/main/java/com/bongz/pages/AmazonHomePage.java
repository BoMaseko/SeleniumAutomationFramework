/**
 * 
 */
package com.bongz.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bongz.driver.DriverManager;

/**
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public final class AmazonHomePage extends BasePage{
	
	@FindBy(id="nav-hamburger-menu") 
	private WebElement linkHamburger;
	
	/**
	 * Constructor to initialise the page factory elements. It is not recommended to use page factory
	 * This is an sample for demonstration purpose
	 */
	public AmazonHomePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public AmazonHamburgerMenuPage clickHamburger() {
		linkHamburger.click();
		return new AmazonHamburgerMenuPage();
	}

}
