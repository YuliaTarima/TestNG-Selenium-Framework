package com.test.test12.factoryannotation.factory3;

import org.testng.annotations.Factory;

public class FactoryClass {

	@Factory
	public Object[] createFactrory() {

		/*
		 * factory for class GoogleSearchTestWithFactory
		 */

		Object[] invokeClass = new Object[3];
		
		/*
		 * i is how many times the class will be invoked
		 */
		
		for(int i=0; i<=2; i++) {
			invokeClass[i] = new GoogleSearchTestWithFactory();
			System.out.println("I am invokeClass i "+i);
			
		}
		return invokeClass;
	}
}
