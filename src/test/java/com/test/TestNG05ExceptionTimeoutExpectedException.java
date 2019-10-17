package com.test;

import org.testng.annotations.Test;

public class TestNG05ExceptionTimeoutExpectedException {
	
	/*
	 * If we expect the exception to happen
	 * (e.g. it should happen and is not a bug)
	 * We can force not to fail the test
	 * with expectedExceptions
	 */
	
//	@Test(invocationTimeOut = 1000)// max execution time
//	public void infiniteLoopTest() {
//		int i = 1;
//		while(i == 1) {
//			System.out.println(i);
//		}
//	}
	
	//we expect this exception
	//so do not fail the test
	@Test(expectedExceptions = NumberFormatException.class)
	public void test1() {
		String x = "100A";
		Integer.parseInt(x);
	}

}
