package com.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.TestBase;

/*
 * for this to work go to for this to work, go to config.properties 
 * and change url to https://www.google.com/
 */
public class TestNG06GoogleTitleTest extends TestBase{
	
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
	
}