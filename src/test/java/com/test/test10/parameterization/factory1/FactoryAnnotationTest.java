package com.test.test10.parameterization.factory1;

import org.testng.annotations.Test;

/*
 * Simple demonstration 
 * of @Factory annotation
 * 
 * Run this from the factory class at
 * /TestngFramework/src/test/java/com/test/test10/parameterization/dataprovider/factory/FactoryClass.java
 * 
 *  
 * @Factory marks a method as a factory
 * that returns objects
 * that will be used by TestNG
 * as Test classes
 * 
 * The method must return Object[]
 * 
 * Factories allow to create tests dynamically
 * analogy to invocation-count
 */

public class FactoryAnnotationTest {
	//param is how many times test is invoked
	int param;
	
	public FactoryAnnotationTest(int param) {
		this.param = param;
		
	}
	
	@Test
	public void TC1() {
		System.out.println("Test Case 1 param is: "+param);
	}
	
	@Test
	public void TC2() {
		System.out.println("Test Case 2 param is: "+param);
	}
	
	@Test
	public void TC3() {
		System.out.println("Test Case 3 param is: "+param);
	}

	
	@Test
	public void TC4() {
		System.out.println("Test Case 4 param is: "+param);
	}
	
	@Test
	public void TC5() {
		System.out.println("Test Case 5 param is: "+param);
	}
}
