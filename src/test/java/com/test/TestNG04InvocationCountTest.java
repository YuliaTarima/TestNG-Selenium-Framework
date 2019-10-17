package com.test;

import org.testng.annotations.Test;
/***
 * 
 * @author yulia and tatiana
 * 
 * Demonstration on the repetitive multiple execution 
 * of the same test
 * through invocationCount  
 *
 */

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
