package com.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;

public class TestNG02GoogleTest extends TestBase{
/*
 * for this to work go to for this to work, go to config.properties 
 * and change url to https://www.google.com/
 */
	
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
	}
	
	@Test (priority=4, groups="Link")
	public void imagesLinkTest() {
		Boolean imagesLink = driver.findElement(By.linkText("Images")).isDisplayed();
	}
	
	@Test (priority=5, groups="Link")
	public void aboutLinkTest() {
		Boolean aboutLink = driver.findElement(By.linkText("About")).isDisplayed();
	}
	
	@Test (priority=6, groups="Link")
	public void storeLinkTest() {
		Boolean storeLink = driver.findElement(By.linkText("Store")).isDisplayed();
	}
}