package com.bongz.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bongz.enums.ConfigProperties;
import com.bongz.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {
	
	private Driver() {}
	
	public static void initDriver(String browser)  {
		if(Objects.isNull(DriverManager.getDriver())) {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				DriverManager.setDriver(new ChromeDriver());
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
			}
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
