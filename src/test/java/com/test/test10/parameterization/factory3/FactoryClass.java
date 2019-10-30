package com.test.test10.parameterization.factory3;

import org.testng.annotations.Factory;

public class FactoryClass {

	@Factory
	public Object[] invokeObjects() {

		Object[] data = new Object[5];
		data[0] = new GoogleSearchTestWithFactory(1);
		data[1] = new GoogleSearchTestWithFactory(2);
		data[2] = new GoogleSearchTestWithFactory(3);
		data[3] = new GoogleSearchTestWithFactory(4);
		data[4] = new GoogleSearchTestWithFactory(5);
		
		return data;
	}
}
