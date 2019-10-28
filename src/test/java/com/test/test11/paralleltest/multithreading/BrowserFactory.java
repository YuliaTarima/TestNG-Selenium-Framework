package com.test.test11.paralleltest.multithreading;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver createInstance(String browser) {

		WebDriver driver = null;
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("opera")) {
				WebDriverManager.operadriver().setup();

				OperaOptions options = new OperaOptions();
				options.setBinary("C:\\Users\\yulia\\AppData\\Local\\Programs\\Opera\\60.0.3255.170\\opera.exe");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(OperaOptions.CAPABILITY, options);

				driver = new OperaDriver(capabilities);
			} else {
				throw new RuntimeException("Unknown browser: " + browser);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return driver;
	}
}