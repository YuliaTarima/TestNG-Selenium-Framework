package com.test;

import org.testng.annotations.Test;

public class TestNG04InvocationCountTest {
	
	
	//execute this test 10 times
	@Test(invocationCount = 10)
	public void sum() {
		int a = 10;
		int b = 20;
		int c = a + b;
		System.out.println("Sum is: "+c);
	}

}
