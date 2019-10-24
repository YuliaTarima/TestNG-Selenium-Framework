package com.test.test04.dependency;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class TestCase3DependsOnMethods extends BaseTest {
	
/*
 * Simple demonstration of test start
 * depending on success of a previous test.
 * E.g., user login should not happen if the user was unable to register
 * 
 * soft Dependency (alwaysRun=true) dependent test will run even on failure of a previous test
 */
    
	@BeforeTest
    public void creatingDBConn() {
	System.out.println("Creating DB connection");
    }

    @BeforeMethod
    public void launchBrowser() {
	System.out.println("Launching browser");
    }

    @Test(priority = 1, groups = {"functional", "smoke"})
    public void doUserRegistration() {
	System.out.println("Executing user registration test");
	Assert.fail("User registration failed");
    }

    @Test(priority = 2, dependsOnMethods = "doUserRegistration", groups = {"functional", "smoke"})
    public void doUserLogin() {
	System.out.println("Executing login test");
    }

    @Test(priority = 3, dependsOnMethods = {"doUserRegistration", "doUserLogin"}, alwaysRun = true, groups = { "functional", "smoke" })
    public void thirdTest() {
	System.out.println("Executing third test");
    }

    @Test(priority = 4, groups="bvt")
    public void fourthTest() {
	System.out.println("Executing Build Verification Test");
    }
    
    @AfterMethod
    public void closeBrowser() {
	System.out.println("Closing browser");
    }
    
    @AfterTest
    public void closingDBConn() {
	System.out.println("Closing DB connection");
    }


}
