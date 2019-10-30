package com.test.test02.annotations.dependson.methods;

import org.testng.annotations.Test;

public class TestNG03DependencyTest {
	/**
	 * Demonstration of how to implement dependency
	 * of one test on the precondition
	 * of successful execution of the previous test
	 * 
	 * If the first test fails,
	 * second method will not execute
	 */
	
	@Test
	public void loginTest() {
		System.out.println("Login Test");
		//int i = 9/0;//to fail the test
	}
	
	@Test(dependsOnMethods="loginTest")//will not execute if loginTest fails
	public void homePageTest() {
		System.out.println("Home Page Test");
	}
	
	@Test
	public void searchPageTest() {
		System.out.println("Search Page Test");
	}

}