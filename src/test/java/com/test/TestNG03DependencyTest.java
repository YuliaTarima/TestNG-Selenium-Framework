package com.test;

import org.testng.annotations.Test;

public class TestNG03DependencyTest {
	/**
	 * Demonstration of how to implement dependency
	 * of one test on the precondition
	 * of successful execution of the previous test
	 */
	
	@Test
	public void loginTest() {
		System.out.println("Login Test");
		//int i = 9/0;//to fail the test
	}
	
	@Test(dependsOnMethods="loginTest")
	public void homePageTest() {
		System.out.println("Home Page Test");
	}
	
	@Test
	public void searchPageTest() {
		System.out.println("Search Page Test");
	}

}
