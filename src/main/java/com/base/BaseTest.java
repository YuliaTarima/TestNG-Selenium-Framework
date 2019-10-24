package com.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    
    @BeforeSuite
    public void setUp() {
	System.out.println("Initializing everything");
    }
    
    @AfterSuite
    public void tearDown() {
	System.out.println("Quitting everything");
    }

}
