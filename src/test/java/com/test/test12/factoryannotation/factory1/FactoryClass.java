package com.test.test12.factoryannotation.factory1;

import org.testng.annotations.Factory;

public class FactoryClass {

	@Factory
	public Object[] invokeObjects() {

		Object[] data = new Object[5];
		data[0] = new FactoryAnnotationTest(1);
		data[1] = new FactoryAnnotationTest(2);
		data[2] = new FactoryAnnotationTest(3);
		data[3] = new FactoryAnnotationTest(4);
		data[4] = new FactoryAnnotationTest(5);
		
		return data;
	}
}
