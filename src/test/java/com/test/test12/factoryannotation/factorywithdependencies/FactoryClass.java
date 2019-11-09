package com.test.test12.factoryannotation.factorywithdependencies;

import org.testng.annotations.Factory;

public class FactoryClass {

	@Factory
	public Object[] createFactory() {

		/*
		 * factory for class GoogleSearchTestWithFactory
		 * 
		 * run this from package testng.xml
		 */

		Object[] invokeClass = new Object[3];
		
		/*
		 * i is how many times the class will be invoked
		 */
		
		for(int i=0; i<=2; i++) {
			invokeClass[i] = new FactoryWithDependenciesTest();
			System.out.println("I am invokeClass i "+i);
			
		}
		return invokeClass;
	}
}
