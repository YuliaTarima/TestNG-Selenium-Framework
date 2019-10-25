package com.test.test07.listeners.onfailure.screenshot.xml;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;

public class ScreenshotFromXmlTest extends Base {
/**
 * Run this test from 
 * com/test/test07/listeners/onfailure/screenshot/xml/screenshotonfailure.xml
 */

	@BeforeMethod
	public void setUp() {
		setWebDriverManager("chrome", "https://mail.google.com/");
	}

	@Test(priority = 1)
	public void doLogin() {
		
		WebElement email = driver.findElement(By.id("identifierIdError"));
		email.clear();
		email.sendKeys("russianusa.tarima@gmail.com");
		System.out.println("Was able to enter email");

		driver.findElement(By.id("identifierNext")).click();
		System.out.println("Was able to click on the login next button");
	}

	@Test(priority = 2)
	public void composeEmail() {
		Assert.fail("Error in composing email");
	}

	@AfterMethod
	public void tearDown() {
		killBrowser();
	}

}
