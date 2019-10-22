package com.test.test6.screenshotfailed;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class FailedTestScreenshot extends ScreenshotTestBase {

	@BeforeMethod
	public void setUp() {
		initialization();
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
		finishUp();
	}	
	
}
