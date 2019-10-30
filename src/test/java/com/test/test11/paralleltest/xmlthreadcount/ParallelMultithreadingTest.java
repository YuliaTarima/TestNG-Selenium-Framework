package com.test.test11.paralleltest.xmlthreadcount;

import java.util.concurrent.ThreadPoolExecutor;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;

public class ParallelMultithreadingTest extends Base {
	
/*
 * Run this from
 * /TestngFramework/src/test/java/com/test/test11/paralleltest/xmlthreadcount/testng.xml
 */
	
	@BeforeMethod
	public void setUp() {
		
	}
	//run this test 3 times on 3 different threads
	@Test(threadPoolSize=3, invocationCount = 3, timeOut = 1000)
	public void test1() {
		setWebDriverManager("chrome", "https://www.google.com/");
		System.out.println("I am inside test 1. Thread: "+Thread.currentThread().getId());
	}
	
	@Test
	public void test2() {
		setWebDriverManager("chrome", "https://www.amazon.com/");
		System.out.println("I am inside test 2. Thread: "+Thread.currentThread().getId());
	}
	
	@Test
	public void test3() {
		setWebDriverManager("chrome", "https://www.starbucks.com/");
		System.out.println("I am inside test 3. Thread: "+Thread.currentThread().getId());
	}
	
	

	@AfterMethod
	public void tearDown() {
		killBrowser();
	}
}
