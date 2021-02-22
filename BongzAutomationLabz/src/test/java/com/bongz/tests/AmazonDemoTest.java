/**
 * 
 */
package com.bongz.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.bongz.annotations.FrameworkAnnotation;
import com.bongz.enums.CategoryType;
import com.bongz.pages.AmazonHomePage;

/**
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public final class AmazonDemoTest extends BaseTest{
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private AmazonDemoTest() {}
	
	@Test
	@FrameworkAnnotation(author= {"Bongz"}, 
	category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
	public void amazonTest(Map<String,String> data) {
		
		String title =new AmazonHomePage().clickHamburger()
				.clickComputer()
				.clickOnSubMenuItem(data.get("menutext")).getTitle();
		Assertions.assertThat(title).isNotNull();	
	}

}
