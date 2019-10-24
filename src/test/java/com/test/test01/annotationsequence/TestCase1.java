package com.test.test01.annotationsequence;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class TestCase1 extends BaseTest {

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Launching browser");
	}

	@BeforeTest
	public void creatingDBConn() {
		System.out.println("Creating DB connection");
	}
	
	@Test(priority = 2, groups = "functional")
	public void doLogin() {
		System.out.println("Executing login test");

	}

	@Test(priority = 1, groups = "functional")
	public void doUserRegistration() {
		System.out.println("Executing user registration test");

	}

	@AfterTest
	public void closingDBConn() {
		System.out.println("Closing DB connection");
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("Closing browser");
	}

}
