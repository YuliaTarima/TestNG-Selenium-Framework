package com.test.test07.listeners.onfailure.screenshot;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.test.test07.listeners.onfailure.screenshot.BaseTest;

@Listeners(FailedTestScreenshotListener.class)
public class FailedTestScreenshotWithListener extends BaseTest {

	@BeforeMethod
	public void setUp() {
		initialize("https://www.google.com/", "chrome");
		System.out.println("\n##########\n"+"Before Class: setUp"+"\n##########\n");
	}
	
	@Test
	public void loginTest() {
		Assert.assertEquals(false, true, "loginTest: screenshotFailedTest");
	}
	
	@Test
	public void homePageTest() {
		Assert.assertEquals(false, true, "homePageTest: screenshotFailedTest");
	}
	
	@Test
	public void searchTest() {
		Assert.assertEquals(false, true, "searchTest: screenshotFailedTest");
	}
	
	@Test
	public void createContactsTest() {
		Assert.assertEquals(false, true, "createContactsTest screenshotFailedTest");
	}
	
	@AfterMethod
	public void tearDown() {
		killBrowser();
		System.out.println("\n##########\n"+"After Class: tearDown"+"\n##########\n");
		driver.quit();
		Reporter.log("Browser Session End");
	}
	
}
