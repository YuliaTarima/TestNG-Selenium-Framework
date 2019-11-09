package com.test.test12.factoryannotation.factorywithdependencies;

import org.testng.annotations.Test;

public class FactoryWithDependenciesTest {
	/**
	 * Demonstration of how to implement dependency
	 * of one test on the precondition
	 * of successful execution of the previous test
	 * 
	 * If the first test fails,
	 * second method will not execute
	 * 
	 * run this from package testng.xml
	 */
	
	@Test
	public void loginTest() {
		System.out.println("Login Test");
		//int i = 9/0;//to fail the test
		//Assert.fail("Failing on purpose");
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