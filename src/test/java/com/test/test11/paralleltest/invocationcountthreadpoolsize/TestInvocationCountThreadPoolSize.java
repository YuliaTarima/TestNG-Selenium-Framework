package com.test.test11.paralleltest.invocationcountthreadpoolsize;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;

public class TestInvocationCountThreadPoolSize extends Base {
	
	@BeforeMethod
	public void setUp() {
		driver = setWebDriverManager("chrome");
		driver.get("http://google.com");
	}

	//invocationCount will launch brouser 5 times
	@Test(invocationCount = 5)
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println("googleTitleTest: Actual page title is "+title);
		Assert.assertEquals(title, "Google", "Message in case of failure: title is not matched");
	}

	//threadPoolSize will launch 5 browser instances at once
	@Test(threadPoolSize = 5)
	public void googleLogoTest() {
		Boolean logo = driver.findElement(By.id("hplogo")).isDisplayed();
		Assert.assertTrue(logo);
	}
	
	@Test(invocationCount = 5, threadPoolSize = 5)
	public void gmailLinkTest() {
		Boolean gmailLink = driver.findElement(By.linkText("Gmail")).isDisplayed();
		Assert.assertTrue(gmailLink);
	}
	
	@AfterMethod
	public void tearDown() {
		killBrowser();
	}

}
