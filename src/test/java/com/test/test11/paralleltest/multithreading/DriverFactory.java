package com.test.test11.paralleltest.multithreading;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	private DriverFactory() {
		// Do nothing!
		// Do not allow to initialize this class from outside
	}

	private static DriverFactory instance = new DriverFactory();

	public static DriverFactory getInstance() {
		return instance;
	}

	// sets each webdriver on a unique thread local driver object
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	// gets the driver object and launch the browser
	public WebDriver getDriver() {
		return driver.get();
	}

	// sets the driver object
	public void setDriver(WebDriver driverParam) {
		driver.set(driverParam);
	}

	public void killDriver() {
		driver.get().quit();
	}
}
