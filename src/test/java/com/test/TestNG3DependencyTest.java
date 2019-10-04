package com.test;

import org.testng.annotations.Test;

public class TestNG3DependencyTest {
	
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
