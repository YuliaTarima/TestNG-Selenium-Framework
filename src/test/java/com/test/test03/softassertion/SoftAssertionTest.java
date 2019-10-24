package com.test.test03.softassertion;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionTest {
	
	@Test
	public void testMethodOne() {
		
		SoftAssert softAssert1 = new SoftAssert();
		
		System.out.println("Open browser");
		Assert.assertEquals(true, true); //hard assertion terminates execution and test is failed
		
		System.out.println("Enter username");
		System.out.println("Enter password");
		System.out.println("Click on sign in button");
		Assert.assertEquals(true, true); //hard assertion terminates execution and test is failed
		
		System.out.println("Validate home page");
		softAssert1.assertEquals(true, false, "Home page title is missing"); //soft assertion will not terminate execution
		
		System.out.println("Go to deals page");
		System.out.println("Create a deal");
		softAssert1.assertEquals(true, false, "Unable to create a deal"); //soft assertion will not terminate execution
		
		System.out.println("Go to contacts page");
		System.out.println("Create a contact");
		softAssert1.assertEquals(true, false,  "Unable to create a contact"); //soft assertion will not terminate execution
		
		softAssert1.assertAll(); //marks failed test cases
	}
	
	@Test
	public void testMethodTwo() {		
		
		SoftAssert softAssert2 = new SoftAssert();
		System.out.println("Logout");
		softAssert2.assertEquals(true, true); //hard assertion terminates execution and test is failed
		softAssert2.assertAll(); //marks failed test cases
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("tearDown");
	}	

}
