package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng1AnnotationSequence {
		
	//@Before- Prerequisite annotations = preconditions
	
	@BeforeSuite
	public void setUp() {
		System.out.println("+++++++++++++++++++++++++++++++++++\n\n"
				+ "Runs only once for the whole file\n"
				+ "#1 in Sequence @BeforeSuite: Setup system property for chrome\n");
	}
	
	@BeforeTest 
	public void launchBrowser() {
		System.out.println("#2 in Sequence @BeforeTest: Launching chrome browser");
	}
	
	@BeforeClass 
	public void logIn() {
		System.out.println("#3 in Sequence @BeforeClass: Logging into app\n\n"
				+ "++++++++++++++++++++++++++++++++++++++++++++\n");
	}

	@BeforeMethod 
	public void enterURL() {
		System.out.println("This block runs for each test case\n"
				+ "#4 in Sequence @BeforeMethod: Entering URL\n");
	}
	
	//@Test - Test cases
	
	@Test 
	public void googleTitleTest() {
		System.out.println("#5 in Sequence @Test: Google Title Test (Test Case 1)");
	}
	
	@Test
	public void searchTest(){
		System.out.println("#5 in Sequence @Test: Search Test (Test Case 2)");
	}
	
	@Test
	public void googleLogoTest() {
		System.out.println("#5 in Sequence @Test: Google Logo Test (Test Case 3)");
	}
	
	//@After- Post-conditions
	
	@AfterMethod 
	public void logOut() {
		System.out.println("#6 in Sequence @AfterMethod: Logging out of app\n\n"
				+ "+++++++++++++++++++++++++++++++++++++++++++++++++++\n");
	}
	
	@AfterClass 
	public void closeBrowser() {
		System.out.println("Runs after all of test cases are over per file\n"
				+ "#7 in Sequence @AfterClass: Closing Browser\n");
	}
	
	@AfterTest 
	public void deleteAllCookies() {
		System.out.println("#8 in Sequence @AfterTest: Deleting all cookies\n\n"
				+ "++++++++++++++++++++++++++++++++++++++++++++++\n");
	}
	
	@AfterSuite
	public void generateTestReport() {
		System.out.println("#9 in Sequence @AfterSuite: Generating Test Report");
	}

}
