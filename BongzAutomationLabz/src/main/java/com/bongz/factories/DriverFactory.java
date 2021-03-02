/**
 * 
 */
package com.bongz.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.bongz.driver.DriverManager;
import com.bongz.enums.ConfigProperties;
import com.bongz.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 01 Mar 2021
 * @author Bongz
 * @version 1.0
 */
public final class DriverFactory {
	
	private DriverFactory() {}
	
	public static WebDriver getDriver(String browser) throws MalformedURLException {
		
		WebDriver driver = null;
		
		String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);

					driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), cap);
				
			}else {	
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			
			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);

				driver = new RemoteWebDriver(new URL("http://192.168.99.100:4445/wd/hub"), cap);
			}else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}

}
