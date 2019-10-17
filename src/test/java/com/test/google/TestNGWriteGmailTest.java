package com.test.google;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.GmailTestBase;

public class TestNGWriteGmailTest extends GmailTestBase {
	
	@BeforeMethod
	public void logIn() {
		System.out.println("========\n"+"Logging user in"+"\n*");
	}

	@Test (priority=1, groups="Title")
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println("TC1 - googleTitleTest: Actual page title is "+title);
		Assert.assertEquals(title, "Gmail", "Message in case of failure: title is not matched");
	}
	
	@Test (priority=2, groups="Logo")
	public void googleLogoTest() {
		Boolean logo = driver.findElement(By.id("logo")).isDisplayed();
		System.out.println("Test case 2: googleLogoTest");
		Assert.assertTrue(logo);
	}
	
	@Test (priority=3, groups="Mail")
	public void composeEmailTest() {
		System.out.println("Test case 3: composeEmailTest");
	}
	
	@Test (priority=4, groups="Mail")
	public void deleteEmailTest() {
		System.out.println("Test case 4: deleteEmailTest");
	}
	
	@Test (priority=5, groups="Mail", enabled=true)
	public void searchEmailTest() {
		System.out.println("Test case 5: searchEmailTest");
		int impossibleInt = 7/0;//let's purposely fail this test to see the failed result
		System.out.println(impossibleInt);
	}
	
	@Test (priority=6, groups="Mail", enabled=false)
	public void sentMailTest() {
		System.out.println("Test case 6: sentMailTest");	
	}
	
	@AfterMethod
	public void logOut() {
		System.out.println("*\n"+"Logging user out"+"\n========");
	}	
}
