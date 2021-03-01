/*
MIT License
Copyright (c) 2021 Bongani Maseko
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package com.bongz.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.bongz.enums.ConfigProperties;
import com.bongz.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Driver class is responsible for invoking and closing the browsers.
 * 
 * <p>
 * It is also responsible for 
 * setting the driver variable to DriverManager which handles the thread safety for the 
 * webdriver instance.
 * 
 * 14 Feb 2021
 * @author Bongz
 * @version 1.0
 * 
 * @see DriverManager
 * @see com.bongz.tests.BaseTest
 */
public final class Driver {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private Driver() {}

	/**
	 * Gets the browser value and initialise the browser based on that
	 * 
	 * @author Bongz
	 * @param browser Value will be passed from {@link com.bongz.tests.BaseTest}. Values can be chrome and firefox
	 */
	public static void initDriver(String browser)  {

		String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);

		if(Objects.isNull(DriverManager.getDriver())) {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				if (runmode.equalsIgnoreCase("remote")) {
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setBrowserName(BrowserType.CHROME);

					try {
						DriverManager.setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				}else {				
					DriverManager.setDriver(new ChromeDriver());
				}
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				if (runmode.equalsIgnoreCase("remote")) {
					DesiredCapabilities cap = new DesiredCapabilities();
					cap.setBrowserName(BrowserType.FIREFOX);

					try {
						DriverManager.setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				}else {
					DriverManager.setDriver(new FirefoxDriver());
				}
			}
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}
	}

	/**
	 * Terminates the browser instance.
	 * Sets the threadlocal to default value, i.e null.
	 * @author Bongz
	 */
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
