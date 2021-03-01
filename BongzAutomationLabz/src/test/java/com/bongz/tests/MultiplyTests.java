
package com.bongz.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.bongz.annotations.FrameworkAnnotation;
import com.bongz.enums.CategoryType;
import com.bongz.pages.MultiplyHomePage;

/**
 * 19 Feb 2021
 * @author Bongz
 * @version 1.0
 */
public final class MultiplyTests extends BaseTest{
	
	private MultiplyTests() {}
	
	@Test
	@FrameworkAnnotation(author= {"Bongz"}, 
	category = {CategoryType.REGRESSION})
	public void multiplyLoginLogoutTest(Map<String,String> data) {
		new MultiplyHomePage().clinkLoginLink().enterUserName(data.get("username")).enterPassWord("password").clickLogin();
	}
	
	@Test
	@FrameworkAnnotation(author= {"Bongz"}, 
	category = {CategoryType.REGRESSION})
	public void multiplyRewardsTest(Map<String,String> data) {
		new MultiplyHomePage().clickRewards().getTitle();
	}
	
	@Test
	@FrameworkAnnotation(author= {"Bongz"}, 
	category = {CategoryType.REGRESSION})
	public void multiplyOptionsTest(Map<String,String> data) {
		new MultiplyHomePage().clickOptions().clickPremier().getTitle();
	}
	
	

}
