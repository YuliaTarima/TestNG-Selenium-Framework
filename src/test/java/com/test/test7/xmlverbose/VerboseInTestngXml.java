package com.test.test7.xmlverbose;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;

public class VerboseInTestngXml extends Base {

/*
 * run this test from
 * com\test\test7\verbose\veboseTestNG.xml
 */
	
	@BeforeMethod
	public void setUp() {
		initialize("https://www.google.com/");
	}
	
	@Test
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Let's fail this test on purpose");
	}

	@Test
	public void googleLogoTest() {
		Boolean logo = driver.findElement(By.id("hplogo")).isDisplayed();
		Assert.assertTrue(logo);
	}
	
	@Test
	public void googleLoginTest() {
		Assert.assertTrue(true);
	}	

}
