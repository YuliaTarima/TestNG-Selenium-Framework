package com.test.test02.annotations.groupspriority;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.Base;

public class AssertionsPriorityGroupGoogleTest extends Base {
/*
 * Simple demonstration of
 * assertions
 * priority
 * and groups
 * in TestNG
 */
	
	@BeforeClass
    public void setUp() {
		initialize("https://www.google.com/");
		System.out.println("\n##########\n"+"Before Class: setUp"+"\n##########\n");
	}
	
	@Test (priority=1, groups="Title")
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println("googleTitleTest: Actual page title is "+title);
		Assert.assertEquals(title, "Google", "Message in case of failure: title is not matched");
	}
	
	@Test (priority=2, groups="Logo")
	public void googleLogoTest() {
		Boolean logo = driver.findElement(By.id("hplogo")).isDisplayed();
		Assert.assertTrue(logo);
	}
	
	@Test (priority=3, groups="Link")
	public void gmailLinkTest() {
		Boolean gmailLink = driver.findElement(By.linkText("Gmail")).isDisplayed();
		Assert.assertTrue(gmailLink);
	}
	
	@Test (priority=4, groups="Link")
	public void imagesLinkTest() {
		Boolean imagesLink = driver.findElement(By.linkText("Images")).isDisplayed();
		Assert.assertTrue(imagesLink);
	}
	
	@Test (priority=5, groups="Link")
	public void aboutLinkTest() {
		Boolean aboutLink = driver.findElement(By.linkText("About")).isDisplayed();
		Assert.assertTrue(aboutLink);
	}
	
	@Test (priority=6, groups="Link")
	public void storeLinkTest() {
		Boolean storeLink = driver.findElement(By.linkText("Store")).isDisplayed();
		Assert.assertTrue(storeLink);
	}
	
	@AfterClass
	public void tearDown() {
		killBrowser();
		System.out.println("\n##########\n"+"After Class: tearDown"+"\n##########\n");
		driver.quit();
		Reporter.log("Browser Session End");
	}
}