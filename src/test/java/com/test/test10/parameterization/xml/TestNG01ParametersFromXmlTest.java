package com.test.test10.parameterization.xml;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.util.TestUtil;

public class TestNG01ParametersFromXmlTest {
	
	/*
	 * Simple demonstration of Parameters annotation in TestNG xml file
	 * See how Parameters are set here: com\test\test10\parameterization\xml\testNG01Parameters.xml
	 * 
	 * This test will only run from com\test\test10\parameterization\xml\testNG01Parameters.xml
	 * otherwise will not have environment configuration variables/properties
	 * and will throw an error that parameters are missing
	 * */
	
	WebDriver driver;
	
	@BeforeMethod 
	@Parameters({"browser", "url"})
	
	public void setUp(String browser, String url) {
	
	
	if (browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	} else if (browser.equals("FF")) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	driver.get(url);
	driver.findElement(By.id("uh-signin")).click();
	}
	
	@Test
	@Parameters({"username", "password"})
	public void yahooLoginTest(String username, String password) {
		driver.findElement(By.id("login-username")).clear();
		driver.findElement(By.id("login-username")).sendKeys(username);
		driver.findElement(By.id("login-signin")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
