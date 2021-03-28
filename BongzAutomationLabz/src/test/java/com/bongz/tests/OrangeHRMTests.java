/**
 * 
 */
package com.bongz.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.bongz.annotations.FrameworkAnnotation;
import com.bongz.enums.CategoryType;
import com.bongz.pages.OrangeHRMLoginPage;

/**
 * 11 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public final class OrangeHRMTests extends BaseTest{
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private OrangeHRMTests() {}
	
	@Test
	@FrameworkAnnotation(author= {"Bongz"}, 
	category = {CategoryType.REGRESSION})
	public void loginLogoutTest(Map<String,String> data) {
		
		String title = new OrangeHRMLoginPage()
				.enterUserName(data.get("username")).enterPassWord(data.get("password")).clickLogin()
				.clickWelcome().clickLogout()
				.getTitle();
		Assertions.assertThat(title)
			.isEqualTo("OrangeHRM");
		
	}
	
	@Test
	public void newTest(Map<String,String> data) {
		String title = new OrangeHRMLoginPage()
				.enterUserName(data.get("username")).enterPassWord(data.get("password")).clickLogin()
				.clickWelcome().clickLogout()
				.getTitle();
		throw new SkipException("Skipped");
		
		
	}

}
