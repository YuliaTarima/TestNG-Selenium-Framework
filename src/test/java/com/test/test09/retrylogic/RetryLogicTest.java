package com.test.test09.retrylogic;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;

public class RetryLogicTest extends TestBase {

	/*
	 * purposely fail with manual retry logic per single @Test
	 * 
	 * not a good approach to pass IRetryAnalyzer in each @Test for multiple
	 * testcases	 
	 * Run this from the test class
	 */ 
	 @Test(retryAnalyzer = RetryAnalyzer.class) 
	 public void testMethodOne() {
	 System.out.println("testMethodOne"); 
	 Assert.assertEquals(false, true); 
	 }
	 

	/**
	 * Alternative: dynamic failure listener 
	 * with IAnnotationTransformer+IRetryAnalyzer from TestNG 
	 * run this from com\test\test5\retrylogic\testngRetryLogic.xml
	 */
	@Test
	public void testMethodTwo() {
		System.out.println("testMethodTwo");
		Assert.assertEquals(false, true);
	}

	@Test
	public void testMethodThree() {
		System.out.println("testMethodThree");
		Assert.assertEquals(false, true);
	}

}