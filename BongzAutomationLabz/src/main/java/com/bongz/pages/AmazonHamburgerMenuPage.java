/**
 * 
 */
package com.bongz.pages;

import org.openqa.selenium.By;

import com.bongz.enums.WaitStrategy;
import com.bongz.utils.DynamicXpathUtils;

/**
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public final class AmazonHamburgerMenuPage extends BasePage{
	
	private String linkComputers = "//div[text()='Mobiles, Computers']/parent::a";
	private  String linkSubMenu = "//a[text()='%s']";
	private  String linkSubMenu2 = "//div[text()='%s']/parent::a[text()='%s']";
	
	public AmazonHamburgerMenuPage clickComputer() {
		click(By.xpath(linkComputers), WaitStrategy.CLICKABLE, "Mobiles and Computers");
		return this;
	}
	
	public AmazonLaptopPage clickOnSubMenuItem(String menutext) {
		String newxpath = DynamicXpathUtils.getXpath(linkSubMenu, menutext);
		click(By.xpath(newxpath), WaitStrategy.CLICKABLE, menutext);
		if(menutext.contains("Laptops")) {
			return new AmazonLaptopPage();
		}
		return null;
	}

}
